class Arrays {
    public static int[] insert(int[] arr, int item, int position) {
        int[] shuzu = new int[arr.length + 1];
        System.arraycopy(arr, 0, shuzu, 0, arr.length);
        System.arraycopy(arr, position, shuzu, position + 1, arr.length - position);
        shuzu[position] = item;
        for(int i=0;i<shuzu.length;i++) {
            System.out.print(shuzu[i]);
        System.out.print(" ");
        }
        return shuzu;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        insert(A, 5, 2);
        System.out.print("This is A： ");
    }
}
