public class BigNumber3 {
    //实现两个任意整数的加法
    /*
    在字符串上模拟数字的加法
     */
    public void add(char[] number1, char[] number2){
        if(number1 == null || number2 == null)
            return;
        if(number1.length == 0){
            printNumber(number2);
            return;
        }
        if(number2.length == 0){
            printNumber(number1);
            return;
        }
        int length1 = number1.length;
        int length2 = number2.length;
        int length = (length1 > length2) ? length1 + 1 : length2 + 1;
        char[] result = new char[length];
        int takeOver = 0;
        int sum;
        int index1 = length1 - 1;
        int index2 = length2 - 1;
        for(int i = length - 1; i >= 0; --i){
            if(index1 >= 0 && index2 >= 0){
                sum = (number1[index1] - '0') + (number2[index2] - '0') + takeOver;
            }else if(index1 >= 0 && index2 < 0){
                sum = number1[index1] - '0' + takeOver;
            }else if(index1 < 0 && index2 >= 0){
                sum = number2[index2] - '0' + takeOver;
            }else
                sum = takeOver;
            --index1;
            --index2;

            if(sum >= 10){
                sum -= 10;
                takeOver = 1;
                result[i] = (char)('0' + sum);
            }else {
                result[i] = (char) ('0' + sum);
                takeOver = 0;
            }
        }
        printNumber(result);

    }

    public void printNumber(char[] number){
        boolean isBeginning0 = true;
        for (int i = 0; i < number.length; ++i){
            if(isBeginning0 && number[i] != '0')
                isBeginning0 = false;

            if(!isBeginning0)
                System.out.print(number[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] number1 = {'3', '5', '4'};
        char[] number2 = {'1', '2', '6', '9'};
        BigNumber3 bigNumber3 = new BigNumber3();
        bigNumber3.add(number1, number2);
    }
}
