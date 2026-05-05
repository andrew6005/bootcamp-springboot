package com.demo.calculator.demo_calculator;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Repository
public class CalculatorController {

    @GetMapping(value="/sum{x}/{y}")
    public Integer sum(@PathVariable(value = "y")Integer salary,
    @PathVariable(value = "x")Integer bonus){
        return salary+ bonus;
    }

    @GetMapping(value="/sum{x}/{y}")
    public String sum2 (@PathVariable String x ,@PathVariable String y){
    try{ return "" + Integer.valueOf(x)+ Integer.valueOf(y);
    }catch(NumberFormatException e){
        return"Invalid Value";
    }
    }
    // public CalculatorController() {
       
    // }

    // @GetMapping("/add")
    // public double add(@RequestParam double a, @RequestParam double b) {
    //     return a + b;
    // }

    // @GetMapping("/subtract")
    // public double subtract(@RequestParam double a, @RequestParam double b) {
    //     return a - b;
    // }

    // @GetMapping("/multiply")
    // public double multiply(@RequestParam double a, @RequestParam double b) {
    //     return a * b;
    // }

    // @GetMapping("/divide")
    // public String divide(@RequestParam double a, @RequestParam double b) {
    //     if (b == 0) {
    //         return "Cannot divide by zero";
    //     }
    //     return String.valueOf(a / b);
    }




// package com.demo.calculator.demo_calculator;

// import org.springframework.web.bind.annotation.*;

// @RestController
// public class CalculatorController {

//     @GetMapping("/")
//     public String home() {
//         return """
//         <html>
//         <body>
//             <h2>Calculator</h2>

//             <form action="/calculate" method="get">
//                 <input type="number" name="a" placeholder="First number" step="any">
//                 <br><br>

//                 <input type="number" name="b" placeholder="Second number" step="any">
//                 <br><br>

//                 <select name="operation">
//                     <option value="add">Add +</option>
//                     <option value="subtract">Subtract -</option>
//                     <option value="multiply">Multiply *</option>
//                     <option value="divide">Divide /</option>
//                 </select>
//                 <br><br>

//                 <button type="submit">Calculate</button>
//             </form>
//         </body>
//         </html>
//         """;
//     }

//     @GetMapping("/calculate")
//     public String calculate(
//             @RequestParam double a,
//             @RequestParam double b,
//             @RequestParam String operation) {

//         double result;

//         switch (operation) {
//             case "add":
//                 result = a + b;
//                 break;
//             case "subtract":
//                 result = a - b;
//                 break;
//             case "multiply":
//                 result = a * b;
//                 break;
//             case "divide":
//                 if (b == 0) {
//                     return "Cannot divide by zero";
//                 }
//                 result = a / b;
//                 break;
//             default:
//                 return "Invalid operation";
//         }

//         return "Result: " + result + "<br><br><a href='/'>Back</a>";
//     }
// }