public class Offer3_2 {
    public static int getDuplication(int[] numbers, int length) {
        if (numbers == null || length <= 0)
            return -1;
//        for (int i = 0; i < length; ++i) {
//            if (numbers[i] < 1 || numbers[i] >= length)
//                return -1;
//        }

        int start = 1;
        int end = length - 1;
        while (end >= start) {
            int mid = (start + end) >> 1;
            int countLeft = countRange(numbers, start, mid);//先判断1-mid中是否存在重复值
            if(start == end){
                if(countLeft > mid - start + 1)
                    return  start;
                else
                    break;
            }
            if(countLeft > mid - start + 1) {
                end = mid;
                //continue;//如果1-mid存在重复值，则不判断（mid+1）- end
            }else
                start = mid + 1;

//            int countRight = countRange(numbers, mid + 1, end);//判断（mid+1）- end中是否尊在重复值
//            if(end == start){
//                if(countRight > end - mid)
//                    return  start;
//                else
//                    break;
//            }
//            if(countRight > end - mid)
//                start = mid + 1;
        }
        return -1;
    }


        public static int countRange(int[] arr, int start, int end){
            int count = 0;
            for (int i = 0; i <= arr.length - 1; ++i) {
                if (arr[i] >= start && arr[i] <= end)
                    ++count;
            }
            return count;
        }

    public static void main(String[] args) {
        int[] test = {2,3,5,4,3,2,6,7};
        System.out.print(getDuplication(test, 8));
        System.out.println();
    }

}
