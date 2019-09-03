import java.util.Arrays;
import java.util.Scanner;

public class Offer53_3 {
    static boolean invalid = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] test = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        System.out.println(getNumberSameAsIndex(test));
    }

    public static int getNumberSameAsIndex(int [] arr){
        if(arr == null || arr.length == 0){
            invalid = true;
            return 0;
        }

        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = (start + end) >> 1;
            if(arr[mid] > mid){
                end = mid - 1;
            }else if(arr[mid] < mid)
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
