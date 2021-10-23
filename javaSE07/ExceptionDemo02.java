package JavaSE.API;
/*
try-catch
常用异常处理方式：
String getMessage()
void printStackTrace()
 */
public class ExceptionDemo02 {
    public static void main(String[] args) {
        String s = "123";
        s = "abc";
        try {System.out.println(Integer.parseInt(s));
            System.out.println("test1");
        } catch(NumberFormatException e) {
            System.out.println("数值格式异常");
            System.out.println("test2");
            //String getMessage()
            System.out.println(e.getMessage());
            //printStackTrace
            e.printStackTrace();
        } catch(ClassCastException e) {
            System.out.println("类型转换异常");
        } catch(Exception E) {//异常父类，先写子类
            System.out.println("出现异常");
        }
    }
}
