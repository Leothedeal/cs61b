package hw0;

public class Exercise2 { 
	public static int max(int[] m) {
		int max=m[0];
		for(int i=1;i<m.length;i++) {
				if (m[i]>max)
				max=m[i];
			}
		return max;
	}


public static void main(String[] args) {
   int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
   System.out.print(max(numbers));
}
}
/*刚开始想的太复杂，想到了排序那种，实际上只要将m[1]之后的每一个数
 * 都与其比较，即可得到大小关系。
 * ps:if 后面也可以不加else直接实现*/
