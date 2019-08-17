import java.util.Arrays;
import java.util.Scanner;

public class Offer63 {
    /*
    股票的最大利润
    思路：函数diff(i)表示在i处卖出股票能获得最大利润，所以股票的最大利润一定在diff(i), i >= 0 && i <= length - 1。
          diff(i)等于arr[i]减去当前最小值，当前最小值在一次遍历中，也可以顺便获得，所以总体时间复杂度为O(n)。
     */

    public static void maxProfit(int[] arr){
        if(arr == null || arr.length <= 1)
            return;

        int maxProfit = arr[1] - arr[0];
        int min = arr[0];
        int length = arr.length;
        for(int i = 2; i < length; ++i){
            if(arr[i - 1] < min)
                min = arr[i- 1];

            int diff = arr[i] - min;
            if(diff > maxProfit)
                maxProfit = diff;
        }

        System.out.println(maxProfit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] test = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        maxProfit(test);
    }
}
