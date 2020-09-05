package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class PoalndNotation {
    public static void main(String[] args) {
        String suffixExpression="30 4 + 5 * 6 -";
        String inFixExpression ="1+(2+3)*4-5";
        List<String> s = PoalndNotation.toInfixExpressionList(inFixExpression);
        System.out.print("中缀表达式：");
        System.out.println(s);
        System.out.print("后缀表达式：");
        System.out.println(PoalndNotation.parseSuffixExpression(s));
        System.out.println(PoalndNotation.calculate(PoalndNotation.parseSuffixExpression(s)));


//        List<String> list = PoalndNotation.getListString(suffixExpression);
//        int res = calculate(list);
//        System.out.println("答案是"+res);
    }

    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele:split){
            list.add(ele);
        }
        return list;
    }
    public static int calculate(List<String> ls){
        Stack<String> stack = new Stack<>();
        for (String item:ls){
            if (item.matches("\\d+")){
                stack.push(item);
            }else{
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res=num1+num2;
                }else if(item.equals("-")){
                    res =  num2-num1;
                }else if(item.equals("*")){
                    res = num2*num1;
                }else if(item.equals("/")){
                    res = num2/num1;
                }
                else{
                    throw new RuntimeException("运算符有问题");
                }
                stack.push(""+res);

            }

        }
        return Integer.parseInt(stack.pop());
    }

    //将中缀转成后缀
    public static List<String> toInfixExpressionList(String s){
        List<String> list = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        do {
            //如果c非数字，需要加入到ls
            if ((c=s.charAt(i))<48||((c=s.charAt(i))>57)){
                list.add(""+c);
                i++;
            }else{
                str="";
                while((i<s.length())&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str+=c;
                    i++;
                }
                list.add(str);
            }
        }while(i<s.length());
        return list;
    }

    public static List<String> parseSuffixExpression(List<String> inFixExpressionList){
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();
        char ch;
        for (String item:inFixExpressionList){
            //如果是一个数就加入s2
            if (item.matches("\\d+")){
                s2.add(item);
            }else if ((item.charAt(0))=='('||s1.empty()){
                s1.push(item);
            }else if (item.charAt(0)==')'){
                while(true){
                      ch=s1.pop().charAt(0);
                      if (ch!='('){
                          s2.add(String.valueOf(ch));
                      }else{
                          break;
                      }
                }//1+(2+3)*4-5
            }else if (PoalndNotation.priority(item.charAt(0))>PoalndNotation.priority(s1.peek().charAt(0))){
                s1.push(item);
            }else{
                if (s1.size()==0){
                    s1.push(item);
                }
                //s2.add(s1.pop());
                while(s1.size()!=0&&PoalndNotation.priority(s1.peek().charAt(0))>=PoalndNotation.priority(item.charAt(0))){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (!s1.empty()){
            s2.add(s1.pop());
        }
        return s2;
    }

    public static int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        }else {
            return -1;
        }
    }

}
