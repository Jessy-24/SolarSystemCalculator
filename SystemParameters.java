public class SystemParameters {
    public double PSH; 
    public int systemVoltage; 
    public double DoD; 
    public int daysAutonomy; 
    public double efficiencyFactor; 
    public double inverterMargin; 

    public SystemParameters(double PSH, int systemVoltage, double DoD,
                            int daysAutonomy, double efficiencyFactor, double inverterMargin) {
        this.PSH = PSH;
        this.systemVoltage = systemVoltage;
        this.DoD = DoD;
        this.daysAutonomy = daysAutonomy;
        this.efficiencyFactor = efficiencyFactor;
        this.inverterMargin = inverterMargin;
    }
}
