public class Offer46 {
    /*
    把数字翻译成字符串！
    给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成“a”，1翻译成“b”，......，11翻译成“1”，......25翻译成“z”。
    一个数字可能有多个翻译。例如，12258有5中不同的翻译，分别是“bccfi”、“bwfi”、“bczi”、“mcfi”和“mzi”。
    请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     */
    /*
    重要的是得出公式：f(i) = f(i+1) + g(i,i+1)*f(i+2) 递归从上到下分析，循环从下向上实现！
     */
    public int getTranslationCount(int number){
        if(number < 0)
            return 0;

        char [] arr = String.valueOf(number).toCharArray();
        return getTranslationCountCore(arr);
    }

    public int getTranslationCountCore(char [] arr){
        int length = arr.length;
        int [] counts = new int[length];
        int count = 0;
        for(int i = length - 1; i >= 0; --i){
            if(i < length - 1){
                count = counts[i + 1];
            }else
                count = 1;

            if(i < length - 1){
                int digitLow = arr[i] - '0';
                int digitHigh = arr[i] - '0';
                int convert = digitLow * 10 + digitHigh;
                if(convert >= 10 && convert <= 25){
                    if(i < length - 2){
                        count += counts[i + 2];
                    }else
                        count += 1;
                }
            }

            counts[i] = count;
        }

        return counts[0];
    }

    public static void main(String[] args) {
        Offer46 offer46 = new Offer46();
        System.out.println(offer46.getTranslationCount(12258));
    }
}
