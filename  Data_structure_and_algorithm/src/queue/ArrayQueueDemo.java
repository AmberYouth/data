package queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key=' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

    }
}
class ArrayQueue{
    private int maxSize;//数组的最大容量
    private int front;//队列头指针
    private int rear;//队列尾部
    private int[] arr;


    public ArrayQueue(int arrMaxSize) {
       maxSize = arrMaxSize;
       arr = new int[maxSize];
       front=-1;//指向队列头部前一个位置
       rear=-1;//指向队列尾部，指向列尾的数据
    }
    public boolean isFull(){
        return rear==maxSize-1;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public void addQueue(int n){
        if (rear==maxSize-1){
            System.out.println("数据已满，无法加入");
        }else{
            arr[rear++]=n;
        }
    }
    public int getQueue(){
        if (isEmpty()){
            //抛个异常
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空，无数据");
        }else{
            for (int i = 0; i <arr.length ; i++) {
                System.out.println("arr["+i+"+]="+arr[i]);
            }
        }

    }
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，无法取数据");
        }
        return arr[front+1];
    }
}


