# SpotData

A Java-based tool to fetch data from your Spotify account using the Spotify Web API.

## Setup

1. **Spotify Developer Account**:
   - Go to the [Spotify Developer Dashboard](https://developer.spotify.com/dashboard).
   - Create a new App.
   - Note down your `Client ID` and `Client Secret`.
   - Add `http://localhost:8888/callback` as a Redirect URI in your app settings.

2. **Environment Variables**:
   - Copy `.env.example` to `.env`.
   - Fill in your credentials:
     ```bash
     cp .env.example .env
     ```

3. **Build**:
   - Ensure you have Maven installed.
   - Build the project:
     ```bash
     mvn clean install
     ```

## Usage

Run the main application:
```bash
mvn exec:java -Dexec.mainClass="com.spotdata.SpotData"
```

## Logging

Logging is configured via `src/main/resources/logback.xml`. By default, it logs to the console.
