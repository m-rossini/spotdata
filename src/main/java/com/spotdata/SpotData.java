package com.spotdata;

import com.spotdata.credentials.DotenvCredentialProvider;
import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpotData {
    private static final Logger logger = LoggerFactory.getLogger(SpotData.class);

    public static void main(String[] args) {
        logger.info("Starting SpotData application...");
        
        try {
            Dotenv dotenv = Dotenv.load();
            String redirectUri = dotenv.get("SPOTIFY_REDIRECT_URI");
            
            SpotifyClient client = new SpotifyClient(new DotenvCredentialProvider(), redirectUri);
            logger.info("SpotData is ready to connect to Spotify.");
        } catch (Exception e) {
            logger.error("Failed to initialize SpotData", e);
        }
    }
}
