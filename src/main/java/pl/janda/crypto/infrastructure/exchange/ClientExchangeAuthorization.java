package pl.janda.crypto.infrastructure.exchange;

import java.util.Map;
import java.util.Objects;

public class ClientExchangeAuthorization {

    private final Exchange exchange;

    private final Map<String, String> parameters;

    public ClientExchangeAuthorization(Exchange exchange, Map<String, String> parameters) {
        this.exchange = exchange;
        this.parameters = parameters;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public Exchange getExchange() {
        return exchange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientExchangeAuthorization that = (ClientExchangeAuthorization) o;
        return Objects.equals(exchange, that.exchange) &&
                Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exchange, parameters);
    }
}
