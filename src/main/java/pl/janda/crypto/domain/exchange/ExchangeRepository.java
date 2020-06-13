package pl.janda.crypto.domain.exchange;

public interface ExchangeRepository {

    Exchange getExchange(ExchangeId exchangeId);

}
