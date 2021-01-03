// TODO: Make sure to make this class a part of the synthesizer package
 package synthesizer;
import java.util.Iterator;


//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.capacity=capacity;
        first=0;
        last=0;
        fillCount=0;
        rb=(T[])new Object[capacity]; /*之前写的rb=new T[capacity]会直接报错，显示不能直接将rb instantiate，弄半天弄不出来，于是
                                      参考了下别人的代码，看这个思路是先创建一个Object，然后将Object强制转型成T*/
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if(!isFull()){
            if(last==capacity){ //注意这里的判定条件
                last=0;
            }
            rb[last]=x;
            fillCount++;
            last++;
            }

        else throw new RuntimeException("Ring buffer overflow");
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        /*T toReturn;
        if(!isEmpty()){
            if(first==capacity){   //判断条件这里卡了好久，到队尾循环要考虑清楚
                toReturn=rb[capacity-1];
                rb[first-1]=null;
                first=0;
                fillCount--;

            }
            else{toReturn=rb[first];
            rb[first]=null;
            first++;
            fillCount--;}
            //toReturn = rb[first];
            //rb[first] = null;
            //first = (first + 1 == capacity ? 0 : first + 1);
            //fillCount -= 1;
        }
        else throw new RuntimeException("Ring buffer underflow");
        return toReturn;  //刚开始写的时候少了return T，并且throw这里少了else，导致数组非空也产生了RuntimeException*/
        if(!isEmpty()){
            if(first==capacity){
                first=0;
            }
            T toReturn=rb[first];
            rb[first]=null;
            fillCount--;
            first++;
            return toReturn;
        }
        else throw new RuntimeException("Ring buffer underflow");
    }

    /**
     * Return oldest item, but don't remove it.
     */
   public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if(first==capacity){
            first=0;
        }
       return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
