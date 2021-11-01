package com.umgcodechallenge.umgcodechallenge.Authorization;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class ClientCredentialsAuthorization {

    private static final String clientID = "1d3a96c043814ff68c9b131b675a6727";
    private static final String clientSecret = "da171b2baff444238acfe37c6167bea7";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(clientID)
            .setClientSecret(clientSecret).build();

    private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();

    public static String clientCredentials_Sync() {
        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            System.out.println("Access Token: " + clientCredentials.getAccessToken());
            System.out.println("Expires in: " + clientCredentials.getExpiresIn());

            return clientCredentials.getAccessToken().toString();

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

}
