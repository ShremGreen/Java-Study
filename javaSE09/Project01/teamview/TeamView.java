package Project.teamview;

import Project.teamdomain.Employee;
import Project.teamdomain.Programmer;
import Project.teamservice.NameListService;
import Project.teamservice.TeamException;
import Project.teamservice.TeamService;
import static Project.teamview.TSUtility.readConfirmSelection;
/*操作主界面
 */

public class TeamView {
    private NameListService nls = new NameListService();//初始化，并将Data类读取进Employee数组
    private TeamService ts = new TeamService();

    //进入系统方法
    public void enterMainMenu() {
        boolean loopFlag = true;
        char menu = 0;
        while(loopFlag) {
            if(menu != '1') {
                listAllEmployees();
            }
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出    请选择（1-4）");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("是否退出系统？  （Y/N）");
                    char judge = readConfirmSelection();
                    if(judge == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    //返回所有人员信息
    private void listAllEmployees() {
        System.out.println("----------------------------------------------------------");
        Employee[] employees = nls.getAllEmployees();
        if(employees == null || employees.length == 0) {
            System.out.println("公司中没有任何员工！");
        } else {
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t装备");
            for(int i = 0; i < employees.length; i ++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("----------------------------------------------------------");
    }

    //获取团队所有队员信息
    private void getTeam() {
        System.out.println("------------------------团队成员列表-------------------------");
        Programmer[] team = ts.getTeam();
        if(team == null || team.length == 0) {
            System.out.println("团队中没有任何成员！");
        } else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for(int i = 0; i < team.length; i ++) {
                //System.out.println(team[i]);这里希望两次列表的格式不同，所以需要重新建立一次显示方法
                System.out.println(team[i].getDetailForTeam());
            }
        }
        System.out.println("----------------------------------------------------------");
    }

    //添加团队成员
    private void addMember() {
        System.out.println("------------------------添加成员------------------------");
        System.out.println("请输入要添加的成员ID");
        try {
            Employee employee = nls.getEmployees(TSUtility.readInt());
            ts.addMember(employee);
            System.out.println("添加成功！");
        } catch (TeamException e) {
            System.out.println("添加失败(" + e.getMessage() + ")");
        }
        TSUtility.readReturn();//按回车键继续
    }

    //删除团队成员
    private void deleteMember() {
        System.out.println("------------------------添加成员------------------------");
        System.out.println("请输入要删除的成员:");
        int memberId = TSUtility.readInt();
        System.out.println("确定要删除TID为" + memberId + "号的成员吗？");
        if(TSUtility.readConfirmSelection() == 'N') {
            return;
        }

        try {
            ts.removeMember(memberId);
            System.out.println("删除成功！");
        } catch (TeamException e) {
            System.out.println("删除失败（" + e.getMessage() + ")");
        }
        TSUtility.readReturn();//按回车键继续
    }

    //测试类
    public static void main(String[] args) {
        TeamView tv = new TeamView();
        tv.enterMainMenu();
    }
}
