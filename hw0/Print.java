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
/*�ܽ᣺һ��ʼ��˼·��û�����⣬�������õ���������ô����������ֱ�Ӵ�ӡ����Ǻţ�
 * �����ܴ�ӡ�������Σ�
* ������ϸ�۲���һ�£������ǻ����ŵ����⣬
* Խ��Խ�����Josh Hug��hw0�ｲ��Curly braces are very important in Java
 * */