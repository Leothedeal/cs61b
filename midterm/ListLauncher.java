package midterm;
/*
* @author Leo
* @Date 2020.12.22
* @Description the interface that can implements SLList & IntList
* so that in future coding I don't need to re-define this two types
* anymore,just use the inheritance;*/
public interface ListLauncher {
    class IntList {
        int first;
        IntList rest;

        public IntList(int f, IntList r) {
            this.first = f;
            this.rest = r;
        }
    }

    class SLList {
        class IntNode {
            int item;
            IntNode next;

            public IntNode(int i,IntNode n) {
                this.item = i;
                this.next=n;
            }
        }
        IntNode first;
        public SLList(int x){
            first=new IntNode(x,null);
        }
        int size;
        public void addFirst(int x){
            first=new IntNode(x,first);
            size+=1;
        }
        public void addLast(int x){
            IntNode p=first;
            while(p.next!=null){
                p=p.next;
            }
            p.next=new IntNode(x,null);
            size+=1;
        }
        public void removeFirst(){
            first=first.next;
            size-=1;
        }
        public void removeLast(){
            IntNode p=first;
            while(p.next.next!=null){
                p=p.next;
            }
            p.next=null;
            size-=1;
        }
        public int getFirst(){
            return first.item;
        }
        public int size(){
            return size;
        }
        public void print(){
            IntNode p=first;
            System.out.println("The list you want to print is ");
            while(p!=null){
                System.out.print(p.item+" ");
                p=p.next;
            }
        }
    }
    }

