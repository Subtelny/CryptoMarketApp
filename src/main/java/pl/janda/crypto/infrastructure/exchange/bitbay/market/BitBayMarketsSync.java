package pl.janda.crypto.infrastructure.exchange.bitbay.market;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.janda.crypto.infrastructure.exchange.DataSyncCargo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BitBayMarketsSync extends DataSyncCargo<MarketsData> {

    private static final String TICKER_URL = "https://api.bitbay.net/rest/trading/ticker";

    @Override
    protected MarketsData syncData() {
        String responseJson = sendRequest();
        return parseJsonIntoData(responseJson);
    }

    private String sendRequest() {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(BitBayMarketsSync.TICKER_URL)).build();
            HttpClient client = HttpClient.newHttpClient();
            return client.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        //TODO handle exception
        return null;
    }

    private MarketsData parseJsonIntoData(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, MarketsDTO.class).toMarketsData();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //TODO handle exception
        return null;
    }

    @Override
    protected int outdatedEverySeconds() {
        return 0;
    }
}
