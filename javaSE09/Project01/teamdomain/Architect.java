package Project.teamdomain;

public class Architect extends Designer {
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equip, double bonus, int stock) {
        super(id, name, age, salary, equip, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetail() + "\t架构师\t" + getStatus()  + "\t" + getBonus() + "\t" + stock + "\t" + getEquip().getDescription();
    }

    @Override
    public String getDetailForTeam() {
        return getTeamDetail() + "\t架构师\t" + getBonus() + "\t" + getStock();
    }
}
