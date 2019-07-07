public class Test {
    public static void main(String[] args) {
        int i = 0;
        while (i < 5) {
            if(i == 3){
                if(false) {

                }else
                    break;
            }
            System.out.print(i);
            ++i;
            System.out.println();
        }
    }
}
