/* Пусть дан произвольный список целых чисел.
1) Нужно удалить из него чётные числа
2) Найти минимальное значение
3) Найти максимальное значение
4) Найти среднее значение */

import java.util.*;

public class Collection_Del_max_min_avg {

  public static void main(String[] args) {
    ArrayList<Integer> my_list = new ArrayList<Integer>();
    my_list.add(29);
    my_list.add(57);
    my_list.add(48);
    my_list.add(14);
    my_list.add(55);
    my_list.add(90);
    my_list.add(66);
    my_list.add(76);
    my_list.add(22);
    Collections.shuffle(my_list);
    System.out.print("Список состоит из следующих элементов: " + my_list);

    int max = Collections.max(my_list);
    System.out.println("\n1. Максимальный элемент: " + max);
    int min = Collections.min(my_list);
    System.out.println("\n2. Минимальный элемент: " + min);

    int sum = 0;
    double average = 0.0;
    for (int num : my_list) {
      sum += num;
    }
    System.out.println("\n3. Сумма всех элементов: " + sum);
    average = (double) sum / (double) my_list.size();
    System.out.println("\n4. Среднее значение: " + average);

    for (Iterator<Integer> iterator = my_list.iterator(); iterator.hasNext();) {
      Integer odd = iterator.next();
      if (odd % 2 == 0) {
        iterator.remove();
      }
    }
    System.out.print("\n5. Нечетные числа: " + my_list + " ");
  }
}
