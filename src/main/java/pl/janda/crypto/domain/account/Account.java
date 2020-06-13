package pl.janda.crypto.domain.account;

import java.util.List;

public interface Account {

    AccountId getAccountId();

    List<Wallet> getWallets();

    void addWallet(Wallet wallet);

    void removeWallet(Wallet wallet);

}
