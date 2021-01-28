package calculadoradivisas.view;

import calculadoradivisas.model.Currency;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileCurrencyLoader implements CurrencyLoader{

    @Override
    public Currency[] load() throws IOException {
        Set<Currency> currency = new HashSet<>();
        File file = new File("file.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (Exception ex) {
            System.out.println("Error en la lectura del fichero");
        }
        
        while(true){
            String line;
            line = reader.readLine();
            if(line == null) break;
            
            String [] partio = line.split(";");
            
            currency.add(new Currency(partio[0], partio[1], partio[2]));
        }
        
        Currency [] currencies = new Currency[currency.size()];
        int i = 0;
        for(Currency divisa: currency){
            currencies[i] = divisa;
            i++;
        }
        return currencies;
    }

}
