package com.project.travel.management.passenger;

import com.project.travel.management.activity.BaseActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasePassenger implements Passenger {

  private String name;
  private int passengerNumber;
  private PassengerType type;
  private double balance;
  private Map<Integer, List<BaseActivity>> passengerSignedUpActivitiesMap;

  public BasePassenger(String name, int passengerNumber, PassengerType type, double balance) {
    this.name = name;
    this.passengerNumber = passengerNumber;
    this.type = type;
    this.balance = balance;
    this.passengerSignedUpActivitiesMap = new HashMap<>();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getPassengerNumber() {
    return passengerNumber;
  }

  @Override
  public PassengerType getType() {
    return type;
  }

  @Override
  public double getBalance() {
    return balance;
  }

  @Override
  public boolean deductCost(double cost) {
    if (balance >= cost) {
      if (this.type.equals(PassengerType.STANDARD)) {
        balance -= cost;
        return true;
      } else if (this.type.equals(PassengerType.GOLD)) {
        balance -= cost * 0.9;
        return true;
      } else {
        return true;
      }
    }
    return false;
  }

  @Override
  public List<BaseActivity> getSignedUpActivities(int passengerNumber) {
    return passengerSignedUpActivitiesMap.get(passengerNumber);
  }

  public void signUp(BaseActivity activity) {
    if (!activity.isFull()) {
      if (deductCost(activity.getCost())) {
        if (!passengerSignedUpActivitiesMap.containsKey(this.passengerNumber)) {
          passengerSignedUpActivitiesMap.put(this.passengerNumber, List.of(activity));
        } else {
          passengerSignedUpActivitiesMap.get(this.passengerNumber).add(activity);
        }
        activity.reduceCapacity();
      } else {
        System.out.println("You don't have enough balance to sign up for this activity");
      }
    } else {
      System.out.println("Activity is full, no more passengers can sign up for this activity");
    }
  }
}
