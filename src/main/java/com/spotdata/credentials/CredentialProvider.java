package com.spotdata.credentials;

import com.spotdata.model.SpotifyCredentials;

public interface CredentialProvider {
    SpotifyCredentials getCredentials();
}
