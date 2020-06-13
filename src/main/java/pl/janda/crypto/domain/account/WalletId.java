package pl.janda.crypto.domain.account;

import pl.janda.crypto.util.SimpleId;

public class WalletId extends SimpleId<String> {
    public WalletId(String internal) {
        super(internal);
    }
}
