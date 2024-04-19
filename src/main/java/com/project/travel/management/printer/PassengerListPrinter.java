package com.project.travel.management.printer;

import com.project.travel.management.passenger.Passenger;
import com.project.travel.management.travelpackage.TravelPackage;

import java.util.List;

public class PassengerListPrinter implements Printer {

  @Override
  public void print(TravelPackage travelPackage) {
    System.out.println("Printing passenger list:");
    System.out.println("Travel Package: " + travelPackage.getName());
    System.out.println("Passenger Capacity: " + travelPackage.getPassengerCapacity());
    List<Passenger> passengers = travelPackage.getPassengers();
    System.out.println("Number of Passengers Enrolled: " + passengers.size());
    for (Passenger passenger : passengers) {
      System.out.println("  Passenger Name: " + passenger.getName());
      System.out.println("  Passenger Number: " + passenger.getPassengerNumber());
    }
    System.out.println();
  }
}
