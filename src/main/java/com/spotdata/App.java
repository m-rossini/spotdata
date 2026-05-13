package com.spotdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Starting SpotData application...");
        
        try {
            SpotifyClient client = new SpotifyClient();
            logger.info("SpotData is ready to connect to Spotify.");
            // Further implementation would go here (e.g., Auth flow)
        } catch (Exception e) {
            logger.error("Failed to initialize SpotData", e);
        }
    }
}
