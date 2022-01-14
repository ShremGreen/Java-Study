package Stack;
/*
使用栈完成表达式的计算
思路：
1.通过一个index值（索引），来遍历我们的表达式
2.如果我们发现是一个数字,就直接入数栈
3.如果发现扫描到是一个符号,就分如下情况
    3.1如果发现当前的符号栈为空,就直接入栈
    3.2如果符导栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符，
    就需要从数栈中pop出两个数在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，
    然后将当前的操作符入符号栈，如果当前的操作符的优先级大于栈中的操作符,就直接入符号桂.
4.当表达式扫描完毕,就顺序的从数栈和符号栈中pop出相应的数和符号，并运行.5.最后在数栈只有个数字,就是表达式的结果

 */
public class CalculatorNorm {
    public static void main(String[] args) {
        String expression = "3+2*6-2";
        CalculatorStack numStack = new CalculatorStack(10);
        CalculatorStack opeStack = new CalculatorStack(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int operator = 0;
        int result = 0;
        int value = 0;

        //开始扫描
        while(true) {
            //读取元素
            value = expression.charAt(index);
            //判断类型
            if(opeStack.isOperator(value)) {
                //判断当前栈是否为空
                if(opeStack.isEmpty()) {
                    opeStack.push(value);
                }else {
                    //比较操作符
                    if(opeStack.priority(value) <= opeStack.priority(opeStack.topValue())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = opeStack.pop();
                        result = opeStack.calculate(num1,num2,operator);
                        //将result压入数栈
                        numStack.push(result);
                        //下一个操作符压入符号栈
                        opeStack.push(value);
                    }else {
                        opeStack.push(value);
                    }
                }
            }else {
                //注意字符转数字的ascii码，0对应48
                numStack.push(value - 48);
            }

            index ++;
            if(index >= expression.length()) {
                break;
            }
        }

        //扫描完毕，计算最终结果
        while(true) {
            //若最后符号栈为空，那么数栈只有一个数字，即结果
            if(opeStack.isEmpty()) {
                break;
            }else {
                num1 = numStack.pop();
                num2 = numStack.pop();
                operator = opeStack.pop();
                result = opeStack.calculate(num1,num2,operator);
                numStack.push(result);
            }
        }
        System.out.println(expression + " = " + numStack.pop());
    }
}

class CalculatorStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;//栈顶

    public CalculatorStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];//初始化栈数组
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if(isFull()) {
            throw new RuntimeException("栈满，不能存放数据");
        }
        top ++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("栈空，请先存放数据");
        }
        int value = stack[top];
        stack[top] = 0;
        top --;
        return value;
    }

    //遍历
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空，请先存放数据");
            return;
        }
        for(int i = top; i > -1; i --) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    //返回栈顶值
    public int topValue() {
        return stack[top];
    }

    //运算优先级
    public int priority(int operater) {
        if(operater == '*' || operater == '/') {
            return 1;
        } else if(operater == '+' || operater == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是运算符
    public boolean isOperator(int value) {
        return value == '*' || value == '/' || value == '+' || value == '-';
    }

    //计算
    public int calculate(int v1, int v2, int operator) {
        int result = 0;
        switch(operator) {
            case '+':
                result = v2 + v1;
                break;
            case '-':
                result = v2 - v1;
                break;
            case '*':
                result = v2 * v1;
                break;
            case '/':
                result = v2 / v1;
                break;
            default:
                break;
        }
        return result;
    }
}