package stack;


public class LinkedStackMode {
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push(5);
        stack.push(3);
        stack.pop();
        stack.list();

    }
}
class LinkedStack{
    int top=-1;
    Demo head = new Demo(-1);

    public void push(int num){
        Demo newDemo = new Demo(num);
        Demo temp = head;
        if (top==-1){
            temp=newDemo;
            head = temp;
            top++;
            return;
        }
        newDemo.next = temp;
        head = newDemo;
        top++;
    }

    public void list() {
        Demo temp = head;
        if ((temp) != null) {
            do {
                System.out.println("数字："+temp.num);
            } while ((temp = temp.next) != null);
        }
    }

    public void pop() {
        Demo temp = head;
        if (top == -1) {
            System.out.println("栈内无元素");
            return;
        }else if (top==0){
            head=new Demo(-1);
            top--;
        }
            temp = temp.next;
            head = temp;
            top--;

    }
    }
class Demo{
    int num;
    Demo next;

    public Demo() {
    }

    public Demo(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "num=" + num
                ;
    }
}
