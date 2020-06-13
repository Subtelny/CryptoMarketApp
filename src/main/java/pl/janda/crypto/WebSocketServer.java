package pl.janda.crypto;

import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import org.reactivestreams.Publisher;

import java.util.function.Predicate;

@ServerWebSocket("/wbs/{user}")
public class WebSocketServer {

    private WebSocketBroadcaster broadcaster;

    public WebSocketServer(WebSocketBroadcaster broadcaster) {
        this.broadcaster = broadcaster;
    }

    @OnOpen
    public Publisher<String> onOpen(String user, WebSocketSession session) {
        String msg = "[" + user + "] Connected! " + session.getId();
        System.out.println("onOpen " + msg);
        return broadcaster.broadcast(msg, isValid(user, session));
    }

    @OnMessage
    public Publisher<String> onMessage(String user, String message, WebSocketSession session) {
        String msg = "[" + user + "] Messaged: " + message + " " + session.getId();
        System.out.println("onMessage " + msg);
        return broadcaster.broadcast("Thanks");
    }

    @OnClose
    public Publisher<String> onClose(String user, WebSocketSession session) {
        String msg = "[" + user + "] Disconnected!";
        System.out.println("onClose " + msg);
        return broadcaster.broadcast(msg, isValid(user, session));
    }

    private Predicate<WebSocketSession> isValid(String topic, WebSocketSession session) {
        return s -> s != session && topic.equalsIgnoreCase(s.getUriVariables().get("user", String.class, null));
    }

}
