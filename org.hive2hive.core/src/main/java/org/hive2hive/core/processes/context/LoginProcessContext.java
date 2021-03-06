package org.hive2hive.core.processes.context;

import java.security.KeyPair;

import org.hive2hive.core.model.versioned.Locations;
import org.hive2hive.core.model.versioned.UserProfile;
import org.hive2hive.core.processes.login.SessionParameters;
import org.hive2hive.core.security.UserCredentials;

public class LoginProcessContext {

	private final UserCredentials credentials;
	private final SessionParameters params;

	private UserProfile userProfile;
	private Locations locations;

	public LoginProcessContext(UserCredentials credentials, SessionParameters params) {
		this.credentials = credentials;
		this.params = params;
	}

	public UserCredentials consumeUserCredentials() {
		return credentials;
	}

	public String consumeUserId() {
		return credentials.getUserId();
	}

	public SessionParameters consumeSessionParameters() {
		return params;
	}

	public void provideUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public KeyPair consumeUserLocationsProtectionKeys() {
		return userProfile.getProtectionKeys();
	}

	public void provideLocations(Locations locations) {
		this.locations = locations;
	}

	public Locations consumeLocations() {
		return locations;
	}

}
