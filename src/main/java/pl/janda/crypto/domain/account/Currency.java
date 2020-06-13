package pl.janda.crypto.domain.account;

import pl.janda.crypto.util.SimpleId;

public class Currency extends SimpleId<String> {
    public Currency(String internal) {
        super(internal);
    }
}
