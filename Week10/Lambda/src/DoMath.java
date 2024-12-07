public class DoMath {
    MathOperation addition = (a, b) -> a + b;
    MathOperation subtraction = (a, b) -> a - b;
    MathOperation multiplication = (a, b) -> a * b;
    MathOperation division = (a, b) -> {
        if ( b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    };

    public Integer Addition(Integer a,Integer b) {
        return addition.operate(a,b);
    }

    public Integer Subtraction(Integer a,Integer b) {
        return subtraction.operate(a,b);
    }
    public Integer Multiplication(Integer a,Integer b) {
        return multiplication.operate(a,b);
    }
    public Integer Division(Integer a,Integer b) {
        return division.operate(a,b);
    }
}


