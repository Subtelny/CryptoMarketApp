package pl.janda.crypto.domain.account;

import pl.janda.crypto.util.SimpleId;

public class AccountId extends SimpleId<String> {
    public AccountId(String internal) {
        super(internal);
    }
}
