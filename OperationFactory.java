// Фабрика операций
public class OperationFactory {
    public static Operation createOperation(String operationType) {
        switch (operationType.toLowerCase()) {
            case "addition":
                return new Addition();
            case "multiplication":
                return new Multiplication();
            case "division":
                return new Division();
            default:
                throw new IllegalArgumentException("Invalid operation type");
        }
    }
}
