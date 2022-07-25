package com.example.myapplication;

        import static org.junit.Assert.*;
        import static androidx.test.espresso.Espresso.onView;
        import static androidx.test.espresso.Espresso.pressBack;
        import static androidx.test.espresso.action.ViewActions.click;
        import static androidx.test.espresso.matcher.ViewMatchers.withId;
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
class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityActivityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void uiTest() {
    }

}