import java.util.HashMap;
import java.util.Map;

public class Offer50_2 {
    /*
    定义一个函数，输入两个字符串，从第一个字符串中删除在第二个字符串中出现过的所有字符。
     */

    public String deleteSpecificChars(String strSource, String strDelete){
        if(strSource == null)
            return null;
        if(strDelete == null)
            return strSource;
        char [] charSource = strSource.toCharArray();
        char [] charDelete = strDelete.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charDelete.length; ++i){
            map.put(charDelete[i], 1);
        }

        int fast = 0;
        int slow = 0;
        while (fast < charSource.length){
            while (map.keySet().contains(charSource[fast])){
                ++fast;
            }

            if(slow != fast){
                charSource[slow++] = charSource[fast++];
            }else {
                ++slow;
                ++fast;
            }
        }

        return new String(charSource, 0, slow);//注意这个构造方法！
    }

    public static void main(String[] args) {
        Offer50_2 offer50_2 = new Offer50_2();
        System.out.println(offer50_2.deleteSpecificChars("We are student", "aeiou"));
    }
}
