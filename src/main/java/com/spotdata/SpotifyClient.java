package com.spotdata;

import com.spotdata.credentials.CredentialProvider;
import com.spotdata.model.SpotifyCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;

import java.net.URI;

public class SpotifyClient {
    private static final Logger logger = LoggerFactory.getLogger(SpotifyClient.class);
    private final SpotifyApi spotifyApi;

    public SpotifyClient(CredentialProvider credentialProvider, String redirectUriStr) {
        SpotifyCredentials credentials = credentialProvider.getCredentials();
        
        String clientId = credentials.clientId();
        String clientSecret = credentials.clientSecret();
        URI redirectUri = SpotifyHttpManager.makeUri(redirectUriStr);

        if (clientId == null || clientSecret == null || redirectUri == null) {
            logger.error("Missing Spotify credentials or redirect URI");
            throw new RuntimeException("Missing configuration");
        }

        this.spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setRedirectUri(redirectUri)
                .build();
        
        logger.info("Spotify API client initialized successfully");
    }

    public SpotifyApi getSpotifyApi() {
        return spotifyApi;
    }
}
