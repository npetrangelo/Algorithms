import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World");
        Integer[] arr = {6,5,3,2,6,78,8,6,4,23};
        Sort.mergesort(arr, Comparator.comparingInt(a -> a), 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
