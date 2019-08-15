import java.util.Scanner;

public class Offer60_1 {
    /*
    n个筛子的点数
     */
    public void printProbability(int number){
        if(number < 1)
            return;
        int[] arr = new int[6 * number - number + 1];
        printProbabilityCore(number, number, 0, arr);
        for (Integer integer : arr){
            System.out.print(integer + " ");
        }
    }

    public void printProbabilityCore(int number, int current, int sum, int[] arr){
        if(current == 0)
            ++arr[sum - number];

        for(int i = 1; i <= 6; ++i){
            printProbabilityCore(number, current - 1, sum + i, arr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Offer60_1 offer60 = new Offer60_1();
        offer60.printProbability(1);
    }
}
