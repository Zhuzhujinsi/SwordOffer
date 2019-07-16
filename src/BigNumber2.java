public class BigNumber2 {
    //打印从1到最大的n位数
    /*
    在字符串上模拟数字的加减法！
     */
    public void print1ToMaxOfNDigits(int n){
        char[] number = new char[n];
        for (int i = 0; i < n; ++i){
            number[i] = '0';
        }
        while (!increment(number)){
            printNumber(number);
        }
    }

    public boolean increment(char[] number){
        boolean overFlow = false;
        int takeOver = 0;
        for (int i = number.length - 1; i >= 0; --i){
            int sum = number[i] - '0' + takeOver;
            if(i == number.length - 1)
                ++sum;
            if(sum == 10){
                if(i == 0){
                    overFlow = true;
                }else {
                    takeOver = 1;
                    number[i] = '0';
                }
            }else {
                number[i] = (char)('0' + sum);
                break;
            }
        }
        return overFlow;
    }

    public void printNumber(char[] number){
        boolean isBeginning0 = true;
        for (int i = 0; i <= number.length - 1; ++i){
            if(isBeginning0 && number[i] != '0')
                isBeginning0 = false;

            if(!isBeginning0)
                System.out.print(number[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BigNumber2 bigNumber2 = new BigNumber2();
        bigNumber2.print1ToMaxOfNDigits(2);
    }
}
