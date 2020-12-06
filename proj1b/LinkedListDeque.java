public class LinkedListDeque<T> implements Deque<T> {
    private class TNode {
        private T item;
        private TNode next;
        private TNode prev;

        TNode(TNode p, T i, TNode n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private TNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new TNode(null, (T) "null", null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    @Override  public T getFirst() {
        return get(0);
    }
    @Override public T getLast() {
        return get(size() - 1);
    }

    public void addFirst(T item) {
        sentinel.next = new TNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new TNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        TNode p = sentinel;
        while (p.next != sentinel) { //错误在这里，由于是双向链表，所以
            // 不存在null，到达终点意味着到了
            // sentinel  original:p.next!=null;
            System.out.print(p.next.item + " "); //应该是p.next.item  original:p.next
            p = p.next;
        }
        System.out.println("oops!the deque contains 0 items");
    }

    public T removeFirst() { //remove之后返回的肯定也要是一个DLList，我忽视了这一点
        if (size == 0) {
            return null;
        }
        T rid = sentinel.next.item;
        size -= 1;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return rid;
    }

    public T removeLast() {   //because the type is not void,so you must return a value
        if (size == 0) {
            return null;
        }
        size -= 1;
        T rid = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return rid;
    }

    public T get(int index) {
        TNode p = sentinel;
        int count = 0;
        if (p.next != null) {
            while (p.next != sentinel) {
                 if (count < index) {
                count++;
                 }
                p = p.next;
                      if (count == index){   //just by myself,but should take care of it's p.next!=sentinel rather than null
                       return p.item;}    //biggest difference between DLList and SLList
            }
        }
        return null;
    }
    private T getRecursiveHelper(int index, TNode ptr, int count) {
        if(index == count){
            return ptr.item;
        }
        return getRecursiveHelper(index, ptr.next, count++);
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        TNode ptr = sentinel.next;
        int count = 0;
        return getRecursiveHelper(index, ptr, count);
    }

}





