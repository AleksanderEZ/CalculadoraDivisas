package calculadoradivisas.control;

import calculadoradivisas.model.Currency;
import calculadoradivisas.model.ExchangeRate;
import calculadoradivisas.model.Money;
import calculadoradivisas.ui.MoneyDisplay;
import calculadoradivisas.ui.MoneyDialogFrom;
import calculadoradivisas.ui.MoneyDialogTo;
import calculadoradivisas.view.GoogleExchangeRateLoader;

public class CalculateCommand implements Command{
    
    private MoneyDialogTo moneyDialogTo;
    private MoneyDialogFrom moneyDialogFrom;
    private MoneyDisplay moneyDisplay;

    public CalculateCommand(MoneyDialogFrom moneyDialogFrom, MoneyDisplay moneyDisplay, MoneyDialogTo moneyDialogTo) {
        this.moneyDialogFrom = moneyDialogFrom;
        this.moneyDisplay = moneyDisplay;
        this.moneyDialogTo = moneyDialogTo;
    }
    
    @Override
    public String name() {
        return "calculate";
    }

    @Override
    public void execute() {
        moneyDisplay.display(exchange(moneyDialogFrom.get()));
    }

    private Money exchange(Money moneyFrom) {
        Money result = new Money(moneyDialogTo.getCurrency(), moneyFrom.getAmount() * rateOf(moneyFrom.getCurrency(), moneyDialogTo.getCurrency()));
        return result;
    }

    private double rateOf(Currency currencyFrom, Currency currencyTo) {
        ExchangeRate rate = new GoogleExchangeRateLoader().load(currencyFrom, currencyTo);
        return rate.getRate();
    }

}
