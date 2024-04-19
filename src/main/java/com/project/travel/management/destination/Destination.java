package com.project.travel.management.destination;

import com.project.travel.management.activity.Activity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Destination {

  private String name;
  private List<Activity> activities;

  public Destination(String name) {
    this.name = name;
    this.activities = new ArrayList<>();
  }

  public void addActivity(Activity activity) {
    activities.add(activity);
  }
}
