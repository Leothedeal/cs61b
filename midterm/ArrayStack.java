package midterm;

public class ArrayStack<Item> implements Stack<Item> {
    private Item[] items;
    private int size;
    public ArrayStack() { // initial array size should be 8
        items = (Item[]) new Object[8];
        size = 0;
    }
    private void resize(int capacity) {
        Item[] newItems = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }
    public void push(Item x) {
        if (usage_ratio() == 1) { resize(size * 2); }
        items[size] = x;
        size += 1;
    }
    public Item pop() {
        if (size == 0) { return null; }
        if (usage_ratio() < 0.25 && items.length > 8) {resize(items.length / 2);}
        size = size - 1;
        Item returnItem = items[size];
        items[size] = null;
        return returnItem;
    }
    public int size() { return size; }
    private double usage_ratio() { return ((double) size()) / items.length; }
    public static void main(String[] args){   //test if the default method works
        ArrayStack<Integer> arr=new ArrayStack<>();
        arr.push(1);
        arr.push(2);
        arr.push(3);
        arr.push(2);
        arr.push(2);
        arr.push(2);
        arr.purge(2);
    }
}