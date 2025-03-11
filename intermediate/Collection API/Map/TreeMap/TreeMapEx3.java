import java.util.Comparator;
import java.util.TreeMap;
import java.util.Map;

class Employees {
    String name;
    String post;

    public Employees(String name, String post) {
        this.name = name;
        this.post = post;
    }

    @Override
    public String toString() {
        return "name='" + name + "', post='" + post;
    }
}

// Comparator to sort Employees by name
class SortByName implements Comparator<Employees> {
    @Override
    public int compare(Employees o1, Employees o2) {
        return o1.name.compareTo(o2.name);
    }
}

// Comparator to sort Employees by post (if post is the same, sort by name)
class SortByPost implements Comparator<Employees> {
    @Override
    public int compare(Employees o1, Employees o2) {
        if(o1.post.compareTo(o2.post)==0){
            return o1.name.compareTo(o2.name);
        }else {
            return o1.post.compareTo(o2.post);
        }
    }
}

public class TreeMapEx3 {
    public static void main(String[] args) {
        // Creating Employee objects
        Employees e1 = new Employees("Mohit", "A");
        Employees e2 = new Employees("Sumit", "B");
        Employees e3 = new Employees("Badal", "C");
        Employees e4 = new Employees("Harprit", "D");
        Employees e5 = new Employees("Kunal", "A");
        Employees e6 = new Employees("Navin", "B");
        Employees e7 = new Employees("Rohit", "D");

        // TreeMap sorted by Employee Name
        TreeMap<Employees, Integer> treeMapByName = new TreeMap<>(new SortByName());
        treeMapByName.put(e1, 101);
        treeMapByName.put(e2, 102);
        treeMapByName.put(e3, 103);
        treeMapByName.put(e4, 104);
        treeMapByName.put(e5, 105);
        treeMapByName.put(e6, 106);
        treeMapByName.put(e7, 107);

        System.out.println("\nTreeMap sorted by Name:");
        for (Map.Entry<Employees, Integer> entry : treeMapByName.entrySet()) {
            System.out.println(entry.getKey() + ", ID: " + entry.getValue());
        }

        // TreeMap sorted by Employee Post
        TreeMap<Employees, Integer> treeMapByPost = new TreeMap<>(new SortByPost());
        treeMapByPost.putAll(treeMapByName);  // Fix: Copying data correctly

        System.out.println("\nTreeMap sorted by Post:");
        for (Map.Entry<Employees, Integer> entry : treeMapByPost.entrySet()) {
            System.out.println(entry.getKey() + ", ID: " + entry.getValue());
        }
    }
}
