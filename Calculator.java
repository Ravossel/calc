import java.util.Scanner;
import java.util.logging.Logger;

// Калькулятор
public class Calculator {
    private static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());

    private Operation operation;

    public Calculator(Operation operation) {
        this.operation = operation;
    }

    public double calculate(double operand1, double operand2) {
        double result = operation.calculate(operand1, operand2);
        LOGGER.info(String.format("%f %s %f = %f", operand1, getOperationType(), operand2, result));
        return result;
    }

    private String getOperationType() {
        if (operation instanceof Addition) {
            return "+";
        } else if (operation instanceof Multiplication) {
            return "*";
        } else if (operation instanceof Division) {
            return "/";
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double operand1 = scanner.nextDouble();

        System.out.print("Выберите действие (+, *, /): ");
        char operationSymbol = scanner.next().charAt(0);

        Operation operation;
        switch (operationSymbol) {
            case '+':
                operation = new Addition();
                break;
            case '*':
                operation = new Multiplication();
                break;
            case '/':
                operation = new Division();
                break;
            default:
                throw new IllegalArgumentException("Ошибка");
        }

        // Очистим буфер после считывания символа операции
        scanner.nextLine();

        System.out.print("Введите второе число: ");
        double operand2 = scanner.nextDouble();

        Calculator calculator = new Calculator(operation);
        double result = calculator.calculate(operand1, operand2);
        System.out.println("Результат: " + result);

        scanner.close();
    }

}
