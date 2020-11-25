public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    /**
     * 10 * Given a sorted linked list of items - remove duplicates.
     * 11 * For example given 1 -> 2 -> 2 -> 2 -> 3,
     * 12 * Mutate it to become 1 -> 2 -> 3 (destructively)
     * 13
     */
    public static void removeDuplicates(IntList p) {
        if (p == null) {
            return;
        }

        IntList current = p.rest;

        IntList previous = p;

        while (current.rest != null) {

            if (current.first == previous.first) {// I am almost correct,the original code of mine
                previous.rest = current.rest;//is current==previous;

            } else {
                previous = previous.rest;
            }
            current = current.rest;
        }
    }


    public static  void main(String[] args) {

        IntList L=new IntList(1,null);
        L.rest=new IntList(2,null);
        L.rest.rest=new IntList(2,null);
        L.rest.rest.rest=new IntList(2,null);
        L.rest.rest.rest.rest=new IntList(3,null);
        removeDuplicates(L);

    }
}
//proudly produced by Leo,I haven't figure out how to finish this
//at first,but after reviewing the answer of task 2,I know how to
//use p.rest to skip those items which I don't need,and I finally
//write these code by myself.


