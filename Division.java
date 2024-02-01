// Деление
public class Division implements Operation {
    @Override
    public double calculate(double operand1, double operand2) {
        if (operand2 != 0) {
            return operand1 / operand2;
        } else {
            throw new IllegalArgumentException("Нельзя делить на ноль");
        }
    }
}
