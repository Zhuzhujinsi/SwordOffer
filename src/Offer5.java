public class Offer5 {
//从后往前赋值，降低时间复杂度
    public static void replaceBlank(char[] arr){
        int originalLength = 0;
        int numberOfBlank = 0;
        for (int i = 0; i < arr.length; ++i){
            if(i == 12)
                break;
            ++originalLength;
            if(arr[i] == ' ')
                ++numberOfBlank;
        }

        int newLength = originalLength + 2 * numberOfBlank;
        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;
        while (indexOfNew != indexOfOriginal){
            if(arr[indexOfOriginal] == ' '){
                arr[indexOfNew--] = '0';
                arr[indexOfNew--] = '2';
                arr[indexOfNew--] = '%';
                --indexOfOriginal;
            }else {
                arr[indexOfNew--] = arr[indexOfOriginal--];
            }
        }
    }

    public static void main(String[] args) {
        char[] test = new char[20];
        test[0] = 'w';
        test[1] = 'e';
        test[2] = ' ';
        test[3] = 'a';
        test[4] = 'r';
        test[5] = 'e';
        test[6] = ' ';
        test[7] = 'h';
        test[8] = 'a';
        test[9] = 'p';
        test[10] = 'p';
        test[11] = 'y';
        replaceBlank(test);
        for (Character character: test){
            System.out.print(character);
        }
        System.out.println();
    }
}
