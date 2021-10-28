package Project.teamdomain;

public class Designer extends Programmer {
    private double bonus;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equip, double bonus) {
        super(id, name, age, salary, equip);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetail() + "\t设计师\t" + getStatus()  + "\t" + bonus + "\t\t" + getEquip().getDescription();
    }
    public String getDetailForTeam() {
        return getTeamDetail() + "\t设计师\t" + getBonus();
    }
}
