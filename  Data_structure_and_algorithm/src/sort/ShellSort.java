package sort;

import java.util.Arrays;

public class ShellSort {
    int arr[] = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(shellSort.arr);
        System.out.println(Arrays.toString(shellSort.arr));
    }

    public void shellSort(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j+gap]) {
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }

                }
            }
//            System.out.println("排序过程"+Arrays.toString(arr));
        }
    }


    public void shellSort2(int[] arr){
        int temp = 0;
        for (int gap = arr.length/2; gap > 0 ; gap/=2) {
            for (int i = gap; i <arr.length ; i++) {
                temp = arr[i];
                int j = i;
                while(arr[j]<arr[j-gap]&&j-gap>=0){
                    arr[j] = arr[j-gap];
                    j-=gap;
                }
                arr[j] = temp;
            }
        }

    }
}
