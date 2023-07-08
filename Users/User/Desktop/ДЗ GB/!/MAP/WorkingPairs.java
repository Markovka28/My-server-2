import java.util.*;

public class WorkingPairs {

  public static void main(String[] args) {
    Map<Integer, String> db = new HashMap<>();
    db.putIfAbsent(1, "один");
    db.put(2, "два");
    db.put(3, "три");
    System.out.println(db);
    for (var item : db.entrySet()) {
      System.out.printf("[%d: %s]\n", item.getKey(), item.getValue());
    }
  }
}
// Map<String, Integer> states = new HashMap<String, Integer>();
// 		 states.put("I",1);
// 		 states.put("V",5);
// 		 states.put("X",10);
// 	     String n = "I I V X";
// 	     String[] mass = n.split(" ");
// 	     for (int i = 0; i < mass.length; i++) {
// 	         System.out.println(states.get(mass[i]));
// 	     }
//   Map<String, Integer> states = new HashMap<String, Integer>();
//  states.put("I",1);
//  states.put("V",5);
//  states.put("X",10);
//    String n = "I I VI X";
//    String[] mass = n.split(" ");
//    for (int i = 0; i < mass.length; i++) {
//        if(states.get(mass[i]) == null){
//            String[] n2 = mass[i].split("");
//            int b = 0;
//            for (int j = 0; j < n2.length; j++) {
//                if(states.get(n2[0]) > states.get(n2[1])){
//                    b += states.get(n2[j]);
//                }else{
//                }
//            }
//             System.out.println(b);
//        }else{
//            System.out.println(states.get(mass[i]));
//        }
//    }
