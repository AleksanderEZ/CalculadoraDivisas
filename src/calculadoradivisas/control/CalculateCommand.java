package calculadoradivisas.control;

import calculadoradivisas.view.MoneyDialog;
import calculadoradivisas.view.MoneyDisplay;

public class CalculateCommand implements Command{

    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;

    public CalculateCommand(MoneyDialog moneyDialog, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public String name() {
        return "Calculate";
    }

    @Override
    public void execute() {
        moneyDisplay.display(moneyDialog.get());
    }
}
