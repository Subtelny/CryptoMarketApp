package pl.janda.crypto.application.session;

import com.google.common.collect.Maps;
import pl.janda.crypto.application.ClientId;

import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class ClientSessions {

    private Map<ClientId, ClientSession> clientSessions = Maps.newConcurrentMap();

    public void registerSession(ClientId clientId) {
        clientSessions.put(clientId, new ClientSession(clientId));
    }

    public void removeSession(ClientId clientId) {
        clientSessions.remove(clientId);
    }

    public ClientSession getSession(ClientId clientId) {
        return clientSessions.get(clientId);
    }

    public boolean hasSession(ClientId clientId) {
        return clientSessions.containsKey(clientId);
    }

}
