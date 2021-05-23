package com.company.lambda;

public class Main {
    public static void main(String[] args) {
        Math sumMath  = new Math() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };

        System.out.println("Sum: " + sumMath.operation(1,2));

        Math diffMath = new Math() {
            @Override
            public int operation(int a, int b) {
                return b - a;
            }
        };

        System.out.println("Diff: " + diffMath.operation(2, 6));

        // with lambda
        Math divMath = (int a, int b) -> a / b;
        System.out.println("Div: " + divMath.operation(9, 3));

        Math multiplyMath = (a, b) -> a * b;
        System.out.println("Multiply: " + multiplyMath.operation(2,2));

        // varianta de lambda cu mai multe linii de cod
        Math multiLine = (a, b) -> {
            int result = a + b;

            return result + 4;
        };
        System.out.println("Total: " + multiLine.operation(2,2));
    }
}
