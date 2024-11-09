package Pkg1;

import Strategy.CostStrategy;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int floors;
    private int spacesPerFloor;
    private Map<Integer, Floor> floorMap;
    private CostStrategy costStrategy;

    public ParkingLot(int floors, int spacesPerFloor) {
        this.floors = floors;
        this.spacesPerFloor = spacesPerFloor;
        this.floorMap = new HashMap<>();
        for (int i = 1; i <= floors; i++) {
            floorMap.put(i, new Floor(i, spacesPerFloor));
        }
    }

    public void setCostStrategy(CostStrategy costStrategy) {
        this.costStrategy = costStrategy;
    }

    public void addVehicle(Vehicle vehicle) {
        for (Floor floor : floorMap.values()) {
            if (floor.addVehicle(vehicle)) {
                System.out.println("Vehicle " + vehicle.getRegistrationNumber() + " parked successfully.");
                return;
            }
        }
        System.out.println("Parking is full.");
    }

    public void removeVehicle(String registrationNumber) {
        for (Floor floor : floorMap.values()) {
            if (floor.removeVehicle(registrationNumber)) {
                System.out.println("Vehicle " + registrationNumber + " removed successfully.");
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    public boolean checkAvailability(int floorNumber, String vehicleType) {
        Floor floor = floorMap.get(floorNumber);
        return floor != null && floor.isSpaceAvailable(vehicleType);
    }

    public void displayStatus() {
        for (Floor floor : floorMap.values()) {
            floor.displayStatus();
        }
    }
}


