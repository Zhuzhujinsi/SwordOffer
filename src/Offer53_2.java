import java.util.Arrays;
import java.util.Scanner;

public class Offer53_2 {
    static boolean invalid = false;
    public static int getMissingNumber(int [] arr){
        if(arr == null || arr.length == 0)
            return -1;

        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = (start + end) >> 1;
            if(arr[mid] == mid){
                start = mid + 1;
            }else if(mid == 0 || arr[mid - 1] == mid - 1){
                return mid;
            }else {
                end = mid - 1;
            }
        }
        if(start == arr.length)
            return arr.length;

        //无效的输入，比如数组不是按要求排序的，
        //或者有数字不在0~n-1范围之内
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] test = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        System.out.println(getMissingNumber(test));
    }
}
