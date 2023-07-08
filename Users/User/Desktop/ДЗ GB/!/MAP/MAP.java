import java.util.HashMap;
import java.util.Map;

public class MAP {

  public static void main(String[] args) {
    Map<Integer, String> db = new HashMap<>(); //<Integer - тип ключа, String - тип значения>
    db.putIfAbsent(1, "один"); // метод позволяет сделат првоерку, если такой ключ есть добавляеь не надо
    db.put(2, "два"); // добавить ключ/значение (повторяющиеся значения перезаписываются)
    db.put(null, "!null");
    System.out.println(db);
    System.out.println(db.get(44));
    // db.remove(null);
    System.out.println(db); // {1=один, 2 = два}
    System.out.println(db.containsValue("один")); // true (проверка значения)
    // System.out.println(db.containsValue(1)); // false
    // System.out.println(db.containsKey("один")); //false (проверка ключа)
    System.out.println(db.containsKey(1)); // true
    System.out.println(db.keySet()); // все ключи
    System.out.println(db.values()); // все значения
  }
}
