package Annotation;
/*
重复注解
*/

public @interface MyAnnotation02 {
    String value();
}

//方法1：新建一个注解文件，并在内部设定一个MyAnnotation类型的value()数组
//public @interface MyAnnotation03 {
//    MyAnnotation02[] value();
//}

@MyAnnotation02("animal dogs")
class Animal01 {

}