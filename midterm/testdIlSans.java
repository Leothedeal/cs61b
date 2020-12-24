package midterm;

public class testdIlSans implements ListLauncher{
    public static IntList dilsans(IntList x,int y){
        if(x==null){
            return null;
        }
        x.rest=dilsans(x.rest,y);
        if(x.first==y){
            return x.rest;
        }
        return x;
    }
    public static void main(String[] args){
        IntList l=new IntList(1,null);
        l.rest=new IntList(2,null);
        l.rest.rest=new IntList(3,null);
        dilsans(l,2);

    }
}
