package pl.janda.crypto.infrastructure.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class HttpDataSync<T> extends DataSyncCargo<T> {

    protected String sendRequest(String rawUrl) {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(rawUrl)).build();
            HttpClient client = HttpClient.newHttpClient();
            return client.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        //TODO handle exception
        return null;
    }

    protected <D> D parseJsonIntoData(String json, Class<D> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //TODO handle exception
        return null;
    }

}
