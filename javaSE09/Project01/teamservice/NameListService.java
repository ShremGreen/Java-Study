package Project.teamservice;

import Project.teamdomain.*;

import static Project.teamservice.Data.*;
/*
通过本类，将Data类中的员工二维数组和Employee类中各个形联系起来。
 */
public class NameListService {
    private Employee[] employees;

    //本类无参构造方法
    public NameListService() {
        //根据Data类构造相应大小的employees数组
        //构建不同的对象：雇员、程序员、设计师、架构师
        employees = new Employee[Data.EMPLOYEES.length];
        for(int i = 0; i < employees.length; i ++) {

            //获取员工类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            //获取Employee的信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            Equipment equipment;
            double bonus;
            int stock;
            //挨个检查type信息，并与相应职业对应
            switch(type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment = creatEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);//多态    并将装备作为参数传递给子类对象
                    break;
                case DESIGNER:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);//多态
                    break;
                case ARCHITECTER:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);//多态
                    break;
            }
        }
    }

    //创建装备方法    参数列表i   返回值Equipment
    public Equipment creatEquipment(int i) {
        int type = Integer.parseInt(EQUIPMENTS[i][0]);

        String model = EQUIPMENTS[i][1];
        switch(type) {
            case PC:
                String screen = EQUIPMENTS[i][2];
                return new PC(model,screen);
            case NOTEBOOK:
                double price = Double.parseDouble(EQUIPMENTS[i][2]);
                return new NoteBook(model,price);
            case PRINTER:
                String printerType = EQUIPMENTS[i][2];
                return new Printer(model,printerType);
        }
        return null;
    }

    //返回所有employees    参数列表空   返回值Employee数组
    public Employee[] getAllEmployees() {
        return employees;
    }

    //获取指定位置的employee的方法    参数列表id  返回值Employee数组中的单个元素
    //需注意：该方法可能出现异常，自定义一个异常
    public Employee getEmployees(int id) throws TeamException{
        for(int i = 0; i < employees.length; i ++) {
            if(employees[i].getId() == id) {
                return employees[i];
            }
        }
        throw new TeamException("找不到该人员！");
    }
}
