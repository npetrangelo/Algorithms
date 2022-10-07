import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World");
        int[] arr = {6,5,3,2,6,78,8,6,4,23};
        Utils.mergesort(arr);
        System.out.println(Arrays.toString(arr));

        int[] foo = {6,5,3,2,6,78,8,6,4,23};
        System.out.println(Utils.selectRand(foo, foo.length/2));
    }
}
