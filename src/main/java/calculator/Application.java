package calculator;

import calculator.controller.CalculatorConroller;
import calculator.service.CalculatorService;
import calculator.view.CalculatorView;


public class Application {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        CalculatorService service = new CalculatorService();
        CalculatorConroller calculatorConroller = new CalculatorConroller(view, service);
        calculatorConroller.handle();
    }
}
