package homeworks.fifth;

public class ExponentiationApp {
    public static void main(String[] args) {
        System.out.println(toExponentiation(5, 5));
    }

    public static int toExponentiation(int n, int degree) {
        if (degree == 0)
            return 1;
        return n * toExponentiation(n, degree - 1);
    }
}
