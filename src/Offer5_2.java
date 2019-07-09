public class Offer5_2 {
//两个排序数组A1、A2，将A2插入到A1中，并保证插入后数组有序！
    public static void add(StringBuffer str1, StringBuffer str2){
        if(str2 == null || str2.length() == 0 || str1 == null)
            return;
        int length2 = str2.length();
        int length1 = str1.length();
        int lengthNew1 = length1 + length2;
        str1.setLength(lengthNew1);
        int indexNewOfStr1 = lengthNew1 - 1;
        int indexOriginalOfStr1 = length1 - 1;
        int indexOfStr2 = length2 - 1;
        while (indexOfStr2 >= 0 && indexOriginalOfStr1 >= 0){
            if(str1.charAt(indexOriginalOfStr1) > str2.charAt(indexOfStr2))
                str1.setCharAt(indexNewOfStr1--, str1.charAt(indexOriginalOfStr1--));
            else
                str1.setCharAt(indexNewOfStr1--, str2.charAt(indexOfStr2--));
        }

        while (indexOfStr2 >= 0){
            str1.setCharAt(indexNewOfStr1--, str2.charAt(indexOfStr2--));
        }
        while (indexOriginalOfStr1 >= 0){
            str1.setCharAt(indexNewOfStr1--, str1.charAt(indexOriginalOfStr1--));
        }

    }

    public static void main(String[] args) {
       StringBuffer str1Test = new StringBuffer("129");
       StringBuffer str2Test = new StringBuffer("234");
       add(str1Test, str2Test);
       System.out.print(str1Test);
       System.out.println();
    }
}
