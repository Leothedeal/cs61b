package midterm;

/*
* @author  Leo
* @Date 2020.12.22
* @Description: after the midterm test,
* I wrote this program to emulate the process of task 2*/
public class testG implements ListLauncher{
    public static void g(IntList x){
        if(x==null){
            return;
        }
        g(x.rest);
        x.rest=x;
    }
    public static void main(String[] args){
        IntList L=new IntList(3,null);
        L.rest=new IntList(4,null);
        L.rest.rest=new IntList(5,null);
        g(L);
    }
}