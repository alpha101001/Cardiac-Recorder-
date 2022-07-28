package com.example.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@LargeTest

public class UITest {
    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityActivityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

     @Test
    public void testAllActivity() {
         onView(withId(R.id.insertButton)).perform(click());
         /*
          *updating data
          */
         onView(withId(R.id.idateValue)).perform(ViewActions.typeText("12/10/2021"));
         onView(withId(R.id.itimeValue)).perform(ViewActions.typeText("10:19"));
         onView(withId(R.id.isystolicValue)).perform(ViewActions.typeText("120"));
         onView(withId(R.id.idiastolicValue)).perform(ViewActions.typeText("90"));
         pressBack();
         onView(withId(R.id.iheartRateValue)).perform(ViewActions.typeText("69"));
         pressBack();
         onView(withId(R.id.icommentValue)).perform(ViewActions.typeText("UI test data insert"));
         pressBack();
         onView(withId(R.id.addButton)).perform(click());




         /*
          *viewing data
          */
         onView(ViewMatchers.withId(R.id.recyclerView))
                 .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
         pressBack();

         /*
          * updating data
          */
         onView(withId(R.id.recyclerView)).perform(
                 RecyclerViewActions.actionOnItemAtPosition(0, MyViewAction.clickChildViewWithId(R.id.editButton)));
         onView(withId(R.id.udateValue)).perform(ViewActions.clearText());
         onView(withId(R.id.udateValue)).perform(ViewActions.typeText("11/10/2021"));
         onView(withId(R.id.utimeValue)).perform(ViewActions.clearText());
         onView(withId(R.id.utimeValue)).perform(ViewActions.typeText("10:19"));
         onView(withId(R.id.usystolicValue)).perform(ViewActions.clearText());
         onView(withId(R.id.usystolicValue)).perform(ViewActions.typeText("110"));
         onView(withId(R.id.udiastolicValue)).perform(ViewActions.clearText());
         onView(withId(R.id.udiastolicValue)).perform(ViewActions.typeText("80"));
         pressBack();
         onView(withId(R.id.uheartRateValue)).perform(ViewActions.clearText());
         onView(withId(R.id.uheartRateValue)).perform(ViewActions.typeText("69"));
         pressBack();
         onView(withId(R.id.ucommentValue)).perform(ViewActions.clearText());
         onView(withId(R.id.ucommentValue)).perform(ViewActions.typeText("Updated"));
         pressBack();
         onView(withId(R.id.updateButton)).perform(click());

         /*
          *deleting data
          */

         onView(withId(R.id.recyclerView)).perform(
                 RecyclerViewActions.actionOnItemAtPosition(0, MyViewAction.clickChildViewWithId(R.id.deleteButton)));

     }


}