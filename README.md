# Simple Extensible Calculator

## Description
This project implements a simple and extensible calculator in Java that supports multiple operations. The calculator adheres to key object-oriented principles, especially the Open-Closed Principle, and is designed with maintainability and extensibility in mind.

## Features
- Basic Operations: Add, Subtract, Multiply, Divide
- Chaining Operations: Supports chaining multiple operations in sequence
- Extensibility: New operations can be added dynamically at runtime
- Error Handling: Handles invalid operations and division by zero gracefully

## Design Decisions
- **Open-Closed Principle**: The `Calculator` class can be extended with new operations via the `addNewOperation` method without modifying the existing code
- **Flexible Operation Handling**: Uses a map of string keys to operation functions, allowing both predefined and custom operations
- **Type Safety**: Maintains an `Operations` enum for standard operations while allowing custom operations to be added

## Usage

### Basic Operations
```java
Calculator calculator = new Calculator();
System.out.println(calculator.calculate(String.valueOf(Operations.ADD), 2, 3)); // 5.0
System.out.println(calculator.calculate(String.valueOf(Operations.SUBTRACT), 5, 2)); // 3.0
System.out.println(calculator.calculate(String.valueOf(Operations.MULTIPLY), 4, 3)); // 12.0
System.out.println(calculator.calculate(String.valueOf(Operations.DIVIDE), 10, 2)); // 5.0