package com.project.travel.management.passenger;

import com.project.travel.management.activity.BaseActivity;

import java.util.List;

public interface Passenger {

  String getName();

  int getPassengerNumber();

  PassengerType getType();

  double getBalance();

  boolean deductCost(double cost);

  List<BaseActivity> getSignedUpActivities(int passengerNumber);
}
