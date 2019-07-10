import java.util.LinkedList;
import java.util.Queue;

public class Offer9_2 {
    //两个队列实现栈
    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();
    public static void push(int key){
        if(queue1.isEmpty())
            queue1.offer(key);
        else
            queue2.offer(key);
    }

    public static int pop(){
        if(queue2.isEmpty()){
            while (queue1.size() != 1){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }else{
            while (queue2.size() != 1){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }


}
