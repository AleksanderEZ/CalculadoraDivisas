package calculadoradivisas;

import calculadoradivisas.control.CalculateCommand;
import calculadoradivisas.model.Currency;
import calculadoradivisas.view.FileCurrencyLoader;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Currency [] currencies = new FileCurrencyLoader().load("file.txt");
        MainFrame mainFrame = new MainFrame(currencies);
        mainFrame.addCommand(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), mainFrame.getMoneyDialogTo()));
    }
}
