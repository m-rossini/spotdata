package com.spotdata.credentials;

import com.spotdata.model.SpotifyCredentials;
import io.github.cdimascio.dotenv.Dotenv;

public class DotenvCredentialProvider implements CredentialProvider {
    private final Dotenv dotenv;

    public DotenvCredentialProvider() {
        this(".", ".env");
    }

    public DotenvCredentialProvider(String directory, String filename) {
        this.dotenv = Dotenv.configure()
                .directory(directory)
                .filename(filename)
                .ignoreIfMissing()
                .load();
    }

    @Override
    public SpotifyCredentials getCredentials() {
        return new SpotifyCredentials(
                dotenv.get("SPOTIFY_CLIENT_ID"),
                dotenv.get("SPOTIFY_CLIENT_SECRET")
        );
    }
}
