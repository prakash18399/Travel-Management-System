package com.project.travel.management.printer;

import com.project.travel.management.activity.Activity;
import com.project.travel.management.activity.BaseActivity;
import com.project.travel.management.passenger.Passenger;
import com.project.travel.management.travelpackage.TravelPackage;

import java.util.List;

public class PassengerDetailsPrinter implements Printer {

  @Override
  public void print(TravelPackage travelPackage) {
    List<Passenger> passengers = travelPackage.getPassengers();
    for (Passenger passenger : passengers) {
      System.out.println("Printing passenger details:");
      System.out.println(" Passenger Name: " + passenger.getName());
      System.out.println(" Passenger Number: " + passenger.getPassengerNumber());
      System.out.println(" Balance: " + passenger.getBalance());
      List<BaseActivity> activities = passenger.getSignedUpActivities(passenger.getPassengerNumber());
      if (null != activities) {
        System.out.println(" Activities Signed Up:");
        for (Activity activity : activities) {
          System.out.println("  Activity: " + activity.getName());
        }
      } else {
        System.out.println("No activities signed up for passenger with id " + passenger.getPassengerNumber());
      }
      System.out.println();
    }
  }
}
