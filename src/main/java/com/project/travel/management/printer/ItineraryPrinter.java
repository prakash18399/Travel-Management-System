package com.project.travel.management.printer;

import com.project.travel.management.activity.Activity;
import com.project.travel.management.destination.Destination;
import com.project.travel.management.travelpackage.TravelPackage;

import java.util.List;

public class ItineraryPrinter implements Printer {

  @Override
  public void print(TravelPackage travelPackage) {
    System.out.println("Printing itinerary:");
    System.out.println("Travel Package: " + travelPackage.getName());
    List<Destination> destinations = travelPackage.getItinerary();
    for (Destination destination : destinations) {
      System.out.println(" Destination: " + destination.getName());
      List<Activity> activities = destination.getActivities();
      System.out.println("  Activities: ");
      for (Activity activity : activities) {
        System.out.println("    Activity: " + activity.getName());
        System.out.println("    Cost: " + activity.getCost());
        System.out.println("    Capacity: " + activity.getCapacity());
        System.out.println("    Description: " + activity.getDescription());
        System.out.println();
      }
    }
  }
}
