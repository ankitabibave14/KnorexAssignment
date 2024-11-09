package Strategy;

import java.util.HashMap;
import java.util.Map;

public class FlatCostStrategy implements CostStrategy {

    private Map<String, Integer> costPerHour;

    public FlatCostStrategy() {
        costPerHour = new HashMap<>();
    }

    @Override
    public void setCost(String vehicleType, int cost) {
        costPerHour.put(vehicleType, cost);
    }

    @Override
    public int calculateCost(String vehicleType, int hours) {
        return costPerHour.getOrDefault(vehicleType, 0) * hours;
    }
}
