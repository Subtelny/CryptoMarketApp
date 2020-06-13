package pl.janda.crypto.infrastructure.sockets.requests;

import pl.janda.crypto.application.ClientId;
import pl.janda.crypto.application.requests.RequestHandler;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Singleton
public class SocketRequestProvider {

    private final List<RequestHandler<?>> requestHandlers;

    @Inject
    public SocketRequestProvider(List<RequestHandler<?>> requestHandlers) {
        this.requestHandlers = requestHandlers;
    }

    public void provideRequest(ClientId socketId, SocketRequest request) {
        Object domainRequest = request.toDomain(socketId);
        RequestHandler requestHandler = requestHandlers.stream()
                .filter(handler -> matchGenericClass(handler, domainRequest.getClass()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Not found request handler for class " + request.getClass()));
        requestHandler.handle(domainRequest);
    }

    private boolean matchGenericClass(RequestHandler<?> handler, Class<?> requestClass) {
        return  ((ParameterizedType) handler.getClass().getGenericInterfaces()[0])
                .getActualTypeArguments()[0]
                .equals(requestClass);
    }

}
