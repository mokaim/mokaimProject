package io.github.mokaim.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalculatorTest {

    CalculatorService calculatorService = mock(CalculatorService.class);
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(calculatorService);
    }

    @Test
    void perform() {

        when(calculatorService.add(10,20)).thenReturn(30);

       // int result = calculator.perform(10,10);
        assertEquals(30, calculator.perform(10,20));
    }
}