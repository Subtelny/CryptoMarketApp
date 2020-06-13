package pl.janda.crypto.infrastructure.exchange.bitbay.ticker;

import pl.janda.crypto.domain.exchange.market.MarketCode;
import pl.janda.crypto.infrastructure.exchange.HttpDataSync;

public class BitBayTickerSync extends HttpDataSync<TickerData> {

    private static final String TICKER_URL = "https://api.bitbay.net/rest/trading/ticker";

    private static final int OUTDATED_IN_SECONDS = 5;

    private final MarketCode marketCode;

    public BitBayTickerSync(MarketCode marketCode) {
        this.marketCode = marketCode;
    }

    @Override
    protected TickerData syncData() {
        String rawUrl = buildTickerUrl();
        String responseJson = sendRequest(rawUrl);
        return parseJsonIntoData(responseJson, TickerDTO.class).toTickerData();
    }

    private String buildTickerUrl() {
        return String.format(
                TICKER_URL + "/%s-%s",
                marketCode.getFirstCurrency().getInternal(),
                marketCode.getSecondCurrency().getInternal()
        );
    }

    @Override
    protected int outdatedEverySeconds() {
        return OUTDATED_IN_SECONDS;
    }

}
