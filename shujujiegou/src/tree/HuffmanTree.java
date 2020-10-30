package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13,7,8,3,29,6,1};
        Node head = createHuffmanTree(arr);
        HuffmanTree hf = new HuffmanTree();
        hf.preOder(head);
    }

    public static Node createHuffmanTree(int[] arr){
        List<Node> nodes = new ArrayList<>();
        for(int value:arr){
            nodes.add(new Node(value));
        }
        while(nodes.size()>1){
            Collections.sort(nodes);
            //1.取出权值最小的两颗二叉树
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.value+right.value);
            parent.left = left;
            parent.right = right;
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    public void preOder(Node root){
        if (root!=null){
            root.preOder();
        }
    }
}

class Node implements Comparable<Node>{
    int value;//节点权值
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }

    public void preOder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOder();
        }
        if (this.right!=null){
            this.right.preOder();
        }
    }
}
