package Main;

import Pkg1.*;
import Strategy.*;

public class ParkingLotSystem {

    public static void main(String[] args) {
        System.out.println("Welcome to Parking System..!!");

        ParkingLot parkingLot = new ParkingLot(2, 5);

        // Configure cost strategy (for example, per hour cost)
        CostStrategy costStrategy = new FlatCostStrategy();
        costStrategy.setCost("Car", 40);
        costStrategy.setCost("Auto", 30);
        costStrategy.setCost("Bike/Scooter", 20);
        parkingLot.setCostStrategy(costStrategy);

        // Add vehicles
        parkingLot.addVehicle(new Vehicle("Bike/Scooter","BS-001" ,"White" ));
        parkingLot.addVehicle(new Vehicle("Car", "CA-001", "Red"));
        parkingLot.addVehicle(new Vehicle("Auto", "AU-001", "Black"));

        // Display current status
        parkingLot.displayStatus();

        // Check availability for cars on the first floor
        System.out.println(parkingLot.checkAvailability(1, "Car"));

        // Remove a vehicle by registration number
        parkingLot.removeVehicle("CA-001");

        // Display status again
        parkingLot.displayStatus();

    }
}
