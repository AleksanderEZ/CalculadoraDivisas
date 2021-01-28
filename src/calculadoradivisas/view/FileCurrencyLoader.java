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
    public Currency[] load(String path) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File(path)));
        } catch (Exception ex) {
            System.out.println("Error opening file.");
        }
        
        Set<Currency> currencies = new HashSet<>();
        
        while(true){
            String line = null;
            try {
                line = reader.readLine();
            } catch (IOException ex) {
                System.out.println("Error reading file");
            }
            if(line == null) break;
            String [] lineAux = line.split(";");
            currencies.add(new Currency(lineAux[0], lineAux[1], lineAux[2]));
        }
        
        Currency [] result = new Currency[currencies.size()];
        
        int i = 0;
        for(Currency badge: currencies){
            result[i] = badge;
            i++;
        }
        
        return result;
    }
}
