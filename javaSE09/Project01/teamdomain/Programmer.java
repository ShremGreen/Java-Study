package Project.teamdomain;
import Project.teamservice.Status;
public class Programmer extends Employee {
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equip;

    public Programmer() {
    }
    public Programmer(int id, String name, int age, double salary, Equipment equip) {
        super(id, name, age, salary);
        this.equip = equip;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquip() {
        return equip;
    }

    public void setEquip(Equipment equip) {
        this.equip = equip;
    }

    @Override
    public String toString() {//重写显示说明
        return getDetail() + "\t程序员\t" + status + "\t\t\t" + equip.getDescription();
    }

    public String getTeamDetail() {
        return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary();
    }

    public String getDetailForTeam() {
        return getTeamDetail() + "\t程序员";
    }
}
