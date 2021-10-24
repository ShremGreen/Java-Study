package JavaSE.Exception;
/*
编写应用程序EcmDef.java,接收命令行的两个参数，要求不能输入负数，计算两数相除。
对数据类型不一致(NumberFormatException)
缺少命令行参数(ArrayIndexOutOfBoundsException、
分母为0(ArithmeticException)
输入负数(EcDef自定义的异常)进行异常处理。

 */
public class EcmDef {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);//命令行参数修改：Run→Edit Configurations
            int result = ecm(a,b);
            System.out.println(result);
        } catch(NumberFormatException e) {
            System.out.println("数据类型不一致");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
        } catch(ArithmeticException e) {
            System.out.println("分母为0");
        } catch(EcDef e) {
            System.out.println(e.getMessage());
        }
    }
    public static int ecm(int a, int b) throws EcDef{
        if(a < 0 || b < 0) {
            throw new EcDef("分子或分母出现负数！");
        }
        return a/b;
    }
}
//自定义异常，功能：数值小于0时生成异常
class EcDef extends Exception {
    static final long serialVersionUID = -3387516992912123L;

    public EcDef() {
    }

    public EcDef(String message) {
        super(message);
    }
}
