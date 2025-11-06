public class Appliance {
    private String name;
    private double watts;
    private int quantity;
    private double hoursPerDay;

    public Appliance(String name, double watts, int quantity, double hoursPerDay) {
        this.name = name;
        this.watts = watts;
        this.quantity = quantity;
        this.hoursPerDay = hoursPerDay;
    }

    public double dailyWh() {
        return watts * quantity * hoursPerDay;
    }

    public double totalWatts() {
        return watts * quantity;
    }

    public String getName() {
        return name;
    }

    public double getWatts() {
        return watts;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getHoursPerDay() {
        return hoursPerDay;
    }
}
