package tree;

public class BinaryTreeDemp {
    public static void main(String[] args) {
        //前序遍历
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2,"吴用");
        HeroNode node3 = new HeroNode(3,"卢俊义");
        HeroNode node4 = new HeroNode(4,"林冲");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        BinaryTree binaryTree = new BinaryTree(root);
//        System.out.println("前序遍历");
//        binaryTree.preOder();
//        System.out.println("中序");
//        binaryTree.infixOder();
//        System.out.println("后续");
//        binaryTree.postOder();
        System.out.println("前序查找");
        HeroNode resNode = binaryTree.preOderSearch(1);
        if (resNode!=null){
            System.out.println(resNode);
        }else{
            System.out.println("没有这个元素");
        }
    }

}

class BinaryTree{
    private HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }
    public void preOder(){
        if (this.root!=null){
            this.root.preOder();
        }else{
            System.out.println("二叉树为空");
        }
    }
    public void infixOder(){
        if (this.root!=null){
            this.root.infixOder();
        }else{
            System.out.println("二叉树为空");
        }
    }

    public void postOder(){
        if (this.root!=null){
            this.root.postOder();
        }else{
            System.out.println("二叉树为空");
        }
    }
    public HeroNode preOderSearch(int no){
        if (root!=null){
            return this.root.preOderSearch(no);
        }else{
            System.out.println("树为空");
            return null;
        }
    }
    public HeroNode infixOderSearch(int no){
        if (root!=null){
            return this.root.infixOderSearch(no);
        }else{
            System.out.println("树为空");
            return null;
        }
    }
    public HeroNode postOderSearch(int no){
        if (root!=null){
            return this.root.postSearch(no);
        }else{
            System.out.println("树为空");
            return null;
        }
    }
}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    public void preOder(){
        System.out.println(this);
        //想左递归
        if (this.left!=null){
            this.left.preOder();
        }
        if (this.right!=null){
            this.right.preOder();
        }
    }

    public void infixOder(){
        if (this.left!=null){
            this.left.infixOder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOder();
        }
    }

    public void postOder(){
        if (this.left!=null){
            this.left.postOder();
        }
        if (this.right!=null){
            this.right.postOder();
        }
        System.out.println(this);
    }
    public HeroNode preOderSearch(int no){
        HeroNode resNode = null;
        if (this.no == no){
            return this;
        }
        if (this.left!=null){
            resNode = this.left.preOderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.right!=null){
            resNode = this.right.preOderSearch(no);
        }
        return resNode;
    }


    public HeroNode infixOderSearch(int no){
        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.infixOderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.no==no){
            return this;
        }
        if (this.right!=null){
            resNode = this.right.infixOderSearch(no);
        }
        return resNode;
    }

    public HeroNode postSearch(int no){
        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.postSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.right!=null){
            resNode = this.right.postSearch(no);
        }
        if (this.no==no){
            return this;
        }
        return resNode;
    }

}