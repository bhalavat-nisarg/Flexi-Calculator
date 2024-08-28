package com.nisarg.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    private final Map<String, BiFunction<Number, Number, Number>> operations = new HashMap<>();

    public Calculator() {
        operations.put(Operations.ADD.name(), (a, b) -> a.doubleValue() + b.doubleValue());
        operations.put(Operations.SUBTRACT.name(), (a, b) -> a.doubleValue() - b.doubleValue());
        operations.put(Operations.MULTIPLY.name(), (a, b) -> a.doubleValue() * b.doubleValue());
        operations.put(Operations.DIVIDE.name(), (a, b) -> {
            if (b.doubleValue() == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return a.doubleValue() / b.doubleValue();
        });
    }

    public Number calculate(String op, Number num1, Number num2) {
        if (!operations.containsKey(op)) {
            throw new UnsupportedOperationException("Not supported operation: " + op);
        }

        return operations.get(op).apply(num1, num2);
    }

    public void addNewOperation(String operationName, BiFunction<Number, Number, Number> operation) {
        operations.put(operationName.toUpperCase(), operation);
    }

    public Number chain(Number initialValue, Object... opsAndValue) {
        Number result = initialValue;
        for (int i = 0; i < opsAndValue.length; i += 2) {
            String op = opsAndValue[i].toString();
            Number value = (Number) opsAndValue[i + 1];
            result = calculate(op, result, value);
        }
        return result;
    }
}