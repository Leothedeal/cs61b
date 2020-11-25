public class Flatten {
    public static int[] flatten(int[][] x) {
         int totalLength = 0;

         for (int i=0;i<x.length;i++) {
            for(int index=0;index<x[i].length;index++) //it can also be replaced by one for loop:
             totalLength++;                            //totalLength+=x[i].length;
             }

         int[] a = new int[totalLength];
         int aIndex = 0;

         for (int count=0;count<x.length;count++) {
            for(int m=0;m<x[count].length;m++)
            {
                a[aIndex]=x[count][m];
                aIndex++;
            }
             }

         return a;
         }
         public static void main(String[] args){
             int[][] input = {{1,2,3,},{},{7,8}};
             flatten(input);
             for(int i=0;i<input.length;i++){
                 System.out.print(input[i]);
             }

         }
}
//proudly produced by Leo