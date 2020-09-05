package sort;

import java.util.Arrays;

public class InsetSort {
    public static void main(String[] args) {
        int[] arr = {92,54,32,80,21,1,40};
        InsetSort insetSort = new InsetSort();
        insetSort.insertSort(arr);
        insetSort.insertSort2(arr);
    }

    public void insertSort(int[] arr) {
        int index = 0;
        int temp = 0;
        for (int i = index + 1; i < arr.length ; i++) {
            i = index + 1;
            if (index == 0 && arr[index] > arr[i]) {
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                index++;
            } else if (index == 0 && arr[index] < arr[i]) {
                index++;
            }else if(arr[index]<arr[i]){
                arr[index+1] = arr[i];
                index++;
            } else {
                int tempindex = index;
                while (tempindex > 0) {
                    if (arr[tempindex] > arr[i] && arr[tempindex - 1] < arr[i]) {
                        temp = arr[i];
                        int tempi = i;
                        while (tempindex < i) {
                            arr[i] = arr[i - 1];
                            i--;
                        }
                        arr[tempindex] = temp;

                        arr[i] = arr[tempindex];
                        i=tempi;
                        tempindex++;
                        index++;
                        break;
                    } else {
                        tempindex--;
                    }
                }
                if (tempindex == 0) {
                    tempindex = i;
                    temp = arr[i];
                    while (tempindex > 0) {
                        arr[tempindex] = arr[tempindex - 1];
                        tempindex--;
                    }
                    arr[0] = temp;
                    index++;
                }
            }
        }

//        for (int j = 0; j < arr.length; j++) {
//            System.out.println(arr[j]);
//        }
    }

    public void insertSort2(int[] arr){
        int insertValue = 0;
        int insertIndex=0;
        for (int i = 1; i <arr.length ; i++) {
            insertIndex = i-1;
            insertValue = arr[i];
            while (insertIndex>=0&&arr[insertIndex]>arr[i]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertValue;
        }
//        System.out.println(Arrays.toString(arr));
    }

}
