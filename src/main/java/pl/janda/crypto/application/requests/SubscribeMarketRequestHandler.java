package pl.janda.crypto.application.requests;

import pl.janda.crypto.application.session.ClientSession;
import pl.janda.crypto.application.session.ClientSessions;

import javax.inject.Singleton;

@Singleton
public class SubscribeMarketRequestHandler implements RequestHandler<SubscribeMarketRequest> {

    private  final ClientSessions clientSessions;

    public SubscribeMarketRequestHandler(ClientSessions clientSessions) {
        this.clientSessions = clientSessions;
    }

    @Override
    public void handle(SubscribeMarketRequest request) {
        ClientSession session = clientSessions.getSession(request.getClientId());
    }

}
