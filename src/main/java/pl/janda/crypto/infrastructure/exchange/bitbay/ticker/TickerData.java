package pl.janda.crypto.infrastructure.exchange.bitbay.ticker;

public class TickerData {

    private final double highestBid;

    private final double lowestBid;

    private final double rate;

    private final double previousRate;

    public TickerData(double highestBid, double lowestBid, double rate, double previousRate) {
        this.highestBid = highestBid;
        this.lowestBid = lowestBid;
        this.rate = rate;
        this.previousRate = previousRate;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public double getLowestAsk() {
        return lowestBid;
    }

    public double getRate() {
        return rate;
    }

    public double getPreviousRate() {
        return previousRate;
    }
}
