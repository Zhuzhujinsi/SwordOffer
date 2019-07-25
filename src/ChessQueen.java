/*
在8×8的国际象棋上摆放8个皇后，使其不能相互攻击，即任意两个皇后不得处在同一行，同一列或者同一对角线上。问总共有多少种符合条件的摆法？
对照剑指Offer书给出的全排列思路去看！
 */
public class ChessQueen {
    static int [] columnIndex = {0,1,2,3,4,5,6,7};
    static int count = 0;
    public int fullSort(int [] arr, int length, int start){
        if(start == length - 1){
            judge(arr, length);
        }else {
            for (int i = start; i < length; ++i) {
                swap(arr, start, i);
                fullSort(arr, length, start + 1);
                swap(arr, i, start);
            }
        }
        return count;
    }

    public void swap(int [] arr, int num1, int num2){
        if(num1 == num2)
            return;

        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

    public void judge(int [] arr, int length){
        boolean satifaction = true;
        for(int i = 0; i < length; ++i){
            for (int j = i + 1; j < length; ++j){
                if((i - j == arr[i] - arr[j]) || (i - j == arr[j] - arr[i])){
                    satifaction = false;
                    break;
                }
            }
            if(!satifaction)
                break;
        }

        if(satifaction)
            ++count;
    }

    public static void main(String[] args) {
        ChessQueen chessQueen = new ChessQueen();
        System.out.println(chessQueen.fullSort(columnIndex, 8, 0));
    }
}
