package com.project.travel.management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.project.travel.management.destination.Destination;
import com.project.travel.management.passenger.Passenger;
import com.project.travel.management.travelpackage.TravelPackage;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TravelPackageTest {

  private TravelPackage travelPackage;

  @BeforeEach
  public void setUp() {
    travelPackage = new TravelPackage("Test Package", 2);
  }

  @Test
  public void testAddPassenger_Successful() {
    Passenger passenger = mock(Passenger.class);
    when(passenger.getPassengerNumber()).thenReturn(1);

    travelPackage.addPassenger(passenger);

    assertTrue(travelPackage.getPassengers().contains(passenger));
    assertEquals(1, travelPackage.getPassengers().size());
  }

  @Test
  public void testAddPassenger_FullPackage() {
    Passenger passenger1 = mock(Passenger.class);
    Passenger passenger2 = mock(Passenger.class);
    when(passenger1.getPassengerNumber()).thenReturn(1);
    when(passenger2.getPassengerNumber()).thenReturn(2);

    travelPackage.addPassenger(passenger1);
    travelPackage.addPassenger(passenger2);

    Passenger passenger3 = mock(Passenger.class);
    when(passenger3.getPassengerNumber()).thenReturn(3);

    travelPackage.addPassenger(passenger3);

    assertFalse(travelPackage.getPassengers().contains(passenger3));
    assertEquals(2, travelPackage.getPassengers().size());
  }

  @Test
  public void testAddDestinations() {
    Destination destination1 = mock(Destination.class);
    Destination destination2 = mock(Destination.class);
    List<Destination> destinations = new ArrayList<>();
    destinations.add(destination1);
    destinations.add(destination2);

    travelPackage.addDestinations(destinations);

    assertTrue(travelPackage.getItinerary().contains(destination1));
    assertTrue(travelPackage.getItinerary().contains(destination2));
    assertEquals(2, travelPackage.getItinerary().size());
  }
}
