public class Intern {
/*
    intern()：返回值：一个字符串，内容与此字符串相同，但一定取自具有唯一字符串的池。
    尽管在输出中调用intern方法并没有什么效果，但是实际上后台这个方法会做一系列的动作和操作。在调用ab.intern()方法的时候会返回“ab”，
    但是这个方法会首先检查字符串常量池中是否有“ab”这个字符串，如果存在则返回这个字符串的引用，否则就将这个字符串添加到字符串池中，
    然后返回这个字符串的引用。
 */
    public static void main(String[] args) {
        String str1 = "a";
        String str2 = "b";
        String str6 = "a" + "b";//字符串相加的时候，都是静态字符串的结果会添加到字符串池
        String str3 = "ab";
        String str4 = str1 + str2;//字符串相加时，如果存在一个及一个以上变量，则不会进入到字符串池中。
        String str5 = new String("ab");//new创建的字符串对象不进入字符串池，

        System.out.println(str5.equals(str3));
        System.out.println(str5 == str3);
        System.out.println(str5.intern() == str3);
        System.out.println(str5.intern() == str4);
    }
}
