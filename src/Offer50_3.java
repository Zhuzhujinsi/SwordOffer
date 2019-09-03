import java.util.HashMap;
import java.util.Map;

public class Offer50_3 {
    /*
    定义一个函数，删除字符串中所有重复出现的字符。
     */
    public String deleteDuplicate(String str){
        if(str == null)
            return null;

        char [] temp = str.toCharArray();
        Map<Character, Boolean> map = new HashMap<>();
        int fast = 0;
        int slow = 0;
        while (fast < temp.length){
            if(map.isEmpty() || !map.keySet().contains(temp[fast])){
                map.put(temp[fast], true);
                if(slow != fast) {
                    temp[slow] = temp[fast];
                }
                ++slow;
                ++fast;
            }else
                ++fast;
        }
        return new String(temp, 0, slow);
    }

    public static void main(String[] args) {
        Offer50_3 offer50_3 = new Offer50_3();
        System.out.println(offer50_3.deleteDuplicate("google"));
        System.out.println(offer50_3.deleteDuplicate("gggg"));
        System.out.println(offer50_3.deleteDuplicate("cacacacabbbb"));
    }
}
