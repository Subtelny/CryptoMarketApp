package pl.janda.crypto.infrastructure.sockets.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.janda.crypto.application.ClientId;
import pl.janda.crypto.application.session.ClientSessions;
import pl.janda.crypto.infrastructure.sockets.requests.SocketRequest;
import pl.janda.crypto.infrastructure.sockets.requests.SocketRequestFrame;
import pl.janda.crypto.infrastructure.sockets.requests.SocketRequestProvider;

@ServerWebSocket("/application/api")
public class AppSocketServer {

    private static final Logger logger = LoggerFactory.getLogger(AppSocketServer.class);

    private final ClientSessions clientSessions;

    private final SocketRequestProvider requestProvider;

    public AppSocketServer(ClientSessions clientSessions, SocketRequestProvider requestProvider) {
        this.clientSessions = clientSessions;
        this.requestProvider = requestProvider;
    }

    @OnOpen
    public void onOpen(WebSocketSession session) {
        ClientId clientId = toClientId(session);
        clientSessions.registerSession(clientId);
    }

    @OnMessage
    public void onMessage(String message, WebSocketSession session) {
        ClientId clientId = toClientId(session);
        SocketRequest socketRequest = null;
        try {
            socketRequest = toSocketRequest(message);
        } catch (JsonProcessingException | ClassNotFoundException e) {
            logger.error("Exception while parsing request " + e.getMessage());
        }
        requestProvider.provideRequest(clientId, socketRequest);
    }

    private SocketRequest toSocketRequest(String json) throws JsonProcessingException, ClassNotFoundException {
        SocketRequestFrame socketRequest = new ObjectMapper().readValue(json, SocketRequestFrame.class);
        Class<?> aClass = Class.forName(SocketRequestFrame.class.getPackageName() + "." + socketRequest.getRequestType());
        Object mappedRequest = new ObjectMapper().readValue(socketRequest.getJson(), aClass);
        return (SocketRequest) mappedRequest;
    }

    @OnClose
    public void onClose(WebSocketSession session) {
        ClientId clientId = toClientId(session);
        clientSessions.removeSession(clientId);
    }

    private ClientId toClientId(WebSocketSession session) {
        return new ClientId(session.getId());
    }

}
