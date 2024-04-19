package com.project.travel.management.passenger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.project.travel.management.activity.BaseActivity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasePassengerTest {

  private BasePassenger passenger;

  @BeforeEach
  public void setUp() {
    passenger = new BasePassenger("Test Passenger", 1, PassengerType.STANDARD, 100.0);
  }

  @Test
  public void testSignUpForActivity_Successful() {
    BaseActivity activity = mock(BaseActivity.class);
    when(activity.isFull()).thenReturn(false);
    when(activity.getCost()).thenReturn(50.0);

    passenger.signUp(activity);

    // Verify that the activity was signed up successfully
    assertEquals(1, passenger.getSignedUpActivities(passenger.getPassengerNumber()).size());
    assertEquals(activity, passenger.getSignedUpActivities(passenger.getPassengerNumber()).get(0));
  }

  @Test
  public void testSignUpForActivity_InsufficientBalance() {
    BaseActivity activity = mock(BaseActivity.class);
    when(activity.isFull()).thenReturn(false);
    when(activity.getCost()).thenReturn(150.0); // Higher cost than the passenger's balance

    passenger.signUp(activity);

    // Verify that the activity was not signed up due to insufficient balance
    assertNull(passenger.getSignedUpActivities(passenger.getPassengerNumber()));
  }

  @Test
  public void testSignUpForActivity_ActivityFull() {
    BaseActivity activity = mock(BaseActivity.class);
    when(activity.isFull()).thenReturn(true);

    passenger.signUp(activity);

    // Verify that the activity was not signed up due to being full
    assertNull(passenger.getSignedUpActivities(passenger.getPassengerNumber()));
  }
}
