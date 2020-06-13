package pl.janda.crypto.infrastructure.exchange.bitbay.ticker;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pl.janda.crypto.application.exchange.MarketTickerResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerDTO {

    public Ticker ticker;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Ticker {

        public double highestBid;

        public double lowestAsk;

        public double rate;

        public double previousRate;

    }

    public MarketTickerResponse toResponse() {
        return new MarketTickerResponse(ticker.highestBid, ticker.lowestAsk, ticker.rate, ticker.previousRate);
    }

    public TickerData toTickerData() {
        return new TickerData(ticker.highestBid, ticker.lowestAsk, ticker.rate, ticker.previousRate);
    }

}
