import java.util.Scanner;

public class Primes {
    static LinkedList<Integer> primes = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int prime : primes) {
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    }
}
