package hw0;

public class Print {
	public static void main(String[] args) {
	int x=5;      /*five rows*/
	int m;          /*counter*/
	int i=1;       /*counter from 1-5*/
	while(i<=x)    /*loop 1,scan the 5 row*/
	{
		for(m=1;m<=i;m++)    /*loop 2,focus on every row*/
	System.out.print("*");  /*print the target*/ 
	System.out.println();    /*change the line*/
 i ++;}                      /*self-increase the counter i and go to next loop*/
}
}
/*总结：一开始的思路并没有问题，困扰良久的是无论怎么处理结果都是直接打印五个星号，
 * 并不能打印出三角形，
* 后来仔细观察了一下，发现是花括号的问题，
* 越来越能理解Josh Hug在hw0里讲的Curly braces are very important in Java
 * */