package search;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,8,10,89,1000,1000,1234};
//        int flag = 0;
//        flag = binarySearch(arr,5,0,arr.length-1);
//        if (flag==-1){
//            System.out.println("找不到数据");
//        }else{
//            System.out.println("数据为第"+(flag+1)+"个");
//        }
        ArrayList<Integer> list = binarySearch2(arr,1000,0,arr.length-1);
        if (list.isEmpty()){
            System.out.println("找不到数据");
        }else{
            for (int item:
                 list) {
                System.out.println(item+",");
            }
        }
    }
    public static int binarySearch(int[] arr,int num,int left,int right){
        int mid = (left+right)/2;
        if (left>right){
            return -1;
        }
        if (num==arr[mid]){
            return mid;
        } else if (num<arr[mid]){
            mid = binarySearch(arr,num,left,mid-1);
            return mid;
        } else if (num>arr[mid]){
            mid = binarySearch(arr,num,mid+1,right);
            return mid;
        }
        return mid;
    }

    public static ArrayList<Integer> binarySearch2(int[] arr, int num, int left, int right){
        int mid = (left+right)/2;
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (left>right){
            return new ArrayList<Integer>();
        }
        if (num==arr[mid]){
            arrayList.add(mid);
            int temp = mid-1;
            while(true){
                if (temp<0||arr[temp]!=num){
                    break;
                }
                arrayList.add(temp);
                temp--;
            }
            temp = mid+1;
            while(true){
                if (temp>arr.length-1||arr[temp]!=num){
                    break;
                }
                arrayList.add(temp);
                temp++;
            }
            return arrayList;
        } else if (num<arr[mid]){
            return binarySearch2(arr,num,left,mid-1);
        } else if (num>arr[mid]){
            return binarySearch2(arr,num,mid+1,right);
        }
        return arrayList;
    }
}
