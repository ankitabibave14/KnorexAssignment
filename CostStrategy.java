package Strategy;

public interface CostStrategy {

    void setCost(String vehicleType, int costPerHour);

    int calculateCost(String vehicleType, int hours);
}
