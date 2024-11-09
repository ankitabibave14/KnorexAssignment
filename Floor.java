package Pkg1;

import java.util.HashMap;
import java.util.Map;


public class Floor {


    private int floorNumber;
    private int capacity;
    private Map<String, VehicleSpace> spaces;

    public Floor(int floorNumber, int capacity) {
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        this.spaces = new HashMap<>();
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (spaces.size() < capacity) {
            VehicleSpace space = new VehicleSpace(vehicle);
            spaces.put(vehicle.getRegistrationNumber(), space);
            return true;
        }
        return false;
    }

    public boolean removeVehicle(String registrationNumber) {
        return spaces.remove(registrationNumber) != null;
    }

    public boolean isSpaceAvailable(String vehicleType) {
        return spaces.size() < capacity;
    }

    public void displayStatus() {
        System.out.println("Floor " + floorNumber + ": " + spaces.size() + "/" + capacity + " spaces occupied.");
    }
}
