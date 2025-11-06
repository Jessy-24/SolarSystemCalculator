import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Appliance> appliances = new ArrayList<>();

        System.out.println("=== SOLAR POWER SYSTEM CALCULATOR ===");
        System.out.println("Enter appliances. Type 'done' when finished.");

        while (true) {
            System.out.print("\nAppliance name (or 'done'): ");
            String name = sc.next();
            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Power rating (Watts): ");
            double watts = sc.nextDouble();
            System.out.print("Quantity: ");
            int qty = sc.nextInt();
            System.out.print("Hours per day: ");
            double hours = sc.nextDouble();

            appliances.add(new Appliance(name, watts, qty, hours));
        }

        System.out.println("\n--- System Parameters ---");
        System.out.print("Peak Sun Hours (PSH): ");
        double psh = sc.nextDouble();
        System.out.print("System Voltage (12 / 24 / 48): ");
        int v = sc.nextInt();
        System.out.print("Depth of Discharge (%) [e.g. 50]: ");
        double dodPercent = sc.nextDouble();
        System.out.print("Days of Autonomy (backup days): ");
        int days = sc.nextInt();

        double DoD = dodPercent / 100.0;
        double efficiency = 0.75;
        double inverterMargin = 1.25;

        SystemParameters params = new SystemParameters(psh, v, DoD, days, efficiency, inverterMargin);
        CalculationResult result = SolarCalculator.calculate(appliances, params);

        // Output
        System.out.println("\n=== CALCULATION RESULTS ===");
        System.out.printf("Total Daily Energy Consumption: %.2f Wh/day%n", result.totalDailyWh);
        System.out.printf("Required Solar Panel Power: %.2f W%n", result.pvW);
        System.out.printf("Required Battery Capacity: %.2f Ah%n", result.batteryAh);
        System.out.printf("Recommended Inverter Size: %.2f W%n", result.inverterW);
        System.out.printf("Recommended Charge Controller Size: %.2f A%n", result.controllerA);
        System.out.printf("Estimated Peak Load: %.2f W%n", result.peakLoadW);

        System.out.println("\nThank you for using Solar Power System Calculator!");
        sc.close();
    }
}
