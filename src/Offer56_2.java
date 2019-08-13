import java.util.Arrays;
import java.util.Scanner;

public class Offer56_2 {
    /*
    在一个数组中除一个数字只出现一次之外，其它数字都出现了三次。请找出那个只出现一次的数字
     */
    boolean invalid = false;
    public int findNumberAppearingOnce(int[] numbers){
        if(numbers == null || numbers.length == 0) {
            invalid = true;
            return 0;
        }

        int length = numbers.length;
        int[] bitSum = new int[32];
        for (int i = 0; i < length; ++i){
            int bitMask = 1;
            for (int j = 31; j >= 0; --j){
                int bit = numbers[i] & bitMask;
                if(bit != 0)
                    ++bitSum[j];

                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        for (int i = 31; i >= 0; --i){
            result += (bitSum[i] % 3) * Math.pow(2, 31 - i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] test = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Offer56_2 offer56_2 = new Offer56_2();
        System.out.println(offer56_2.findNumberAppearingOnce(test));
    }
}
