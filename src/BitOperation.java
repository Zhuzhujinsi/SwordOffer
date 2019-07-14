import java.util.Random;

public class BitOperation {
    //求一个数的二进制表示中1的个数
    public static int numberOf1(int n){
        int count = 0;
        while (n != 0){
            n &= (n - 1);//把n的二进制表示中最右面的1置为0！
            ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int test = random.nextInt();
        System.out.println(numberOf1(test));
    }
}
