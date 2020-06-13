package pl.janda.crypto.application.session;

import pl.janda.crypto.domain.exchange.Exchange;
import pl.janda.crypto.infrastructure.exchange.ClientExchangeAuthorization;
import pl.janda.crypto.application.ClientId;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ClientSession {

    private final ClientId clientId;

    private final Map<Exchange, ClientExchangeAuthorization> authorizations = new HashMap<>();

    public ClientSession(ClientId clientId) {
        this.clientId = clientId;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public void removeAuthorization(Exchange exchange) {
        authorizations.remove(exchange);
    }

    public void addAuthorization(Exchange exchange, ClientExchangeAuthorization authorization) {
        authorizations.put(exchange, authorization);
    }

    public ClientExchangeAuthorization getAuthorization(Exchange exchange) {
        return authorizations.get(exchange);
    }

    public Map<Exchange, ClientExchangeAuthorization> getAuthorizations() {
        return authorizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientSession that = (ClientSession) o;
        return Objects.equals(clientId, that.clientId) &&
                Objects.equals(authorizations, that.authorizations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, authorizations);
    }
}
