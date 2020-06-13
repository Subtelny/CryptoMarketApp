package pl.janda.crypto;

import java.io.Serializable;

public class Message implements Serializable {

    private final String internal;



    public Message(String msg) {
        this.internal = msg + ":][";
    }

    public String getInternal() {
        return internal;
    }
}
