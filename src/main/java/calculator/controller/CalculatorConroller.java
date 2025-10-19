package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;


public class CalculatorConroller {
    private final CalculatorView view;
    private final CalculatorService service;

    public CalculatorConroller(CalculatorView view, CalculatorService service) {
        this.view = view;
        this.service = service;
    }

    public void handle() {
        view.readInput();
        view.setResult(service.run(view.getInput()));
        view.printResult();
    }
}
