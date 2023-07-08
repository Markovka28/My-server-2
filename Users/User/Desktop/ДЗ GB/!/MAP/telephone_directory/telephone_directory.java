package telephone_directory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class telephone_directory {

  private static HashMap<String, String> hm = new HashMap<String, String>();

  private static void addTel_directory(String phone, String name) { //добавить указанные телефон и ФИО
    hm.put(phone, name);
  }

  private static void delTel_directory(String phone) { //удалить по №телефона
    hm.remove(phone);
  }

  private static void saveTel_directory() throws IOException { //сохранить в файл
    BufferedWriter writer = new BufferedWriter(
      new FileWriter(new File("Справочник.txt"))
    );
    for (Map.Entry<String, String> k : hm.entrySet()) {
      writer.write(k.getKey() + " " + k.getValue() + System.lineSeparator());
    }
    writer.close();
  }

  public static void loadTel_directory() throws IOException { //загрузить из файла + проверить присутствие
    File file = new File("Справочник.txt");
    if (file.exists()) {
      BufferedReader reader = new BufferedReader(
        new FileReader(new File("Справочник.txt"))
      );
      String act;
      while ((act = reader.readLine()) != null) {
        String[] dat = act.split(" ");
        hm.put(dat[0], dat[1]);
      }
      reader.close();
    }
  }

  public static void PrintTel_directory() { //вывести в терминал
    System.out.println("Справочник: ");
    for (Map.Entry<String, String> k : hm.entrySet()) {
      System.out.println(k.getValue() + ": " + k.getKey());
    }
  }

  public static String FindTel_directory(String number) { //поиск фамилии по № телефона
    String result = hm.get(number);
    if (result == null) return "не найдено";
    return result;
  }

  public static String[] FindNumberTel_directory(String surname) { //поиск списка № по фамилии
    List<String> result = new ArrayList<String>();
    for (Map.Entry entry : hm.entrySet()) {
      if (surname.equalsIgnoreCase((String) entry.getValue())) {
        result.add((String) entry.getKey());
      }
    }
    if (result.size() == 0) result.add("не найдено");
    return result.toArray(new String[0]);
  }

  public static void main(String[] args) throws IOException {
    String Tel;
    loadTel_directory(); //загрузка
    PrintTel_directory(); //вывод
    System.out.println( //предлогаемые действия
      "выбор действия: (1)добавить, (2)удалить, (3)найти номер, (4)найти фамилию, " +
      "(5)сохранить, (9)выход"
    );

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    Tel = bf.readLine();
    while (!Tel.equals("9")) { //добавление записи
      if (Tel.equals("1")) {
        System.out.println("Введите фамилию:");
        String name = bf.readLine();
        System.out.println("Введите телефон:");
        String phone = bf.readLine();
        addTel_directory(phone, name);
      } else { //удаление записи
        if (Tel.equals("2")) {
          System.out.println("Введите телефон:");
          String phone = bf.readLine();
          delTel_directory(phone);
        } else { //поиск № по фамилии
          if (Tel.equals("3")) {
            System.out.println("Введите фамилию:");
            String surname = bf.readLine();
            String[] numbers = FindNumberTel_directory(surname);
            for (String number : numbers) {
              System.out.println(number);
            }
          } else { //поиск фамилии по №
            if (Tel.equals("4")) {
              System.out.println("Введите номер:");
              String number = bf.readLine();
              System.out.println(FindTel_directory(number));
            } else { //сохранение в файл
              if (Tel.equals("5")) {
                saveTel_directory();
              }
            }
          }
        }
      }
      System.out.println( //следующее действие
        "выбор действия: (1)добавить, (2)удалить, (3)найти № по фамилии," +
        "(4)найти фамилию, (5)сохранить, (9)выход"
      );
      Tel = bf.readLine();
    }
  }
}
