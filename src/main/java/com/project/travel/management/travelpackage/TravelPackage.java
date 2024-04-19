package com.project.travel.management.travelpackage;

import com.project.travel.management.destination.Destination;
import com.project.travel.management.passenger.Passenger;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TravelPackage {

  private String name;
  private int passengerCapacity;
  private List<Destination> itinerary;
  private List<Passenger> passengers;

  public TravelPackage(String name, int passengerCapacity) {
    this.name = name;
    this.passengerCapacity = passengerCapacity;
    this.itinerary = new ArrayList<>();
    this.passengers = new ArrayList<>();
  }

  public void addPassenger(Passenger passenger) {
    if (passengers.size() < passengerCapacity) {
      passengers.add(passenger);
      System.out.println(String.format("Passenger with id %s added successfully to package %s", passenger.getPassengerNumber(), this.name));
    } else {
      System.out.println(String.format("Travel package %s is full, cannot add more passengers", this.name));
    }
    System.out.println();
  }

  public void addDestinations(List<Destination> destinations) {
    itinerary.addAll(destinations);
  }
}
