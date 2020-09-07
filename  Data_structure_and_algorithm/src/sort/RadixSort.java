package sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53,3,542,748,14,214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int arr[]){
        int max = arr[1];
        for (int i = 1;i<arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        int maxLength = (max+"").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        for (int k = 0,multiple = 1;k<maxLength;k++,multiple*=10){
            for (int i = 0; i <arr.length ; i++) {
                int digitOfElement = arr[i]/multiple%10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                bucketElementCounts[digitOfElement]++;
            }
            int count = 0;
            for (int i = 0;i<bucketElementCounts.length;i++){
                if (bucketElementCounts[i]!=0){
                    for (int j = 0; j <bucketElementCounts[i] ; j++) {
                        arr[count++] = bucket[i][j];
                    }
                }
                bucketElementCounts[i] = 0;
            }
        }
    }
}
