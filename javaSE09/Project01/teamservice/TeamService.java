package Project.teamservice;

import Project.teamdomain.Architect;
import Project.teamdomain.Designer;
import Project.teamdomain.Employee;
import Project.teamdomain.Programmer;
/*
该类用于进行团队人员的管理：添加和删除
 */
public class TeamService {
    private static int count = 1;//给memberId赋值使用，自增
    private final  int MAX_MEMBER = 5;//限制团队人数
    private Programmer[] team = new Programmer[MAX_MEMBER];//团队对象
    private int total;//团队实际人数

    public TeamService() {
    }

    //获取团队中的成员
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for(int i = 0; i < total; i ++) {
            team[i] = this.team[i];
        }
        return team;
    }

    //添加人员方法  可能存在许多Exception
    public void addMember(Employee employee) throws TeamException {
        //首先对可能异常的情况进行判断包装
        //成员已满，无法添加
        if(total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
        //该成员不是开发人员，无法添加
        if(!(employee instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        //该员工已在本开发团队中
        if (isExist(employee)) {
            throw new TeamException("该员工已在本开发团队中");
        }
        //该员工不在空闲状态
        Programmer programmer = (Programmer) employee;//因为Employee中没有status枚举量
        if(!(programmer.getStatus().getNAME().equals("FREE"))) {
            throw new TeamException("该员工不在空闲状态");
        }
        //团队中至多只能有一名架构师；团队中至多只能有两名设计师；团队中至多只能有三名程序员
        //需要先求出三种职业的总人数，再进行判断
        int numPro = 0, numDes = 0, numArc = 0;
        for(int i = 0; i < total; i ++) {
            if(team[i] instanceof Architect) {
                numArc ++;
            } else if(team[i] instanceof Designer) {
                numDes ++;
            } else if(team[i] instanceof Programmer) {
                numPro ++;
            }
        }
        if(programmer instanceof Architect){
            if(numArc >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if(programmer instanceof Designer) {
            if(numDes >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if(programmer instanceof Programmer) {
            if(numDes >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }
        //以上异常全部通过后才能进行添加人员操作：
        team[total ++] = programmer;//在目前team数组中最后一个元素后添加一个新人员
        //还需要把programmer的属性进行重新赋值
        programmer.setMemberId(count ++);
        programmer.setStatus(Status.BUSY);
    }

    public boolean isExist(Employee employee) {
        boolean judge = false;
        for(int i = 0; i < total; i ++) {
            if(team[i].getId() == employee.getId()) {
                judge = true;
            }
        }
        return judge;
    }

    //移除成员方法
    //存在异常：找不到成员（思路：循环正常结束后，即为找不到成员）
    public void removeMember(int memberId) throws TeamException {
        //首先修改枚举状态为FREE
        int i = 0;
        for(; i < total; i ++) {
            if(team[i].getMemberId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(i == total) {
            throw new TeamException("找不到该成员");
        }
        //memberId顺序前移
        for(int j = i + 1; j < total; j ++) {
            team[j - 1] = team[j];
        }
        //最后一位设置为null
        team[-- total] = null;
    }
}
