// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import synthesizer.BoundedQueue;


//Make sure this class is public
public class GuitarString {
    /**
     * Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday.
     */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        // TODO: Create a buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this divsion operation into an int. For better
        //       accuracy, use the Math.round() function before casting.
        //       Your buffer should be initially filled with zeros.
        long before = Math.round(SR / frequency);
        int result = (int) before;
        buffer = new ArrayRingBuffer<Double>(result);
        for (int i = 0; i < result; i++) {
            buffer.enqueue(0.0);
        }

    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        // TODO: Dequeue everything in the buffer, and replace it with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each other.
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.dequeue();
            double r = Math.random() - 0.5;
            buffer.enqueue(r);
        }
    }
    /*pluck 这里出了一点问题，所以还是不能只看TODO，我原来的理解是全部deque完之后
    再enqueue，而实际的算法是deque一个double之后立马又在队尾enqueue一个计算所得
    的值，若不按原算法来，很容易听到的TTFAF播放的音乐像敲桌子
   */

        /* Advance the simulation one time step by performing one iteration of
         * the Karplus-Strong algorithm.
         */
        public void tic () {
            // TODO: Dequeue the front sample and enqueue a new sample that is
            //       the average of the two multiplied by the DECAY factor.
            //       Do not call StdAudio.play().
            double first = buffer.dequeue();
            double second = buffer.peek();
            double avr = 0.5 * (first + second);
            buffer.enqueue(DECAY * avr);
        }

        /* Return the double at the front of the buffer. */
        public double sample () {
            // TODO: Return the correct thing.
            return buffer.peek();
        }
    }

