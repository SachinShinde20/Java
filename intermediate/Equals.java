class Emp {
    int id;
    String name;
    String dept;

    public Emp(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Emp other = (Emp) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (dept == null) {
            if (other.dept != null)
                return false;
        } else if (!dept.equals(other.dept))
            return false;
        return true;
    }
}

public class Equals {
    public static void main(String[] args) {
        Emp emp1 = new Emp(101, "Raj", "Networking");
        Emp emp2 = new Emp(105, "Sam", "Advertising");
        Emp emp3 = new Emp(101, "Raj", "Networking");

        System.out.println(emp1.equals(emp2));
        System.out.println(emp1.equals(emp3));

        System.out.println(emp2.equals(emp2));
    }
}
