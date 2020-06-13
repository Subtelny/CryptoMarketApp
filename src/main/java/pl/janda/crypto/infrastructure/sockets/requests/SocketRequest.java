package pl.janda.crypto.infrastructure.sockets.requests;

import pl.janda.crypto.application.ClientId;

public interface SocketRequest<T> {

    T toDomain(ClientId socketId);

}
