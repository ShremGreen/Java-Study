package Project.teamdomain;

public class PC implements Equipment{
    private String model;//model 表示机器的型号
    private String screen;//screen  表示显示器型号

    public PC() {
    }

    public PC(String model, String screen) {
        this.model = model;
        this.screen = screen;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    @Override
    public String getDescription() {//重写装备显示
        return model +"(" + screen + ")";
    }
}
