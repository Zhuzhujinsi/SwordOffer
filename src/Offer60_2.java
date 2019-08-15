public class Offer60_2 {
    /*
    n个筛子的点数
     */
    public static void printProbability(int number){
        int[][] arr = new int[2][6 * number + 1];
        int flag = 0;
        for(int i = 1; i <= 6; ++i)
            arr[flag][i] = 1;

        for(int i = 2; i <= number; ++i){
            for (int j = 0; j < i; ++j)//注意第j轮，不可能出现点数和小于j！
                arr[1 - flag][j] = 0;
            for(int j = i; j <= 6 * i; ++j){
                for (int k = 1; k <= 6 && k < j; ++k)
                    arr[1 - flag][j] += arr[flag][j - k];
            }

            flag = 1 - flag;
        }

        for (Integer integer : arr[flag])//打印的永远是arr[flag]
            System.out.print(integer + " ");
    }

    public static void main(String[] args) {
        printProbability(3);
    }
}
