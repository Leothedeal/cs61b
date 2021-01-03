package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void generalTest() {
        // test between two ring buffer
        ArrayRingBuffer arb = new ArrayRingBuffer(4);
        ArrayRingBuffer ar = new ArrayRingBuffer(4);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.dequeue();
        arb.enqueue(5);
        ar.enqueue(5);
        ar.enqueue(2);
        ar.enqueue(3);
        ar.enqueue(4);
        int actual = (Integer) arb.dequeue();
        ar.dequeue();
        int expected = (Integer) ar.peek();
        int actual1 = (Integer) arb.dequeue();
        ar.dequeue();
        int expected1 = (Integer) ar.peek();
        assertEquals("sorry,they are not equal!", expected, actual);
        assertEquals("sorry,they are not equal!", expected1, actual1);
    }

    @Test
    public void testEnqueue() {
        //test whether the enqueue goes back to zero when last equals capacity
        ArrayRingBuffer arb = new ArrayRingBuffer(4);
        arb.enqueue(56.2);
        arb.enqueue(44.8);
        arb.enqueue(45.1);
        arb.enqueue(66.8); //56.2 44.8 45.1 66.8
        arb.dequeue(); //null 44.8 45.1 66.8 first=1 last=4
        arb.enqueue(21.8); //21.8 44.8 45.1 66.8 first=1 last=1
        assertEquals(44.8, arb.dequeue());
        assertEquals(45.1, arb.peek());
        arb.dequeue();
        assertEquals(66.8, arb.peek());
    }

    @Test
    public void testDequeue() {
        //test whether dequeue goes back to zero when first equals capacity
        ArrayRingBuffer arb = new ArrayRingBuffer(4);
        arb.enqueue(56.2);
        arb.enqueue(44.8);
        arb.enqueue(45.1);
        arb.enqueue(66.8); //56.2 44.8 45.1 66.8
        arb.dequeue(); //null 44.8 45.1 66.8 first=1 last=4
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        arb.enqueue(21.8); //null null null null 21.8 first=0 last=0
        assertEquals(21.8, arb.dequeue());}
        /*Test一开始的思路好像歪了，老想着要用assertEqual来判断两个RingBuffer是否相等，实际上用peek和dequeue就行*/
        /** Calls tests for ArrayRingBuffer. */
        public static void main(String[] args){
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);

    }
}
