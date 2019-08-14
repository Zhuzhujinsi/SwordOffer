import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Offer62 {
    //public static int lastRemaining(int n, int m){
//        if(n < 1 || m < 1) {
//            throw new RuntimeException("输入不合法");
//        }
//        return n == 1 ? 0 : (lastRemaining(n - 1, m) + m) % n;
//    }

    public static int lastRemaining(int n, int m) {
        if(n < 1 || m < 1)
            return -1;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            list.add(i);

        int current = 0;
        while (list.size() != 1){
            for(int i = m; i > 1; --i){
                if(current == list.size() - 1)
                    current = 0;
                else
                    ++current;
            }
            list.remove(current);
            if(current == list.size())
                current = 0;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(lastRemaining(sc.nextInt(), sc.nextInt()));
    }
}
