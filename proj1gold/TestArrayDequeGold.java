/*@Author Leo
*@Date 2020/12/7
*/
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestArrayDequeGold {
    StudentArrayDeque<Integer> sa = new StudentArrayDeque<>();
    ArrayDequeSolution as = new ArrayDequeSolution();

    @Test
    public void testDeque1() {
        Random ran = new Random();
        int[] a1=new int[9];
        int[] b1=new int[9];
        //test addFirst
        for (int i = 0; i < 9; i++) {
            int b=StdRandom.uniform(100);
            sa.addFirst(b);
            as.addFirst(b);
            a1[i]=sa.get(i);
            b1[i]=(Integer) as.get(i);
            assertEquals(b1[i],a1[i]);
        }
        //test addLast
        for (int i = 0; i < 9; i++) {
            int b=StdRandom.uniform(100);
            sa.addLast(b);
            as.addLast(b);
            a1[i]=sa.get(i);
            b1[i]=(Integer) as.get(i);
            assertEquals(b1[i],a1[i]);
        }
    }

    @Test
    public void testDequeRemoveFirst() {
        for (int i = 0; i < 9; i++) {
            int b=StdRandom.uniform(100);
            sa.addFirst(b);
            as.addFirst(b);
        }
        for (int i = 0; i < 9; i++) {
            int x=sa.removeFirst();
            int y=(Integer) as.removeFirst();
            assertEquals(y,x);
        }
    }

    @Test
    public void testDequeRemoveLast() {
        List<Integer> expectedList=new ArrayList<>();
        List<Integer> actualList=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int b=StdRandom.uniform(100);
            sa.addFirst(b);
            as.addFirst(b);
        }
        for (int i = 0; i <10; i++) {
            expectedList.add((Integer) as.removeLast());
            actualList.add(sa.removeLast());
        }
        assertEquals(expectedList,actualList);
    }
    @Test
    public void testArrayDeque2(){
        StudentArrayDeque<Integer> sa = new StudentArrayDeque<>();
        ArrayDequeSolution as = new ArrayDequeSolution();
        List<Integer> expectedList=new ArrayList<>();
        List<Integer> actualList=new ArrayList<>();
            int b=StdRandom.uniform(100);
            sa.addFirst(b);
            as.addFirst(b);
            expectedList.add((Integer) as.get(0));
            actualList.add(sa.get(0));
        assertEquals("addFirst("+b+")", expectedList, actualList);
        System.out.println("addFirst("+b+")");
        int c=StdRandom.uniform(100);
        sa.addLast(c);
        as.addLast(c);
        expectedList.add((Integer) as.get(1));
        actualList.add(sa.get(1));
        assertEquals("addFirst("+c+")", expectedList, actualList);
        System.out.println("addLast("+c+")");
        int actual = sa.removeLast();
        int expected = (Integer) sa.removeLast();
        assertEquals("removeLast()", expected, actual);
        System.out.println("removeLast()");
        actual = sa.removeFirst();
        expected = (Integer) as.removeFirst();
        assertEquals("removeFirst()", actual, expected);
        System.out.println("removeFirst()");
    }

}





