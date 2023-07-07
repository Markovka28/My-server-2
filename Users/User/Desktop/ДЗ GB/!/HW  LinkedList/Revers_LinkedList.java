import java.util.*;

public class Revers_LinkedList {

  public static void main(String[] args) {
    LinkedList<String> ll = new LinkedList<String>(); // Объявление пустого linkedlist
    ll.add("LinkedList"); // Добавление элементов в конец списка
    ll.add("Queue");
    ll.add("Deque");
    ll.add("PriorityQueue");
    System.out.print("Элементы в обычном порядке: " + ll);
    ll = revLinkedList(ll);
    System.out.print("\n Элементы в обратном порядке: " + ll);
  }

  // Принимает linkedlist в качестве параметра и возвращает linkedlist в обратном порядке
  public static LinkedList<String> revLinkedList(LinkedList<String> llist) {
    LinkedList<String> revLinkedList = new LinkedList<String>();
    for (int i = llist.size() - 1; i >= 0; i--) { // Добавляет элементы в обратном порядке
      revLinkedList.add(llist.get(i));
    }
    return revLinkedList; // возвращает linkedlist в обратном порядке
  }
}
