public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private final int INITIAL_CAPACITY = 8;

    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0 ? true : false);
    }

    public int minusOne(int index) {
        return Math.floorMod(index-1, items.length);
    }


    public int plusOne(int index) {
        return Math.floorMod(index+1, items.length);
    }

    public int plusOne(int index, int length) {
        return Math.floorMod(index+1, length);
    }

    /**
     *  invariants:
     *      设计resize()方法，将在增加ArrayDeaue实例内存的方法中调用
     *      内部判断内存满则调用expand()增加内存
     *        如果内存过小则调用reduce()减小内存
     **/

    private void resize() {
        if (size == items.length) {
            expand();
        }
        if (size < items.length / 4 && items.length > 8) {
            reduce();
        }
    }

    private void expand() {
        resizeHelper(items.length * 2);
    }

    private void reduce() {
        resizeHelper(items.length / 2);
    }

    private void resizeHelper(int capacity) {
        T[] temp = items;
        int begin = plusOne(nextFirst);
        int end = minusOne(nextLast);
        items = (T[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        for (int i=begin; i != end; i = plusOne(i, temp.length)) {
            items[nextLast] = temp[i];
            nextLast = plusOne(nextLast);
        }
        items[nextLast] = temp[end];
        nextLast = plusOne(nextLast);
    }

    /**
     *  invariants:
     *      通过minusOne()方法确定nextFirst，(nextFirst-1)%items.length
     *      即nextFirst的下一个位置
     *      eg. (0 - 1) % 8 = 7
     *
     * */
    public void addFirst(T item) {
        // resize();
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }
    /*此时nextFirst=0，将要添加的首元素加入之后，nextFirst运算后变为7，符合
    Deque双向运行的特点
    */

    public T getFirst() {
        return items[plusOne(nextFirst)];
    }

    public T removeFirst() {
        resize();
        T res = getFirst();
        nextFirst = plusOne(nextFirst);
        items[nextFirst] = null;
        size--;
        return res;
    }

    public void addLast(T item) {
        resize();
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    public T getLast() {
        return items[minusOne(nextLast)];
    }

    public T removeLast() {
        resize();
        T res = getLast();
        nextLast = minusOne(nextLast);
        items[nextLast] = null;
        size--;
        return res;
    }

    public void printDeque() {
        for (int index = plusOne(nextFirst); index != nextLast; index = plusOne(index)) {
            System.out.print(items[index]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        index = Math.floorMod(plusOne(nextFirst) + index, items.length);
        return items[index];
    }
    /*由于ArrayDeque的最后一个元素被放置在第一位，所以对于arrayDeque就存在这样的对应关系
    首个元素，也就是传统意义上的 a[0],实际上对应arrayDeque里面的a[1],而a[0]对应的则是最末尾的
    元素a[7].所以index=7时，实际上要返回a[0]的值，index=0时，实际上要返回a[1]的值。
   */




    public static void main(String[] args) {
        ArrayDeque<Integer> aq = new ArrayDeque<Integer>();
        for (int i = 0; i < 100; i++) {
            aq.addLast(i);
        }
        aq.printDeque();
        for (int i = 0; i < 98; i++) {
            aq.removeFirst();
        }
        aq.printDeque();
        System.out.println(aq.get(0));
    }

}
