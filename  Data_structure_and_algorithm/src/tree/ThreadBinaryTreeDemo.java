package tree;

public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode1 root = new HeroNode1(1,"tom");
        HeroNode1 node2 = new HeroNode1(3,"jack");
        HeroNode1 node3 = new HeroNode1(6,"smith");
        HeroNode1 node4 = new HeroNode1(8,"mary");
        HeroNode1 node5 = new HeroNode1(10,"king");
        HeroNode1 node6 = new HeroNode1(14,"dim");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadBinaryTree th = new ThreadBinaryTree(root);
//        th.threadedNodes();
//        HeroNode1 leftNode = node5.getLeft();
//        System.out.println("十号节点的前驱节点"+leftNode);
//        System.out.println("十号节点的后继节点"+node5.getRight());
//        System.out.println("使用线索化得方式遍历二叉树");
//        th.threadedList();
        th.postThreadedNodes(root);
        th.postThreadList();
//        th.preThreadedNodes();
//        th.threadedList();
    }
}


class ThreadBinaryTree{
    private HeroNode1 root;
    private HeroNode1 pre = null;

    public ThreadBinaryTree(HeroNode1 root) {
        this.root = root;
    }

    public void threadedNodes(){
        threadedNodes(root);
    }
    //中序线索化
    public void threadedNodes(HeroNode1 node){
        if(node==null){
            return;
        }
        threadedNodes(node.getLeft());
        if(node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if(pre!=null&&node.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        threadedNodes(node.getRight());

    }
    public void preThreadedNodes(){
        preThreadedNodes(root);
    }
    //前序线索化
    public void preThreadedNodes(HeroNode1 node){
        if (node==null){
            return;
        }
        HeroNode1 tempLeft = node.getLeft();
        HeroNode1 tempRight = node.getRight();
            node.setLeft(pre);
            node.setLeftType(1);

        if (pre!=null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        preThreadedNodes(tempLeft);
        preThreadedNodes(tempRight);
    }

    //后序线索化
    public void postThreadedNodes(HeroNode1 node){
        if (node==null){
            return;
        }
        postThreadedNodes(node.getLeft());
        postThreadedNodes(node.getRight());
        if (node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre!=null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

    }

    public void threadedList(){
        HeroNode1 node = root;
        while(node!=null){
            while(node.getLeftType()!=1){
                node = node.getLeft();
            }
            System.out.println(node);
            while(node.getRightType()==1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }
    public void postThreadList(){
        HeroNode1 node = root;
        if(node!=null){
            while(node.getLeftType()!=1){
                node = node.getLeft();
            }
            System.out.println(node);
            while(node.getRightType()==1){
                node = node.getRight();
                System.out.println(node);
            }
//            node = node.getRight();
        }
    }

    public boolean delete(int no){
        boolean flag = false;
        if (root==null){
            System.out.println("树为空,不能删除");
            return false;
        }
        if(root.getNo()==no){
            if(root.getLeft()!=null){
                HeroNode1 temp = root.getLeft();
                while (temp.getRight()!=null){
                    temp = temp.getRight();
                }
                temp.setRight(root.getRight());
                root = root.getLeft();
            }else if(root.getLeft()==null){
                root = root.getRight();
            }
            flag = true;
        }else{
            flag = root.delete(no);
        }

        return flag;
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
    public HeroNode1 preOderSearch(int no){
        if (root!=null){
            return this.root.preOderSearch(no);
        }else{
            System.out.println("树为空");
            return null;
        }
    }
    public HeroNode1 infixOderSearch(int no){
        if (root!=null){
            return this.root.infixOderSearch(no);
        }else{
            System.out.println("树为空");
            return null;
        }
    }
    public HeroNode1 postOderSearch(int no){
        if (root!=null){
            return this.root.postSearch(no);
        }else{
            System.out.println("树为空");
            return null;
        }
    }
}

class HeroNode1{
    private int no;
    private String name;
    private HeroNode1 left;
    private HeroNode1 right;
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }
    //如果leftType==0表示指向左子树,如果为1表示指向前驱结
    //如果rightType==0表示指向右子树,如果1则表示指向后继节点

    public HeroNode1(int no, String name) {
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

    public HeroNode1 getLeft() {
        return left;
    }

    public void setLeft(HeroNode1 left) {
        this.left = left;
    }

    public HeroNode1 getRight() {
        return right;
    }

    public void setRight(HeroNode1 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //递归 删除节点
    public boolean delete(int no) {
        boolean flag = false;
        if (this.left != null && this.right != null) {
            if (this.left.no == no) {
                if (this.left.left != null) {
                    HeroNode1 h = this.left.left;
                    while (h.getRight() != null) {
                        h = h.right;
                    }
                    h.right = this.left.getRight();
                    this.left = this.left.left;
                    flag = true;
                } else if (this.left.left == null) {
                    this.left = this.left.right;
                    return true;
                }
            } else if (this.right.no == no) {
                if (this.right.right != null) {
                    HeroNode1 h = this.right.right;
                    while (h.getLeft() != null) {
                        h = h.left;
                    }
                    h.left = this.right.getLeft();
                    this.right = this.right.right;
                    flag = true;
                } else if (this.right.right == null) {
                    this.right = this.right.left;
                    return true;
                }
            } else {
                flag = this.left.delete(no);
                if (!flag) {
                    flag = this.right.delete(no);
                }
            }
        } else if (this.left != null) {
            if (this.left.no == no) {
                if (this.left.left != null) {
                    HeroNode1 h = this.left.left;
                    while (h.getRight() != null) {
                        h = h.right;
                    }
                    h.right = this.getRight();
                    this.left = this.left.left;
                    flag = true;
                } else {
                    flag = this.left.delete(no);
                    if (!flag) {
                        flag = this.right.delete(no);
                    }
                }
            }
            return flag;
        }
        return flag;
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
    public HeroNode1 preOderSearch(int no){
        HeroNode1 resNode = null;
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


    public HeroNode1 infixOderSearch(int no){
        HeroNode1 resNode = null;
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

    public HeroNode1 postSearch(int no){
        HeroNode1 resNode = null;
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
