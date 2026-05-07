package main.java.com.demoexcalculator.demo_ex_calculator.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_calculator.dto.CalculateRequest;
import com.bootcamp.demo.bc_calculator.dto.CalculateResponse;
import com.bootcamp.demo.bc_calculator.service.CalculatorService;

@RestController // ! @Controller + @ResponseBody (JSON)
public class CalculatorController {
  @Autowired
  private CalculatorService calculatorService;

  @GetMapping(value = "/operation")
  public CalculateResponse operate1(@RequestParam String x,
      @RequestParam String y, @RequestParam String operation) {
        
    
    // null check && number check -> double
    // operation -> enum?

    // return double -> String
    // construct CalculateResponse



  }

  @PostMapping(value = "/operation")
  public CalculateResponse operate2(@RequestBody CalculateRequest request) {
    return null;
  }

  @GetMapping(value = "/operation/{x}/{y}/{operation}")
  public CalculateResponse operate3(@PathVariable String x,
      @PathVariable String y, @PathVariable String operation) {
    return null;
  }
}
