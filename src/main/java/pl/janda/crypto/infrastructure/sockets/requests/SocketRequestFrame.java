package pl.janda.crypto.infrastructure.sockets.requests;

import java.util.Objects;

public class SocketRequestFrame {

    private String requestType;

    private String json;

    private SocketRequestFrame() {

    }

    public SocketRequestFrame(String requestType, String json) {
        this.requestType = requestType;
        this.json = json;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getJson() {
        return json;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocketRequestFrame that = (SocketRequestFrame) o;
        return Objects.equals(requestType, that.requestType) &&
                Objects.equals(json, that.json);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestType, json);
    }
}
