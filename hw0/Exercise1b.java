package hw0;

public class Exercise1b {
	public static void drawTriangle(int N) {     /*the method don't need to return
	                                              a value but print some stars*/
		int x=1;
		while(x<=N) {
			for(int i=1;i<=x;i++)
				System.out.print("*");
			System.out.println();
			x++;
		}
	}
public static void main(String[] args) {
	 drawTriangle(100);    /*you can directly call the method in java*/
}
}
