public class ArrItera {
    public static int[] insert(int[] arr, int item, int position) {
        int[] shuzu = new int[arr.length + 1];
        if (position >= arr.length) {
            position = arr.length;
            shuzu[arr.length] = item;
        }
        for (int index = 0; index < arr.length; index++)     //一定注意循环条件，刚开始就是因为循环条件搞错了，一直显示爆栈
        {
            if (index < position)                                  //注意是要小于arr.length而不是shuzu.length，因为arr始终都比shuzu
                shuzu[index] = arr[index];                       //的长度小1，所以达到循环条件时，shuzu[index+1]刚好是shuzu中最后的元素
            if (index >= position) {
                shuzu[index + 1] = arr[index];
            }
        }
        shuzu[position] = item;
        for (int i = 0; i < shuzu.length; i++) {
            System.out.print(shuzu[i]);
            System.out.print(" ");
        }
        return shuzu;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 8, 9, 10};
        insert(A, 5, 5);
        System.out.print("This is A： ");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
            System.out.print(" ");
        }
    }
}
