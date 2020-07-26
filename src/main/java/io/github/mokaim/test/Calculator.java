package io.github.mokaim.test;


public class Calculator {

    private CalculatorService calculatorService;


    public Calculator(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    public int perform(int i, int j){
        return  calculatorService.add(i,j);
    }
}
