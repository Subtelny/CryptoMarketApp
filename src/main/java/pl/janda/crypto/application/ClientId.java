package pl.janda.crypto.application;

import pl.janda.crypto.util.SimpleId;

public class ClientId extends SimpleId<String> {
    public ClientId(String internal) {
        super(internal);
    }
}
