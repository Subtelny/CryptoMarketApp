package pl.janda.crypto.infrastructure.exchange.bitbay.market;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.janda.crypto.domain.account.Currency;
import pl.janda.crypto.domain.exchange.market.MarketCode;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MarketsDTO {

    public String status;

    @JsonIgnore
    public Set<String> marketCodes;

    @JsonProperty("items")
    public void unpackItems(Map<String, Object> items) {
        marketCodes = items.keySet();
    }

    public MarketsData toMarketsData() {
        List<MarketCode> marketCodes = this.marketCodes.stream().map(s -> {
            String[] split = s.split("-");
            return new MarketCode(new Currency(split[0]), new Currency(split[1]));
        }).collect(Collectors.toList());
        return new MarketsData(marketCodes);
    }

}
