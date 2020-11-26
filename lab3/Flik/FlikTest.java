import org.junit.Test;
import static org.junit.Assert.*;
public class  FlikTest {
    @Test
    public void TestFlik()

    {
        int x = 1;
        int y = 2;
        if(Flik.isSameNumber(x, y))
            System.out.println("Cong! x is equal to y");
        else System.out.println("oops!x and y is not equal");
        assertTrue(!Flik.isSameNumber(x, y));
        int a = 1;
        int b = 1;
        if(Flik.isSameNumber(a, b))
            System.out.println("Cong! a is equal to b");
        else System.out.println("oops!a and b is not equal");
        assertTrue(Flik.isSameNumber(a, b));
        int m = 128;
        int n = 128;
        if(Flik.isSameNumber(m, n))
            System.out.println("Cong! m is equal to n");
        else System.out.println("oops!m and n is not equal");
        assertTrue(Flik.isSameNumber(m, n));
    }
}