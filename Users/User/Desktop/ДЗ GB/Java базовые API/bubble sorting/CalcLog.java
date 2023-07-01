// К калькулятору из предыдущего ДЗ добавить логирование.

import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.io.*;

public class CalcLog {
    private static final Logger logger = LogManager.getLogger(CalcLog.class);

    public static void main(String[] args, String way, String ans) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(way))) {
            while ((br.readLine()) != null) {
            }
            br.close();
        }
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Введите 1е и 2е число -");
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.print("Выберите и введите тип операции которую необходимо выполнить (+, -, *, /, %)- ");
            char op = sc.next().charAt(0);
            solve(a, b, op);
            logger.info("Итого: " + ans);
        }

    }

    public static int solve(int a, int b, char op) {
        int ans = 0;
        if (op == '+') {
            ans = a + b;
        } else if (op == '-') {
            ans = a - b;
        } else if (op == '*') {
            ans = a * b;
        } else if (op == '%') {
            ans = a % b;
        } else if (op == '/') {
            ans = a / b;
        }
        System.out.println("Получается: - " + ans);
        return ans;
    }
}
