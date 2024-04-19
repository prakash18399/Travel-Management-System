package com.project.travel.management.printer;

import com.project.travel.management.activity.Activity;
import com.project.travel.management.destination.Destination;
import com.project.travel.management.travelpackage.TravelPackage;

import java.util.List;

public class ActivityDetailsPrinter implements Printer {

  @Override
  public void print(TravelPackage travelPackage) {
    System.out.println("Printing activity details:");
    List<Destination> destinations = travelPackage.getItinerary();
    for (Destination destination : destinations) {
      List<Activity> activities = destination.getActivities();
      for (Activity activity : activities) {
        System.out.println("Activity: " + activity.getName());
        if (!activity.isFull()) {
          System.out.println(String.format(" Activity %s has available space %s", activity.getName(), activity.currentCapacity()));
        }
      }
    }
    System.out.println();
  }
}
