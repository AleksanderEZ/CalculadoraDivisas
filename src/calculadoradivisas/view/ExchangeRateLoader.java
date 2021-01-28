package calculadoradivisas.view;

import calculadoradivisas.model.Currency;
import calculadoradivisas.model.ExchangeRate;

public interface ExchangeRateLoader {

    ExchangeRate load (Currency from, Currency to);
    
}
