// A final variable must be initialized when "declared" or "within the constructor".
// Once assigned, the value cannot be modified.

final class Use {
    public final int n1 = 5;
    public final int n2;

    Use(int n) {
        this.n2 = n;
    }
}

public class FinalConcept2 {
    public static void main(String[] args) {
        Use use = new Use(7);
        System.out.println("N1: " + use.n1);
        System.out.println("N2: " + use.n2);
    }
}
