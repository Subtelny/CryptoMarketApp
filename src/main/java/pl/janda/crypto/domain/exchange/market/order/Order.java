package pl.janda.crypto.domain.exchange.market.order;

import com.google.common.base.Preconditions;

import java.util.Objects;

public class Order {

    private final Double rate;

    private final Double currentCryptoAmount;

    private final Double startingCryptoAmount;

    private final Double cryptoAmountBeforeLastChange;

    private final Double offersCount;

    public Order(Double rate, Double currentCryptoAmount, Double startingCryptoAmount, Double cryptoAmountBeforeLastChange, Double offersCount) {
        this.rate = Preconditions.checkNotNull(rate, "Rate cannot be null");
        this.currentCryptoAmount = Preconditions.checkNotNull(currentCryptoAmount, "CurrentCryptoAmount cannot be null");
        this.startingCryptoAmount = Preconditions.checkNotNull(startingCryptoAmount, "StartingCryptoAmount cannot be null");
        this.cryptoAmountBeforeLastChange = Preconditions.checkNotNull(cryptoAmountBeforeLastChange, "CryptoAmountBeforeLastChange cannot be null");
        this.offersCount = Preconditions.checkNotNull(offersCount, "OffersCount cannot be null");
    }

    public Double getRate() {
        return rate;
    }

    public Double getCurrentCryptoAmount() {
        return currentCryptoAmount;
    }

    public Double getStartingCryptoAmount() {
        return startingCryptoAmount;
    }

    public Double getCryptoAmountBeforeLastChange() {
        return cryptoAmountBeforeLastChange;
    }

    public Double getOffersCount() {
        return offersCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(rate, order.rate) &&
                Objects.equals(currentCryptoAmount, order.currentCryptoAmount) &&
                Objects.equals(startingCryptoAmount, order.startingCryptoAmount) &&
                Objects.equals(cryptoAmountBeforeLastChange, order.cryptoAmountBeforeLastChange) &&
                Objects.equals(offersCount, order.offersCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, currentCryptoAmount, startingCryptoAmount, cryptoAmountBeforeLastChange, offersCount);
    }
}
