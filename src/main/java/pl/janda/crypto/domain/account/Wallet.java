package pl.janda.crypto.domain.account;

public interface Wallet {

    WalletId getWalletId();

    Currency getCurrency();

    double getAvailableFunds();

    double getLockedFunds();

    double getTotalFunds();

}
