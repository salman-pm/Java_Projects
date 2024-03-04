package ParkingLot;

import ParkingLot.controllers.InitializationController;
import ParkingLot.controllers.TicketController;
import ParkingLot.models.Ticket;
import ParkingLot.models.Vehicle;
import ParkingLot.models.enums.VehicleType;
import ParkingLot.repository.*;
import ParkingLot.services.InitializationService;
import ParkingLot.services.TicketService;

import java.util.Scanner;

public class ParkingLotClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();

        InitializationService initializationService = new InitializationService(
                parkingLotRepository,
                parkingFloorRepository,
                parkingSpotRepository,
                gateRepository
        );

        TicketService ticketService = new TicketService(
                ticketRepository,
                parkingLotRepository,
                gateRepository,
                parkingSpotRepository
        );

        TicketController ticketController = new TicketController(ticketService);
        InitializationController initializationController = new InitializationController(initializationService);

        System.out.println("*** Parking Lot Data Initialization - START ***");
        initializationController.init();
        System.out.println("*** Parking Lot Data Initialization - Initialization END ***");
        System.out.println("Please choose an option");
        System.out.println("1. Enter Parking Lot ");
        System.out.println("2. Exit Parking Lot ");
        System.out.println("3. Exit");
        int option = sc.nextInt();
        while(true){
            if(option == 1){
                System.out.println("Welcome to our Parking Lot");
                Vehicle vehicle = new Vehicle();
                System.out.println("Please enter your vehicle details");
                System.out.println("Enter your vehicle model");
                String vehicleModelInput = sc.next();
                vehicle.setVehicleNumber(vehicleModelInput);
                System.out.println("Enter your vehicle number");
                String vehicleNumberInput = sc.next();
                vehicle.setVehicleNumber(vehicleNumberInput);
                System.out.println("Enter your vehicle color");
                String vehicleColorInput = sc.next();
                vehicle.setColor(vehicleColorInput);
                System.out.println("Choose your vehicle type --> 1.CAR  2. BIKE");
                int vehicleTypeInput = sc.nextInt();
                if(vehicleTypeInput == 1){
                    vehicle.setVehicleType(VehicleType.CAR);
                }
                else if(vehicleTypeInput == 2){
                    vehicle.setVehicleType(VehicleType.BIKE);
                }

                System.out.println("Please enter the parking lot ID");
                int parkingLotIdInput = sc.nextInt();
                System.out.println("Please enter the entry gate ID");
                int entryGateIdInput = sc.nextInt();
                Ticket ticket = ticketController.generateTicket(vehicle, parkingLotIdInput, entryGateIdInput);
                System.out.println("Ticket details: ");
                System.out.println(ticket);
            }
            else if(option == 2){
                // generate bill
            }
            else{
                System.out.println("Thanks for Visiting");
                break;
            }
        }

    }
}
