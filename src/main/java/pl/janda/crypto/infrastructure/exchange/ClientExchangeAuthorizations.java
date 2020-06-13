package pl.janda.crypto.infrastructure.exchange;

import pl.janda.crypto.application.ClientId;

import javax.inject.Singleton;
import java.util.*;

@Singleton
public class ClientExchangeAuthorizations {

    private Map<ClientId, List<ClientExchangeAuthorization>> authorizations = new HashMap<>();

    public Optional<ClientExchangeAuthorization> findClientExchangeAuthorization(ClientId clientId, Exchange exchange) {
        return authorizations.getOrDefault(clientId, new ArrayList<>()).stream()
                .filter(clientExchangeAuthorization -> clientExchangeAuthorization.getExchange().equals(exchange))
                .findAny();
    }

    public void addClientExchangeAuthorization(ClientId clientId, ClientExchangeAuthorization authorization) {
        if (!authorizations.containsKey(clientId)) {
            authorizations.put(clientId, new ArrayList<>());
        }
        authorizations.get(clientId).add(authorization);
    }

    public void removeClientExchangeAuthorization(ClientId clientId, Exchange exchange) {
        authorizations.getOrDefault(clientId, new ArrayList<>())
                .removeIf(authorization -> authorization.getExchange().equals(exchange));
    }

    public void removeAllClientExchangeAuthorizations(ClientId clientId) {
        authorizations.remove(clientId);
    }

}
