package com.spotdata.credentials;

import com.spotdata.model.SpotifyCredentials;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class DotenvCredentialProviderTest {

    @Test
    void testLoadCredentialsFromDotenv() throws IOException {
        Path tempEnv = Files.createTempFile(".env", "");
        Files.writeString(tempEnv, 
            "SPOTIFY_CLIENT_ID=test-id\n" +
            "SPOTIFY_CLIENT_SECRET=test-secret\n"
        );

        try {
            DotenvCredentialProvider provider = new DotenvCredentialProvider(tempEnv.getParent().toString(), tempEnv.getFileName().toString());
            SpotifyCredentials credentials = provider.getCredentials();

            assertEquals("test-id", credentials.clientId());
            assertEquals("test-secret", credentials.clientSecret());
        } finally {
            Files.deleteIfExists(tempEnv);
        }
    }
}
