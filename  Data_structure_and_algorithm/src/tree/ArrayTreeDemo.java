package tree;

public class ArrayTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree at = new ArrayBinaryTree(arr);
        at.preOder();
        System.out.println();
        at.infixOder();

    }
}
    class ArrayBinaryTree{
        private int[] arr;

        public ArrayBinaryTree(int[] arr) {
            this.arr = arr;
        }
        public void preOder(){
            this.preOder(0);
        }

        public void preOder(int index){
            if(arr.length == 0 || arr == null){
                System.out.println("数组为空,无法遍历");
            }
            System.out.println(arr[index]);
            if((2*index+1)<arr.length){
                preOder(2*index+1);
            }
            if((2*index+2)<arr.length){
                preOder(2*index+2);
            }
        }
        public void infixOder(){
            infixOder(0);
        }
        public void infixOder(int index){
            if(arr.length == 0 || arr == null){
                System.out.println("数组为空,无法遍历");
            }
            if((2*index+1)<arr.length){
                infixOder(2*index+1);
            }
            System.out.println(arr[index]);
            if((2*index+2)<arr.length){
                infixOder(2*index+2);
            }
        }
    }

