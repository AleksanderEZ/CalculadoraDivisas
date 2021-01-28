package calculadoradivisas;

import calculadoradivisas.control.Command;
import calculadoradivisas.ui.swing.SwingMoneyDialog;
import calculadoradivisas.ui.swing.SwingMoneyDisplay;
import calculadoradivisas.view.MoneyDialog;
import calculadoradivisas.view.MoneyDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    private Map<String, Command> commands = new HashMap<>();
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;

    
    public MainFrame() {
        this.setTitle("Calculadora Divisas");
        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocation(0, 0);
        this.add(toolbar(), BorderLayout.NORTH);
        this.add(moneyDialog(), BorderLayout.SOUTH);
        this.add(moneyDisplay(), BorderLayout.SOUTH);
    }

    private Component toolbar() {
        final JPanel panel = new JPanel();
        panel.add(calculateButton());
        return panel;
    }
    
    public void add(Command command){
        commands.put(command.name(), command);
    }

    public MoneyDialog getMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        moneyDialog = dialog;
        return moneyDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        moneyDisplay = display;
        return moneyDisplay;
    }
    
    private Component moneyDialog() {
        return new SwingMoneyDialog();
    }

    private Component moneyDisplay() {
        return new SwingMoneyDisplay();
    }

    private JButton calculateButton() {
        final JButton button = new JButton("Calculate");
        button.addActionListener(calculate());
        return button;
    }

    private ActionListener calculate() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Calculate").execute();
            }
        };
    }
}

