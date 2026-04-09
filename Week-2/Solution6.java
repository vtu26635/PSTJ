package tasks;
class Arithmetic {
    int add(int a, int b) {
        return a + b;
    }
}

class Adder extends Arithmetic {
}

public class Solution6 {
    public static void main(String[] args) {

        Adder a = new Adder();

        System.out.println("My superclass is: " + a.getClass().getSuperclass().getSimpleName());

        System.out.print(a.add(10, 32) + " ");
        System.out.print(a.add(10, 3) + " ");
        System.out.print(a.add(10, 10));
    }
}
