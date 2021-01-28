package calculadoradivisas.ui.swing;

import calculadoradivisas.model.Money;
import calculadoradivisas.ui.MoneyDisplay;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay{

    private Money money;

    public SwingMoneyDisplay() {
        this.add(new JLabel("0.0 EUR"));
    }

    
    @Override
    public void display(Money money) {
        this.money = money;
        this.removeAll();
        this.add(amount());
        this.add(currency());
        setVisible(true);
        this.updateUI();
    }

    private Component amount() {
        return new JLabel(Double.toString(money.getAmount()));
    }

    private Component currency() {
        return new JLabel(money.getCurrency().getCode());
    }

}
