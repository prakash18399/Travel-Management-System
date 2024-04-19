package com.project.travel.management.activity;

import com.project.travel.management.destination.Destination;

public interface Activity {

  String getName();

  String getDescription();

  double getCost();

  int getCapacity();

  int currentCapacity();

  boolean isFull();

  Destination getDestination();
}
