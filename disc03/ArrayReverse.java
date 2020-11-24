public class ArrayReverse {
    public static void reverse(int[] arr) {
        int[] shuzu = new int[arr.length];
        for (int index = 0; index < arr.length; index++)
            shuzu[arr.length - index - 1] = arr[index];
        arr=shuzu;
        for (int i = 0; i < shuzu.length; i++) {
            System.out.print(shuzu[i]);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reverse(A);
        System.out.print("This is A： ");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
            System.out.print(" ");
        }
    }
}
