package pl.janda.crypto.infrastructure.sockets.requests;

import pl.janda.crypto.domain.exchange.ExchangeType;
import pl.janda.crypto.application.ClientId;
import pl.janda.crypto.application.requests.UpdateExchangeClientAuthRequest;

import java.util.Map;
import java.util.Objects;

public class UpdateExchangeClientAuthSocketRequest implements SocketRequest<UpdateExchangeClientAuthRequest> {

    private ExchangeType exchangeType;

    private Map<String, String> parameters;

    private UpdateExchangeClientAuthSocketRequest() {

    }

    public UpdateExchangeClientAuthSocketRequest(ExchangeType exchangeType, Map<String, String> parameters) {
        this.exchangeType = exchangeType;
        this.parameters = parameters;
    }

    public ExchangeType getExchangeType() {
        return exchangeType;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    @Override
    public UpdateExchangeClientAuthRequest toDomain(ClientId socketId) {
        return new UpdateExchangeClientAuthRequest(socketId, exchangeType, parameters);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateExchangeClientAuthSocketRequest that = (UpdateExchangeClientAuthSocketRequest) o;
        return exchangeType == that.exchangeType &&
                Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exchangeType, parameters);
    }
}
