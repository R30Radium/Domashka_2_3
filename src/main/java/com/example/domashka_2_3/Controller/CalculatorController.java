package com.example.domashka_2_3.Controller;

import com.example.domashka_2_3.Service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculator")
    public String hello() {
        return "Вас приветствует калькулятор";
    }

    @GetMapping("plus")
    public String plus(@RequestParam(value = "num1", required = false) Float a,
                       @RequestParam(value = "num2",required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Не корректные парамаетры";
        }
        return a + " + " + b + " = " + calculatorService.plus(a,b);
    }

    @GetMapping("minus")
    public String minus(@RequestParam(value = "num1",required = false) Float a,
                        @RequestParam(value = "num2",required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Не корректные парамаетры";
        }
        return a + " - " + b + " = " + calculatorService.minus(a,b);

    }

    @GetMapping("multiply")
    public String multiply(@RequestParam(value = "num1",required = false) Float a,
                           @RequestParam(value = "num2",required = false) Float b){
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Не корректные парамаетры";
        }
        return a+" * " + b + " = " + calculatorService.multiply(a,b);
    }

    @GetMapping("divide")
    public String divide(@RequestParam(value = "num1",required = false) Float a,
                         @RequestParam(value = "num2",required = false) Float b){
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Не корректные парамаетры";
        }
        if (b == 0) {
            return "На 0 делить нельзя!";
        } else {
            return a+" / " + b + " = " + calculatorService.divide(a,b);
        }

    }
}