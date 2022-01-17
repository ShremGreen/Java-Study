package Stack.InversePolishCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
完整逆波兰计算器：
1.生成逆波兰表达式（中缀表达式转后缀表达式）
    1.将中缀表达式写入List
    2.需要两个栈，其一存储运算符（临时），其二存储表达式
        1.从左到右扫描List，数字和左括号直接入栈；
        右括号，依次弹出运算符并入栈，直到第一个左括号；（括号需消除）
        比较运算符优先级，
            若当前运算符比栈顶原算法优先级高，则直接压入
            若当前运算符比栈顶原算法优先级低，则将栈顶运算符弹出，并压入表达式栈，进入下次大循环
        2.将剩余运算符依次转入表达式栈

2.计算逆波兰表达式结果
    将存有后缀表达式的list写入Stack。
    从左往右扫描，遇到数字直接入栈；
    遇到运算符，弹出栈顶两位元素，进行"次顶 运算符 栈顶"的运算，将结果压入栈顶
    重复以上，直到算完

*/
class PolishNotationTest {
    public static void main(String[] args) {
        //后缀表达式
        //String suffixExpression = "3 4 + 5 * 6 - ";
        InversePolishCalculate polish = new InversePolishCalculate();
        //List list = polish.getListString(suffixExpression);
        //int result = polish.calculate(list);
        //System.out.println(suffixExpression + "= " + result);

        String expression = "((17+34)/3+6)*4";
        List<String> infixExpression = polish.toInfixExpressionList(expression);
        System.out.println(infixExpression);//[(, (, 17, +, 34, ), /, 3, +, 6, ), *, 4]
        try {
            List<String> suffixExpression = polish.getSuffixExpression(infixExpression);
            System.out.println(suffixExpression);//[17, 34, +, 3, /, 6, +, 4, *]
            int result = polish.calculate(suffixExpression);
            System.out.println(result);//92
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class InversePolishCalculate {
    //将中缀表达式转为List
    public List<String> toInfixExpressionList(String s) {
        List<String> list = new ArrayList();
        String str;
        for(int i = 0; i < s.length();) {
            if(s.charAt(i) < 48 || s.charAt(i) > 57) {//非数字
                list.add(Character.toString(s.charAt(i)));
                i ++;
            }else {
                //考虑多位数
                str = "";
                while(i < s.length() && (s.charAt(i) >= 48 && s.charAt(i) <= 57)) {
                    str += s.charAt(i);
                    i ++;
                }
                list.add(str);
            }
        }
        return list;
    }

    //将中缀表达式list转为后缀表达式list
    public List<String> getSuffixExpression(List<String> list) {
        Stack<String> valueStack = new Stack<String>();//存放数字和符号
        Stack<String> tempStack = new Stack<String>();//存放运算符

        for(String ele : list) {
            if(ele.matches("\\d+")) {//数字直接入value栈
                valueStack.push(ele);
            }else if(ele.equals("(")) {//左括号直接入temp栈
                tempStack.push(ele);
            }else if(ele.equals(")")) {
                //遇到右括号，依次弹出tempStack中运算符直到遇到第一个左括号
                while(!tempStack.peek().equals("(")) {
                    valueStack.push(tempStack.pop());
                } tempStack.pop();//弹出括号
            }else {//判断运算符优先级并操作
                while(tempStack.size() != 0 && (operatorPriority(ele) <= operatorPriority(tempStack.peek()))) {
                    valueStack.push(tempStack.pop());
                } tempStack.push(ele);
            }
        }
        while(tempStack.size() != 0) {
            valueStack.push(tempStack.pop());
        }
        return valueStack;
    }

    //将逆波兰表达式放入List
    public List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //计算逆波兰表达式结果
    public int calculate(List<String> list) {
        Stack<String> stack = new Stack<String>();//通过栈存取和运算
        for(String ele : list) {
            if(ele.matches("\\d+")) {//判断是否为数（多位数）
                stack.push(ele);
            }else {
                int v1 = Integer.parseInt(stack.pop());
                int v2 = Integer.parseInt(stack.pop());
                int result = 0;
                switch(ele) {
                    case "+":
                        result = v2 + v1;
                        break;
                    case "-":
                        result = v2 - v1;
                        break;
                    case "*":
                        result = v2 * v1;
                        break;
                    case "/":
                        result = v2 / v1;
                        break;
                    default:
                        throw new RuntimeException("运算符错误");
                }
                stack.push(Integer.toString(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public int operatorPriority(String operator) {
        int result = 0;
        if(operator.equals("+")) {
            result = 1;
        } else if(operator.equals("-")) {
            result = 1;
        } else if(operator.equals("*")) {
            result = 2;
        } else if(operator.equals("/")) {
            result = 2;
        } else if(operator.equals("(")) {//如果检测到"("符号，则停止循环
            result = -1;
        } else {
            throw new RuntimeException("接收的符号错误");
        }
        return result;
    }
}
