package calculadoradivisas;

import calculadoradivisas.control.Command;
import calculadoradivisas.model.Currency;
import calculadoradivisas.ui.MoneyDisplay;
import calculadoradivisas.ui.swing.SwingMoneyDialogFrom;
import calculadoradivisas.ui.swing.SwingMoneyDisplay;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import calculadoradivisas.ui.MoneyDialogFrom;
import calculadoradivisas.ui.MoneyDialogTo;
import calculadoradivisas.ui.swing.SwingMoneyDialogTo;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class MainFrame extends JFrame {
    
    Currency [] currencies;
    private final Map<String, Command> commands;
    private MoneyDialogFrom moneyDialogFrom;
    private MoneyDialogTo moneyDialogTo;
    private MoneyDisplay moneyDisplay;

    public MainFrame(Currency [] currencies) {
        this.commands = new HashMap<>();
        this.currencies = currencies;
        setTitle("Money Calculator");
        setLocation(0, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(toolbar());
        add(moneyDisplay());           
        add(moneyDialogFrom());
        add(new JLabel("To"));
        add(moneyDialogTo());
        setVisible(true);
    }
    
    public void addCommand(Command command) {
        commands.put(command.name(), command);
    }

    public MoneyDialogFrom getMoneyDialog() {
        return moneyDialogFrom;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }
    
    public MoneyDialogTo getMoneyDialogTo() {
        return moneyDialogTo;
    }
    
    private JPanel moneyDisplay() {
        JPanel display = new SwingMoneyDisplay();
        moneyDisplay = (MoneyDisplay) display;
        return display;
    }

    private JPanel moneyDialogFrom() {
        JPanel dialog = new SwingMoneyDialogFrom(currencies);
        moneyDialogFrom = (MoneyDialogFrom) dialog;
        return dialog;
    }
    
    
    private JPanel moneyDialogTo() {
        JPanel dialog = new SwingMoneyDialogTo(currencies);
        moneyDialogTo = (MoneyDialogTo) dialog;
        return dialog;
    }

    private JPanel toolbar() {
        JPanel panel = new JPanel();
        panel.add(calculateButton());
        return panel;
    }

    private JButton calculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(calculate());
        return button;
    }

    private ActionListener calculate() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("calculate").execute();
            }
        };
    }
}
