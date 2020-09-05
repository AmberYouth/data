package array;

import java.io.*;

public class Sparse_array {
    public static void main(String[] args) {
        String[] elements=null;
        FileWriter writer = null;
        BufferedReader reader = null;
        int[][] array1 = new int[11][11];
        array1[1][2]=1;
        array1[2][3]=2;
        int count=0;
        for (int[] row:array1){
            for (int data:row){
                if (data!=0){
                    count++;
                }
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        int[][] sparse = new int[count+1][3];
        sparse[0][0]=array1.length;
        sparse[0][1]=array1[0].length;
        sparse[0][2]=count;
        int num=1;
        for (int i = 0;i<array1.length;i++){
            for (int j=0;j<array1[0].length;j++){
                if (array1[i][j]!=0){
                    sparse[num][0]=i;
                    sparse[num][1]=j;
                    sparse[num++][2]=array1[i][j];
                }
            }
        }

        try {
            writer = new FileWriter("I:\\数据结构练习\\原数组.txt");
            String shuzu = "";
            for (int[] row:sparse){
                for (int data:row){

                    shuzu+=data+"\t";
                }
                shuzu+="\n";
            }


            writer.write(shuzu);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        for (int[] row:sparse){
            for (int data:row){
                if (data!=0){
                    count++;
                }
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        int[][] array2 = new int[sparse[0][0]][sparse[0][1]];
        for (int i=1;i<sparse.length;i++){

                array2[sparse[i][0]][sparse[i][1]]=sparse[i][2];

        }
        for (int[] row:array2){
            for (int data:row){
                if (data!=0){
                    count++;
                }
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        System.out.println("=====================================================");


        try {
            int count2=0;
            reader = new BufferedReader( new FileReader("I:\\数据结构练习\\原数组.txt"));
            String line ="";

           while ((line=reader.readLine())!=null){
                count2++;
           }
            reader = new BufferedReader( new FileReader("I:\\数据结构练习\\原数组.txt"));
           int[][] sparse2 = new int[count2][3];
            int num2 = 0;
           while((line = reader.readLine())!=null){

               elements=line.split("\t");
               for (int i =0;i<elements.length;i++){
                   sparse2[num2][i] = Integer.valueOf(elements[i]);
               }
               num2++;
           }

            for (int[] row:sparse2){
                for (int data:row){
                    if (data!=0){
                        count++;
                    }
                    System.out.printf("%d\t",data);
                }
                System.out.println();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
