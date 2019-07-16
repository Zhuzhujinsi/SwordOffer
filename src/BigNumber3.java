public class BigNumber3 {
    //实现两个任意整数的加法
    /*
    在字符串上模拟数字的加法
     */
    public char[] add(String str1, String str2){
        char[] number1 = str1.toCharArray();
        char[] number2 = str2.toCharArray();
        int sum = 0;
        int takeOver = 0;
        boolean flag = false;
        char[] num = null;
        // 两个大数做加法运算有两种情况1. 一正一负 2.同时为正或同时为负数
        // 对于第一种情况取绝对值做减法运算，如果负数的绝对值更大则结果是负数，否则结果为正数
        // 对于第二种情况 直接做加法运算 同为正数 结果则为正数 否则结果为负数
        //第一种情况
        if((number1[0] == '-' && number2[0] != '-') || (number1[0] != '-' && number2[0] == '-')) {
            if (number1[0] == '-' && number2[0] != '-') {
                number1 = absNum(number1);
                number2 = absNum(number2);
                if (getMaxAbs(number2, number1)) {
                    char[] temp = number2;
                    number2 = temp;
                    number1 = number2;//将绝对值较大的赋值给num1
                } else
                    flag = true;//结果为负数
            } else {
                number1 = absNum(number1);
                number2 = absNum(number2);
                if (getMaxAbs(number2, number1)) {
                    flag = true;//结果为负数
                    char[] temp = number2;
                    number2 = number1;
                    number1 = temp;////将绝对值较大的赋值给num1
                }
            }

            num = new char[number1.length];
            for (int i = number1.length - 1, j = number2.length - 1; i >= 0; --i, --j) {
                if (j >= 0) {
                    sum = number1[i] - number2[j] + takeOver;
                    if (sum < 0) {
                        takeOver = -1;
                        sum += 10;
                        num[i] = (char) (sum + '0');
                    } else {
                        takeOver = 0;
                        num[i] = (char) (sum + '0');
                    }
                }else{
                    sum = number1[i] - '0' + takeOver;
                    if(sum < 0){
                        takeOver = -1;
                        sum += 10;
                        num[i] = (char)(sum + '0');
                    }else{
                        takeOver = 0;
                        num[i] = (char)(sum + '0');
                    }
                }
            }
        }else {//第二种情况
            if(number1[0] == '-' && number2[0] == '-'){
                number1 = absNum(number1);
                number2 = absNum(number2);
                flag = true;
            }
            if(getMaxAbs(number2, number1)){
                char[] temp = number2;
                number2 = number1;
                number1 = temp;//还是把大的赋值给number1
            }
            num = new char[number1.length];
            for(int i = number1.length - 1, j = number2.length - 1; i >= 0; --i, --j){
                if (j >= 0) {
                    sum = number1[i] - '0' + number2[j] - '0' + takeOver;
                    if (sum >= 10) {
                        // 相加大于等于十 产生进位
                        takeOver = 1;
                        sum -= 10;
                        num[i] = (char) (sum + '0');
                    } else {
                        takeOver = 0;
                        num[i] = (char) (sum + '0');
                    }
                } else {
                    sum = number1[i] - '0' + takeOver;
                    if (sum >= 10) {
                        takeOver = 1;
                        sum -= 10;
                        num[i] = (char) (sum + '0');
                    } else {
                        takeOver = 0;
                        num[i] = (char) (sum + '0');
                    }
                }
            }
        }

        if(flag){
            char[] temp = new char[num.length + 1];
            temp[0] = '-';
            for(int i = 0; i <= num.length - 1; ++i){
                temp[i + 1] = num[i];
            }
            return temp;
        }else
            return num;
    }
    //获得一个数的绝对值（字符数组表示）
    public char[] absNum(char[] num){
        if(num[0] != '-')
            return num;

        char[] temp = new char[num.length - 1];
        for(int i = 0; i < num.length - 1; ++i){
            temp[i] = num[i + 1];
        }
        return temp;

    }

    //判断两个数的绝对值大小
    public boolean getMaxAbs(char[] num1, char[] num2){
        num1 = absNum(num1);
        num2 = absNum(num2);
        int length1 = num1.length;
        int length2 = num2.length;
        if(length1 > length2)
            return true;
        if(length1 < length2)
            return false;
        for (int i = 0; i < length1; ++i){
            if(num1[i] > num2[i])
                return true;
            if(num1[i] < num2[i])
                return false;
        }
        return true;//如果两个数相等返回true
    }

    public void printNumber(char[] number){
        int i = 0;
        if(number[0] == '-') {//如果第一个字符为‘-’，则先打印出该字符，然后i从1开始遍历该字符数组
            System.out.print('-');
            i = 1;
        }
        boolean isBeginning0 = true;
        for (; i < number.length; ++i){
            if(isBeginning0 && number[i] != '0')
                isBeginning0 = false;

            if(!isBeginning0)
                System.out.print(number[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String num1 = "-1004215696420130001";
        String num2 = "123";
        BigNumber3 bigNumber3 = new BigNumber3();
        char[] num = bigNumber3.add(num1, num2);
        bigNumber3.printNumber(num);
    }
}
