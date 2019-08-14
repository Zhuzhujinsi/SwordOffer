import java.util.Scanner;

public class Offer10 {
    /*
    斐波那契数列
     */
    public static int fibonacci(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        int small = 0;
        int big = 1;
        int result = 0;
        for(int i = 2; i <= n; ++i){
            result = small + big;
            small = big;
            big = result;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fibonacci(sc.nextInt()));
    }
}
