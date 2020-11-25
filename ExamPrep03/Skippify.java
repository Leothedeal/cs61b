public class Skippify {
    public class IntList {
 public int first;
 public IntList rest;




 public void skippify() {
             IntList p = this;
             int n = 1;
             while (p != null) {
                 IntList next = p.rest;
                 for (int i = 0; i < n; i += 1) {
                     if (next == null) {
                         break;
                         }
                     next = next.rest;
                     }
                 p.rest = next;
                 p = p.rest;
                 n++;
                 }
             }

         }
}
//自己这个没有写出来，每次一碰到IntNode或者IntList的题目就头痛，关键是没有抓住
//有些参数。像这道题目，现在来复盘一下就是要跳的次数n，每经过一个循环之后都应该自增
//当前的指针p，注意p.next应该怎么用，可以直接使当前这个元素的rest指向我们想让他指向的
//地方。从而达到改变整个IntList的目的。另外就是p也需要移动，需要配合next一起来动，知道
//最后到达null，整个IntList的遍历才算结束。
