import java.util.Scanner;

public class Necklace2 {
    static int weights[];
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int numWeights = scanner.nextInt();

        int sum = 0;
        weights = new int[numWeights];
        for (int i = 0; i < numWeights && scanner.hasNextInt(); i++) {
            weights[i] = scanner.nextInt();
            sum += weights[i];
        }
        int segmentWeight = sum/numWeights;

    }
}
