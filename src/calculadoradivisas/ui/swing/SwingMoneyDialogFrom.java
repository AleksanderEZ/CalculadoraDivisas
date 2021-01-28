package calculadoradivisas.ui.swing;

import calculadoradivisas.model.Currency;
import calculadoradivisas.model.Money;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import calculadoradivisas.ui.MoneyDialogFrom;

public class SwingMoneyDialogFrom extends JPanel implements MoneyDialogFrom {
    
    private Currency currency;
    private final Currency[] currencies;
    private String amount;
    
    public SwingMoneyDialogFrom(Currency [] currencies){
        this.currencies = currencies;
        this.add(amount());
        this.add(currency());
    }
    
    @Override
    public Money get() {
        double howMuch = 0;
        try{
            howMuch = Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            /* Number not found */
        }
        return new Money(currency, howMuch);
    }

    private JComboBox currency() {
        final JComboBox comboBox = new JComboBox(currencies);
        comboBox.addItemListener(currencyChanged());
        currency = (Currency) comboBox.getSelectedItem();
        return comboBox;
    }

    private Component amount() {
        final JTextField textField = new JTextField();
        textField.setColumns(10);
        textField.getDocument().addDocumentListener(amountChanged());
        amount = textField.getText();
        return textField;
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
                    System.out.println("Could not reach text field value.");
                }
            }
        };
    }
}
