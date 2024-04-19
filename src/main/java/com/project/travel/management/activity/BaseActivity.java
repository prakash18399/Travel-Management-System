package com.project.travel.management.activity;

import com.project.travel.management.destination.Destination;

public class BaseActivity implements Activity {

  private String name;
  private String description;
  private double cost;
  private int capacity;
  private int currentCapacity;
  private Destination destination;

  public BaseActivity(String name, String description, double cost, int capacity) {
    this.name = name;
    this.description = description;
    this.cost = cost;
    this.capacity = capacity;
    this.currentCapacity = capacity;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public double getCost() {
    return cost;
  }

  @Override
  public int getCapacity() {
    return capacity;
  }

  @Override
  public int currentCapacity() {
    return currentCapacity;
  }

  @Override
  public boolean isFull() {
    return currentCapacity == 0;
  }

  @Override
  public Destination getDestination() {
    return this.destination;
  }

  public void reduceCapacity() {
    this.currentCapacity--;
  }
}
