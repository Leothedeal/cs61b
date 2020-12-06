import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    OffByN offBy5=new OffByN(5);
    // Your tests go here.
    @Test
    public void testOffByN() {
        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('f', 'a'));
        assertFalse(offBy5.equalChars('f', 'h'));

    }



    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
}
