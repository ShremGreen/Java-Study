package Project.junit;

import Project.teamdomain.Employee;
import Project.teamservice.NameListService;
import Project.teamservice.TeamException;

import java.util.Scanner;

/*
该类用于测试设置好的NameListService类效果
 */
public class NameListServiceTest {
    public static void main(String[] args) {
        TestGetAllEmployees();
        System.out.println();
        TestGetEmployees();
    }
    public static void TestGetAllEmployees() {
        NameListService s = new NameListService();
        Employee[] employees = s.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void TestGetEmployees() {
        NameListService s = new NameListService();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查看的人员：");
        int index = sc.nextInt();
        try {
            Employee employees = s.getEmployees(index);
            System.out.println(employees);
        } catch(TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
