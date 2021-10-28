package Project.teamservice;
/*
需求：存储 壮小伙 信息
 */
public class Data {
    public static final int EMPLOYEE = 10;//final 修饰的词全大写
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECTER = 13;

    public static final int PC = 21;
    public static final int NOTEBOOK = 22;
    public static final int PRINTER = 23;

    //Employee  :  10, id, name, age, salary
    //Programmer:  11, id, name, age, salary
    //Designer  :  12, id, name, age, salary, bonus
    //Architect :  13, id, name, age, salary, bonus, stock
    public static final String[][] EMPLOYEES = {
            {"10", "1", "樊弘壮", "22", "3000"},
            {"13", "2", "华山兰", "32", "18000", "15000", "2000"},
            {"11", "3", "沈芃芃", "23", "7000"},
            {"11", "4", "乙傲玉", "24", "7300"},
            {"12", "5", "董梦槐", "28", "10000", "5000"},
            {"11", "6", "荣雅柔", "22", "6800"},
            {"12", "7", "登沛", "29", "10800","5200"},
            {"13", "8", "时元庆", "30", "19800", "15000", "2500"},
            {"12", "9", "艾亦竹", "26", "9800", "5500"},
            {"11", "10", "厉叶丹", "21", "6600"},
            {"11", "11", "邸溪", "25", "7100"},
            {"12", "12", "余语海", "27", "9600", "4800"}
    };

    //如下的EQUIPMENTS数组与上面的EMPLOYEES数组元素一一对应
    //PC      :21, model, screen
    //NoteBook:22, model, price
    //Printer :23, model, type
    public static final String[][] EQUIPMENTS = {
            {},
            {"22", "联想T4", "6000"},
            {"21", "戴尔", "NEC17寸"},
            {"21", "戴尔", "三星 17寸"},
            {"23", "佳能 2900", "激光"},
            {"21", "华硕", "三星 17寸"},
            {"21", "华硕", "三星 17寸"},
            {"23", "爱普生20K", "针式"},
            {"22", "惠普m6", "5800"},
            {"21", "戴尔", "NEC 17寸"},
            {"21", "华硕","三星 17寸"},
            {"22", "惠普m6", "5800"}
    };
}