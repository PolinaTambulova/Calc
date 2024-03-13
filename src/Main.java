import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String expression = scanner.nextLine();
            System.out.println(calc(expression));
        }
    }

    public static String calc(String input) throws Exception {
        String operation;
        if (input.contains("+")) {
            operation = "+";
        } else if (input.contains("-")) {
            operation = "-";
        } else if (input.contains("/")) {
            operation = "/";
        } else if (input.contains("*")) {
            operation = "*";
        } else {
            throw new Exception("Неподдерживаемая операция");
        }
        int indexOfOperation = input.indexOf(operation);
        String firstNumString = input.substring(0, indexOfOperation).trim();
        String secondNumString = input.substring(indexOfOperation + 1).trim();
        int firstNum = Integer.parseInt(firstNumString);
        int secondNum = Integer.parseInt(secondNumString);
        if (firstNum > 10 || firstNum < 1 || secondNum > 10 || secondNum < 1) {
            throw new Exception("Число не входит в диапозанон допустимых значений");
        }
        return switch (operation) {
            case "+" -> String.valueOf(firstNum + secondNum);
            case "-" -> String.valueOf(firstNum - secondNum);
            case "*" -> String.valueOf(firstNum * secondNum);
            default -> String.valueOf(firstNum / secondNum);
        };
    }
}