import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ByteDance {
    //求数组中和为某一特定值的三个元素
    public static List<List<Integer>> getThreeElements(int[] arr, int target){
        if(arr == null || arr.length < 3)
            return null;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        quickSort(arr, 0, arr.length - 1);
        //Arrays.sort(arr);
        if((arr[arr.length - 1] + arr[arr.length - 2] + arr[arr.length - 3]) < target)
            return null;
        for(int i = 0; i <= arr.length - 3; ++i){
            if(i > 0 && arr[i - 1] == arr[i])//防止出现重复
                continue;
            int j = i + 1;//注意每次j = i + 1，否则会有重复出现（List允许重复元素！），画图很好理解！
            int k = arr.length - 1;
            int sum = arr[i] + arr[j] + arr[k];
            while (j < k){
                if(sum > target) {
                    --k;
                    while (arr[k] == arr[k + 1] && k > j)
                        --k;
                }
                else if(sum < target) {
                    ++j;
                    while (arr[j - 1] == arr[j] && j < k)
                        ++j;
                }
                else {
                    list.add(arr[i]);
                    list.add(arr[j]);
                    list.add(arr[k]);
                    result.add(list);
                    list = new ArrayList<>();
                    ++j;
                    --k;
                    while (arr[j - 1] == arr[j])
                        ++j;
                    while (arr[k + 1] == arr[k])
                        ++k;
                }

                sum = arr[i] + arr[j] + arr[k];
            }
        }
        return result;
    }

    public static void quickSort(int[] arr, int low, int high){
        int pivotKey = arr[low];
        int start = low;
        int end = high;
        while (start < end){
            while (arr[end] >= pivotKey && end > start)
                --end;
            swap(arr, end, start);

            while (arr[start] <= pivotKey && start < end)
                ++start;
            swap(arr, start, end);
        }

        if(start - 1 > low)
            quickSort(arr, low, start - 1);
        if(end + 1 < high)
            quickSort(arr, end + 1, high);
    }

    public static void swap(int[] arr, int num1, int num2){
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,3,-1,-4};
        int target = 0;
        List<List<Integer>> result = getThreeElements(arr, target);
        System.out.print(result);
    }
}
