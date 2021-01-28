package calculadoradivisas.ui.swing;

import calculadoradivisas.model.Currency;
import calculadoradivisas.ui.MoneyDialogTo;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class SwingMoneyDialogTo extends JPanel implements MoneyDialogTo{

    private Currency currency;
    private final Currency[] currencies;
    
    public SwingMoneyDialogTo(Currency [] currencies){
        this.currencies = currencies;
        this.add(currency());
    }

    public Currency getCurrency() {
        return currency;
    }    

    private JComboBox currency() {
        final JComboBox comboBox = new JComboBox(currencies);
        comboBox.addItemListener(currencyChanged());
        currency = (Currency) comboBox.getSelectedItem();
        return comboBox;
    }

    private ItemListener currencyChanged() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.DESELECTED) return;
                currency = (Currency) e.getItem();
            }
        };
    }
}
