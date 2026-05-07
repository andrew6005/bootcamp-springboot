package main.java.com.demoexcalculator.demo_ex_calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculateResponse {

    private String x;
    private String y;
    private String operation;
    private String result;
}