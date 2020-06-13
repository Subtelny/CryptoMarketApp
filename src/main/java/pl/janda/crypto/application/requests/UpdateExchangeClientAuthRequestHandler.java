package pl.janda.crypto.application.requests;

import pl.janda.crypto.infrastructure.exchange.ClientExchangeAuthorization;
import pl.janda.crypto.application.session.ClientSession;
import pl.janda.crypto.application.session.ClientSessions;

import javax.inject.Singleton;

@Singleton
public class UpdateExchangeClientAuthRequestHandler implements RequestHandler<UpdateExchangeClientAuthRequest> {

    private final ClientSessions clientSessions;

    public UpdateExchangeClientAuthRequestHandler(ClientSessions clientSessions) {
        this.clientSessions = clientSessions;
    }

    @Override
    public void handle(UpdateExchangeClientAuthRequest request) {
        ClientSession session = clientSessions.getSession(request.getClientId());
        //session.addAuthorization(request.getExchangeType(), new ClientExchangeAuthorization(null, request.getParameters()));
    }

}
