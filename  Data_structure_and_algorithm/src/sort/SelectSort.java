package sort;

import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr= {9,6,7,5,2,1};
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void selectSort(int arr1[]){
        System.out.println("排序前"+new Date().getTime());
        for (int i = 0; i <arr1.length-1 ; i++) {
            for (int j = i+1; j <arr1.length ; j++) {
                if (arr1[i]>arr1[j]){
                    int temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }
        System.out.println("排序后"+new Date().getTime());

    }
}
