package com.spotdata;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;

import java.net.URI;

public class SpotifyClient {
    private static final Logger logger = LoggerFactory.getLogger(SpotifyClient.class);
    private final SpotifyApi spotifyApi;

    public SpotifyClient() {
        Dotenv dotenv = Dotenv.load();
        
        String clientId = dotenv.get("SPOTIFY_CLIENT_ID");
        String clientSecret = dotenv.get("SPOTIFY_CLIENT_SECRET");
        URI redirectUri = SpotifyHttpManager.makeUri(dotenv.get("SPOTIFY_REDIRECT_URI"));

        if (clientId == null || clientSecret == null || redirectUri == null) {
            logger.error("Missing Spotify credentials in .env file");
            throw new RuntimeException("Missing Spotify credentials");
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
