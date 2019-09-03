import java.util.HashMap;
import java.util.Map;

public class Offer50_4 {
    /*
    在英语中，如果两个单词中出现的字母相同，并且每个字母出现的次数也相同，那么这两个单词互为变位词。
    例如，silent与listen、evil与live等互为变位词。
    请完成一个函数，判断输入的两个字符串是不是互为变位词。
     */
    public boolean variant(String str1, String str2){
        if(str1 == null && str2 == null)
            return true;
        if(str1 == null || str2 == null)
            return false;

        Map<Character, Integer> map = new HashMap<>();
        char [] s1 = str1.toCharArray();
        char [] s2 = str2.toCharArray();

        for (int i = 0; i < str1.length(); ++i){
            if(map.isEmpty() || !map.keySet().contains(s1[i])){
                map.put(s1[i], 1);
            }else {
                map.put(s1[i], map.get(s1[i]) + 1);
            }
        }

        for(int j = 0; j < str2.length(); ++j){
            if(map.keySet().contains(s2[j])){
                map.put(s2[j], map.get(s2[j]) - 1);
            }else
                return false;
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Offer50_4 offer50_4 = new Offer50_4();
        System.out.println(offer50_4.variant("silent", "listen"));
        System.out.println(offer50_4.variant("evil", "live"));
        System.out.println(offer50_4.variant("evil", "livepp"));
    }
}
