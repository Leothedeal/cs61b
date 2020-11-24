public class ArrayReplicate {
    public static void replicate(int[] arr) {
        int sum=0;
        int a=0;
        for(int i=0;i<arr.length;i++)
            sum+=arr[i];
        int[] shuzu = new int[sum];
        for (int index = 0; index < arr.length; index++){
            for(int count=0;count<arr[index];count++)
            {shuzu[a]=arr[index];
            a++;}
            }
        for (int i = 0; i < shuzu.length; i++) {
            System.out.print(shuzu[i]);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int[] A = {1,2,3};
        replicate(A);
        System.out.print("This is A： ");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
            System.out.print(" ");
        }
    }
}
