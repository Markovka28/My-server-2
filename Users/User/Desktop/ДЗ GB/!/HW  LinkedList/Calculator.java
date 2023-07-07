import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("Введите 1е и 2е число: ");
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.print(
        "Операция которую необходимо выполнить (+, -, *, /, %, <, >, ^): "
      );
      char op = sc.next().charAt(0);
      solve(a, b, op);
    }
  }

  public static int solve(int a, int b, char op) {
    Stack<Integer> stack = new Stack<>();
    int res = 0;
    if (Objects.equals(op == '+')) {
      res = a + b;
    } else if (Objects.equals(op == '-')) {
      res = a - b;
    } else if (Objects.equals(op == '*')) {
      res = a * b;
    } else if (Objects.equals(op == '%')) {
      res = a % b;
    } else if (Objects.equals(op == '/')) {
      res = a / b;
    } else if (Objects.equals(op == '^')) {
      res = a ^ b;
    }
    System.out.println("Получается: " + res);
    return res;
    stack.push(res);

    while (true) {
      String op1String =
        (
          "\n> Введите (+, -, *, /, ^), " +
          "\n> Либо \"нет\" для" +
          "удаление последнего результата(oper или no) "
        );
      if (Objects.equals(op, "нет")) {
        System.out.println("удаленное значение: " + stack.pop());
        res = stack.peek();
        System.out.println("Текущее значение: " + res);
      } else {
        b = inputNum("Введите число: ");
        if (Objects.equals(op, "+")) {
          res = res + b;
        } else if (Objects.equals(op, "-")) {
          res = res - b;
        } else if (Objects.equals(op, "*")) {
          res = res * b;
        } else if (Objects.equals(op, "/")) {
          res = res / b;
        } else System.out.printf("Неверный ввод !");
        stack.push(res);
        System.out.println("ответ = " + res);
      }
    }
  }

  private static int inputNum(String string) {
    return 0;
  }
}
