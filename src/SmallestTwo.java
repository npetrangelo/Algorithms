import java.util.Scanner;

public class SmallestTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int smallest = size;
        int secondSmallest = size;

        for (int i = 0; i < size && scanner.hasNextInt(); i++) {
            int n = scanner.nextInt();
            if (n < smallest) {
                secondSmallest = smallest;
                smallest = n;
            }
        }

        System.out.println(smallest);
        System.out.println(secondSmallest);
    }
}
