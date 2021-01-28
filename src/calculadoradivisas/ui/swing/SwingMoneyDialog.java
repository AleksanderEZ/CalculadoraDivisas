package calculadoradivisas.ui.swing;

import calculadoradivisas.view.FileCurrencyLoader;
import calculadoradivisas.model.Currency;
import calculadoradivisas.model.Money;
import calculadoradivisas.view.MoneyDialog;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class SwingMoneyDialog extends JPanel implements MoneyDialog{

    private Currency currency;
    private String amount;
    
    public SwingMoneyDialog() {
        this.add(amount());
        this.add(currency());
    }
    
    @Override
    public Money get() {
        return new Money(Double.parseDouble(amount), currency);
    }

    private Component amount() {
        final JTextField textField = new JTextField();
        textField.setColumns(10);
        textField.getDocument().addDocumentListener(amountChanged());
        amount = textField.getText();
        return textField;
    }
    
    private Component currency() {
        final JComboBox combo = new JComboBox(currencies());
        combo.addItemListener(currencyChanged());
        currency = (Currency) combo.getSelectedItem();
        return combo;
    }

    private Currency[] currencies() {
       Currency [] currencies = null;
        try {
            currencies =  new FileCurrencyLoader().load();
        } catch (IOException ex) {
            System.out.println("Error en la obtencion de divisas.");
        }
       return currencies;
    }

    private ItemListener currencyChanged() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.DESELECTED) return;
                currency = (Currency) e.getItem();
            }
        };
    }

    private DocumentListener amountChanged() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                amountChanged(e.getDocument());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                amountChanged(e.getDocument());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                amountChanged(e.getDocument());
            }

            private void amountChanged(Document document) {
                try {
                    amount = document.getText(0, document.getLength());
                } catch (BadLocationException ex) {
                    System.out.println("Error en el cambio de cantidad.");
                }
            }            
        };
    }

}
