public class Offer5 {
//从后往前赋值，降低时间复杂度!
    public static String replaceBlank(StringBuffer str){
        if(str == null)
            return null;
        String string = str.toString();
        int numberOfBlank = 0;
        int originalLength = str.length();
        for (int i = 0; i < originalLength; ++i){
            if(str.charAt(i) == ' ')
                ++numberOfBlank;
        }

        int newLength = originalLength + 2 * numberOfBlank;
        str.setLength(newLength);
        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;
        while (indexOfNew != indexOfOriginal){
            if(string.charAt(indexOfOriginal) == ' '){
                str.setCharAt(indexOfNew--, '0');
                str.setCharAt(indexOfNew--, '2');
                str.setCharAt(indexOfNew--, '%');
                --indexOfOriginal;
            }else {
                str.setCharAt(indexOfNew--, string.charAt(indexOfOriginal--));
            }
        }
        return String.valueOf(str);
    }

    public static void main(String[] args) {
        StringBuffer test = new StringBuffer("we are happy");
        System.out.print(replaceBlank(test));
        System.out.println();
    }
}
