package pl.janda.crypto.application.requests;

public interface RequestHandler<T> {

    void handle(T request);

}
