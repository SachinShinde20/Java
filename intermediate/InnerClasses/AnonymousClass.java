interface ClickListener {
    void onClick();
}

public class AnonymousClass {
    public static void main(String[] args) {

        ClickListener button = new ClickListener() {
            public void onClick() {
                System.out.println("Button Clicked!");
            }
        };

        button.onClick();

        /*
         * or
         */

        new ClickListener() {
            public void onClick() {
                System.out.println("Button Clicked!");
            }
        }.onClick();

    }
}
