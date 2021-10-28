package Project.teamdomain;

public class Printer implements Equipment {
    private String model;
    private String printerType;

    public Printer() {
    }

    public Printer(String model, String printerType) {
        this.model = model;
        this.printerType = printerType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrinterType() {
        return printerType;
    }

    public void setPrinterType(String printerType) {
        this.printerType = printerType;
    }

    @Override
    public String getDescription() {
        return model + "(" + printerType + ")";
    }
}
