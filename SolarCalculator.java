import java.util.List;

public class SolarCalculator {
    public static CalculationResult calculate(List<Appliance> appliances, SystemParameters params) {
        CalculationResult r = new CalculationResult();

        double totalWh = 0;
        double peakLoad = 0;
        for (Appliance a : appliances) {
            totalWh += a.dailyWh();
            peakLoad += a.totalWatts();
        }

        r.totalDailyWh = totalWh;
        r.peakLoadW = peakLoad;
        r.pvW = (totalWh / Math.max(params.PSH, 0.1)) / params.efficiencyFactor;
        r.batteryAh = (totalWh * params.daysAutonomy) / (params.systemVoltage * params.DoD);
        r.inverterW = peakLoad * params.inverterMargin;
        r.controllerA = (r.pvW / params.systemVoltage) * 1.25;

        return r;
    }
}
