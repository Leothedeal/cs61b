package midterm;

public interface Stack<Item> {
    void push(Item x); // places an item on “top” of the stack
    Item pop(); // removes and returns “top” item of the stack
    int size(); // returns the number of items on the stack
/*
* @author Loe
* @Date 2020.12.23
* @Description:another way to implements the purge*/    public
        default  void purge(Item x){ //to eliminate x in the stack
        ArrayStack<Item> a=new ArrayStack<>();
        int s=this.size();
       for(int i=0;i<s;i++){  //while here the answer uses while(this.size()>0),frankly speaking,it's more concise
           Item pop=this.pop();
           if(!pop.equals(x)){
               a.push(pop);
           }
       }
       int s1=a.size();
       for(int i=0;i<s1;i++){
           this.push(a.pop());
       }
    }
}
// the recursive version of the answer is pretty beautiful