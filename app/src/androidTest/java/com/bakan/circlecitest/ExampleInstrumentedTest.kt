package com.bakan.circlecitest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Before
    fun setup() {
        activityRule.launchActivity(null)
    }

    @Test
    fun userDoesNotEnterNameAndClicksFABThenDoesNotSeeSnack() {
        onView(withContentDescription("Email button"))
            .perform(click())

        onView(withId(R.id.snackbar_text))
            .check(doesNotExist())
    }

    @Test
    fun userEntersNameAndClicksFABThenSeeSnackWithHello() {
        onView(withHint("Your name"))
            .perform(typeText("Jack"))

        onView(withContentDescription("Email button"))
            .perform(click())

        onView(withId(R.id.snackbar_text))
            .check(matches(withText("Hello, Jack!")))
    }
}
