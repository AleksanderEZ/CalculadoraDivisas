package calculadoradivisas.view;

import calculadoradivisas.model.Currency;

public interface CurrencyLoader {
    Currency [] load(String path);
}
