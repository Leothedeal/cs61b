public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }
}
//when the value of i and j turns to 128
//the condition in if turns to true and then trigger the break
//@source https://github.com/seriouszyx/cs61b/tree/master/lab3
//原因是integer是对象类型，"=="符号比较的是两者的地址，在给Integer赋值时，
// 实际上是自动装箱的过程，也就是调用了Integer.valueOf(int)方法，
// 当这个值大于等于-128小于等于127时使用了常量池，所以两个地址是相等的，
// 而超出此范围则不使用常量池，故不相等。
