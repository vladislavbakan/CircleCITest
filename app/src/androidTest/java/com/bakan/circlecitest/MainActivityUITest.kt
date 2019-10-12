package com.bakan.circlecitest

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityUITest {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Test
    fun givenUserEnterNameAndClickButtonThenSnackPresent() {
        Espresso.onView(ViewMatchers.withHint("Your name"))
            .perform(ViewActions.typeText("User"))
        Espresso.onView(ViewMatchers.withId(R.id.fab))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText("Hello, User!"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun givenUserNotEnterNameAndClickButtonThenSnackNotPresent() {
        Espresso.onView(ViewMatchers.withId(R.id.fab))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.snackbar_text))
            .check(ViewAssertions.doesNotExist())
    }

}