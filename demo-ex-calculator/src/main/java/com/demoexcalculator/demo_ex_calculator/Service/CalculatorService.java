package main.java.com.demoexcalculator.demo_ex_calculator.Service;



import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.demoexcalculator.demo_ex_calculator.model.Operation;

@Service
public class CalculatorService {

    public Double operate(Operation operation, double x, double y, int scale, RoundingMode roundingMode) {

        if (scale < 0) {
            throw new IllegalArgumentException("Scale cannot be negative");
        }

        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }

        if (roundingMode == null) {
            roundingMode = RoundingMode.HALF_UP;
        }

        BigDecimal bx = BigDecimal.valueOf(x);
        BigDecimal by = BigDecimal.valueOf(y);

        BigDecimal result = switch (operation) {
            case ADD -> bx.add(by);
            case SUB -> bx.subtract(by);
            case MUL -> bx.multiply(by);
            case DIV -> {
                if (by.compareTo(BigDecimal.ZERO) == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                yield bx.divide(by, scale, roundingMode);
            }
        };

        return result.setScale(scale, roundingMode).doubleValue();
    }
}