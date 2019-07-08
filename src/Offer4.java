import java.util.Scanner;

public class Offer4 {

    public static boolean find(int[][] arr, int target){
        if(arr == null)
            return false;

        int row = arr.length - 1;
        int col = 0;
        while (row >= 0 && col < arr[0].length){
            if(arr[row][col] == target)
                return true;
            else if(arr[row][col] > target)
                --row;
            else
                ++col;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int[][] arr1 = new int[5][3];
//        System.out.println(find(arr, 7));
//        System.out.println(find(arr, 20));
        System.out.println(find(arr1, 20));
    }
}
