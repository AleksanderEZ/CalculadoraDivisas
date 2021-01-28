package calculadoradivisas.view;

import calculadoradivisas.model.Currency;
import java.io.IOException;

public interface CurrencyLoader {
    Currency [] load() throws IOException;
}
