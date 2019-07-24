import java.util.ArrayList;

public class SuperCombinate {
    /*
    更牛的组合方法，因为组合问题，比如3个元素的组合就有2^3 - 1种，所以不妨给他们进行编号，
    就像Combinate问题，从a-->abc依次编号为001-->111。1就代表该位置出现字符。例如：001->c,010->b,101->ac...，
    所以原题就是要求输出“001”-“111”这2^n - 1个组合对应的字符串。
     */

    public ArrayList<String> superCombinate(String s){
        int len = s.length();
        ArrayList<String> list = new ArrayList<>();
        int count = (int)Math.pow(2, len);
        for(int i = 1; i < count; ++i){
            String temp = "";
            String str = Integer.toBinaryString(i);
            while (str.length() < len){
                str = "0" + str;
            }

            for (int j = 0; j < str.length(); ++j){
                if(str.charAt(j) == '1'){
                    temp += s.charAt(j);
                }
            }
            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        SuperCombinate superCombinate = new SuperCombinate();
        String s = "abc";
        ArrayList list = superCombinate.superCombinate(s);
        System.out.println(list);
    }
}
