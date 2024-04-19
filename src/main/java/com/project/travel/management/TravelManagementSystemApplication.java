package com.project.travel.management;

import com.project.travel.management.activity.BaseActivity;
import com.project.travel.management.destination.Destination;
import com.project.travel.management.passenger.BasePassenger;
import com.project.travel.management.passenger.PassengerType;
import com.project.travel.management.printer.ActivityDetailsPrinter;
import com.project.travel.management.printer.ItineraryPrinter;
import com.project.travel.management.printer.PassengerDetailsPrinter;
import com.project.travel.management.printer.PassengerListPrinter;
import com.project.travel.management.printer.Printer;
import com.project.travel.management.travelpackage.TravelPackage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TravelManagementSystemApplication {

  public static void main(String[] args) {
    SpringApplication.run(TravelManagementSystemApplication.class, args);

    // making travel package
    TravelPackage travelPackage = new TravelPackage("Awesome Travel Package", 10);

    // creating activities
    BaseActivity hikingActivity = getActivity("HikingActivity", "Manali snow mountains hiking", 20, 5);
    BaseActivity boatingActivity = getActivity("BoatingActivity", "Kerala backwaters boating", 10, 5);

    // creating destinations in travel package with their activities
    List<Destination> destinations = new ArrayList<>();
    Destination manali = new Destination("Manali");
    Destination kerala = new Destination("Kerala");
    manali.addActivity(hikingActivity);
    kerala.addActivity(boatingActivity);
    destinations.add(manali);
    destinations.add(kerala);
    travelPackage.addDestinations(destinations);

    // creating passengers
    BasePassenger passenger1 = getPassenger("Prakash", 1, PassengerType.STANDARD, 100);
    BasePassenger passenger2 = getPassenger("Anil", 2, PassengerType.GOLD, 100);
    BasePassenger passenger3 = getPassenger("Pratik", 3, PassengerType.GOLD, 120);

    // adding passengers to travel package
    travelPackage.addPassenger(passenger1);
    travelPackage.addPassenger(passenger2);
    travelPackage.addPassenger(passenger3);

    Printer itineraryPrinter = new ItineraryPrinter();
    Printer passengerListPrinter = new PassengerListPrinter();
    Printer passengerDetailsPrinter = new PassengerDetailsPrinter();
    Printer activityDetailsPrinter = new ActivityDetailsPrinter();

    // printing itinerary
    itineraryPrinter.print(travelPackage);

    // printing passengers list
    passengerListPrinter.print(travelPackage);

    // printing each passenger details with their initial balance
    passengerDetailsPrinter.print(travelPackage);

    // printing activity details with their initial capacity
    activityDetailsPrinter.print(travelPackage);

    // signing up passengers for activities
    passenger1.signUp(hikingActivity);
    passenger2.signUp(hikingActivity);
    passenger3.signUp(boatingActivity);

    // printing each passenger details with their current balance (after signing up for activities)
    passengerDetailsPrinter.print(travelPackage);

    // printing activity details with their current capacity (after passengers signing up)
    activityDetailsPrinter.print(travelPackage);
  }

  private static BaseActivity getActivity(String name, String description, double cost, int capacity) {
    return new BaseActivity(name, description, cost, capacity);
  }

  private static BasePassenger getPassenger(String name, int passengerNumber, PassengerType type, double balance) {
    return new BasePassenger(name, passengerNumber, type, balance);
  }
}
