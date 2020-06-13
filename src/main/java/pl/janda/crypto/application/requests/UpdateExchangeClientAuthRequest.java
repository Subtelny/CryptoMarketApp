package pl.janda.crypto.application.requests;

import pl.janda.crypto.domain.exchange.ExchangeType;
import pl.janda.crypto.application.ClientId;

import java.util.Map;
import java.util.Objects;

public class UpdateExchangeClientAuthRequest {

    private final ClientId clientId;

    private final ExchangeType exchangeType;

    private final Map<String, String> parameters;

    public UpdateExchangeClientAuthRequest(ClientId clientId, ExchangeType exchangeType, Map<String, String> parameters) {
        this.clientId = clientId;
        this.exchangeType = exchangeType;
        this.parameters = parameters;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public ExchangeType getExchangeType() {
        return exchangeType;
    }

    public ClientId getClientId() {
        return clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateExchangeClientAuthRequest that = (UpdateExchangeClientAuthRequest) o;
        return Objects.equals(clientId, that.clientId) &&
                exchangeType == that.exchangeType &&
                Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, exchangeType, parameters);
    }
}
