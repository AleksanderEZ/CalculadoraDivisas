package calculadoradivisas.view;

import calculadoradivisas.model.Currency;
import calculadoradivisas.model.ExchangeRate;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GoogleExchangeRateLoader implements ExchangeRateLoader{

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        String url = "https://www.google.com/search?q=exchange+rate";
        
        url += "+" + from.getCode();
        url += "+" + to.getCode();
        
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException ex) {
            System.out.println("Error at ExchangeRate:: IO, " + ex.getMessage());
        }
        
        Elements element = doc.select("span.DFlfde.SwHCTb");
        String string = element.text();
        string = string.replace(",", ".");
        
        System.out.println(string);
        
        return new ExchangeRate(from, to, Double.parseDouble(string));
    }

}
