import java.util.Arrays;
import java.util.Scanner;

public class Offer56_1 {
    /*
    一个整形数组里除两个数字以外，其它数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)
     */
    public void findNumsAppearOnce(int [] data){
        if(data == null || data.length < 2)
            return;

        int length = data.length;
        int result = 0;
        for (int i = 0; i < length; ++i){
            result ^= data[i];
        }

        int result1 = 0;
        int result2 = 0;
        int indexOf1 = findFirstBitIs1(result);
        for (int i = 0; i < length; ++i){
            if(isBit1(data[i], indexOf1))
                result1 ^= data[i];
            else
                result2 ^= data[i];
        }
        System.out.println(result1 + " " + result2);
    }

    public int findFirstBitIs1(int num){
        int index = 0;
        while ((num & 1) == 0){
            num = num >> 1;
            ++index;
        }
        return index;
    }

    public boolean isBit1(int num, int index){
        num = num >> index;
        return ((num & 1) == 1) ? true : false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] test = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Offer56_1 offer56_1 = new Offer56_1();
        offer56_1.findNumsAppearOnce(test);
    }


}
