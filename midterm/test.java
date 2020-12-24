package midterm;
import java.util.List;

public class test implements ListLauncher{
    public static void main(String[] args){
        System.out.println(19/10); // to test java's rounds down
        SLList s=new SLList(5);
        s.addFirst(1);
        s.addFirst(2);
        s.addFirst(3);
        s.addLast(10);
        s.removeFirst();
        s.removeLast();
        s.print();
        int num=s.getFirst();
        System.out.println("the first number of SLList is "+num);
    }
}
