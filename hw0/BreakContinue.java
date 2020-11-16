package hw0;

public class BreakContinue {
	public static void windowPosSum(int[] a, int n) {
	    /** your code here */ 
		int i=0;int count=0;
		for(;i<a.length;i++) {
				if (a[i]>0)
			for(count=i+1;count<=i+n;count++)
				{if(count>=a.length)
					break;
				a[i]+=a[count];
				}
		continue;}
	  }

	  public static void main(String[] args) {
	    int[] a = {1, 2, -3, 4, 5, 4};
	    int n = 3;
	    windowPosSum(a, n);

	    // Should print 4, 8, -3, 13, 9, 4
	    System.out.println(java.util.Arrays.toString(a));
	  }
}
/*前面三个数是可以想出来的，后面的是瞎搞搞出来的*/
