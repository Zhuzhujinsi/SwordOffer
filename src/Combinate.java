import java.util.Stack;

public class Combinate {
    /*
    题目：{a,b,c}要求输出{a,b,c,ab,ac,abc}。
    分析：可以将题目分成小问题来理解，1个字符的组合 + 2个字符的组合 + 3个字符的组合，
    因此只要找到一般的方法，即从n个字符中找m个字符的组合就可以了
    我们可以把n个字符分成两部分，第一个字符和其它所有字符。如果组合里包含第一个字符，则下一步在剩余的字符里选取m-1个字符；
    如果组合里不包含第一个字符，则下一步在剩余的n-1个字符里选取m个字符，从中可以看出又是个递归的过程
     */
    Stack<Character> stack = new Stack<>();
    public void helper(char [] array){
        if(array == null || array.length == 0)
            return;
        for(int i = 1; i <= array.length; ++i){
            combinate(array, 0, i);
        }
    }

    public void combinate(char [] arr, int start, int sum){
        if(sum == 0){
            System.out.println(stack);
            return;
        }

        if(start == arr.length)
            return;

        //把第一个字符放入组合中，在剩余的字符中选取num-1个字符
        stack.push(arr[start]);
        combinate(arr, start + 1, sum - 1);
        //组合里不包含第一个字符，则下一步在剩余的字符中选取num个字符
        stack.pop();
        combinate(arr, start + 1, sum);
    }

    public static void main(String[] args) {
        char [] test = {'a', 'b', 'c'};
        Combinate combinate = new Combinate();
        combinate.helper(test);
    }
}
