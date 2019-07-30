public class Offer_44 {
    /*
    数字以012345678910111213141516171819......的格式序列化到一个字符序列中。
    在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。
    请写一个函数，求任意第n位对应的数字。
     */
    public int digitAtIndex(int index){
        if(index < 0)
            return -1;

        int digits = 1;
        int numbers;
        while (true){
            numbers = countOfIntegers(digits);
            if(index < numbers * digits)
                return digitAtIndex(index, digits);

            index -= numbers * digits;
            ++digits;
        }
    }

    public int countOfIntegers(int digits){
        if(digits == 1)
            return 10;

        return 9 * (int) Math.pow(10, digits - 1);
    }

    public int digitAtIndex(int index, int digits){
        int beginNumber = beginNumber(digits);
        int number = beginNumber + index / digits;
        int count = index % digits;
        int result = 0;
        while (count != -1){
            result = number % 10;
            --count;
            number /= 10;
        }
        return result;
    }

    public int beginNumber(int digits){
        if(digits == 1)
            return 0;
        return (int)Math.pow(10, digits - 1);
    }

    public static void main(String[] args) {
        Offer_44 offer_44 = new Offer_44();
        System.out.println(offer_44.digitAtIndex(13));
    }

}
