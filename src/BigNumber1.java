public class BigNumber1 {
    //打印从1到最大的n位数
    /*
    解法一：全排列递归
     */
    public void print1ToMaxOfNDigits(int n){
        char[] number = new char[n];
        for (int i = 0; i < n; ++i){
            number[i] = '0';
        }
        for(int i = 0; i< 10; ++i){
            number[0] = (char)(i + '0');
            print1ToMaxOfNDigitsRecursively(number, 0);
        }
    }

    public void print1ToMaxOfNDigitsRecursively(char[] number, int index){
        if(index == number.length - 1) {
            printNumber(number);
            return;
        }
        for(int i = 0; i < 10; ++i){
            number[index + 1] = (char)(i + '0');
            print1ToMaxOfNDigitsRecursively(number, index + 1);
        }

    }

    public void printNumber(char[] number){
        boolean isBeginning0 = true;
        for (int i = 0; i <= number.length - 1; ++i){
            if(isBeginning0 && number[i] != '0')//之所前面加isBeginning0是考虑效率问题，不必每次都设置isBeginning0！
                isBeginning0 = false;
            if(!isBeginning0)
                System.out.print(number[i]);
        }
    }

    public static void main(String[] args) {
        BigNumber1 bigNumber = new BigNumber1();
        bigNumber.print1ToMaxOfNDigits(2);
    }
}
