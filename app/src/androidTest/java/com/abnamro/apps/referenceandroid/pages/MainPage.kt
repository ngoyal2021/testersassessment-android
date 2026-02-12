package com.abnamro.apps.referenceandroid.pages
import com.abnamro.apps.referenceandroid.R
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.core.AllOf.allOf

class MainPage {
    private val fragmentContainer = withId(R.id.fragment)
    private val fabButton = withId(R.id.fab)
    private val helloWorldText = withText("Hello World!")
    private val settingsMenuText = withText("Settings")
    private val snackbarMessage = withText("Replace with your own action")

    // ==============================
    // View Getters (Optional)
    // ==============================

     fun helloWorld(): ViewInteraction =
        onView(allOf(helloWorldText, isDescendantOfA(fragmentContainer)))

     fun fab(): ViewInteraction =
        onView(fabButton)

     fun settingsMenu(): ViewInteraction =
        onView(settingsMenuText)

     fun snackbar(): ViewInteraction =
        onView(snackbarMessage)

    // ==============================
    // Assertions
    // ==============================

    fun verifyHelloWorldDisplayed() {
        helloWorld()
            .check(matches(isDisplayed()))
    }

    fun verifyFabDisplayed() {
        fab()
            .check(matches(isDisplayed()))
    }

    fun verifyFabClickable() {
        fab()
            .check(matches(isClickable()))
    }

    fun verifySnackbarDisplayed() {
        snackbar()
            .check(matches(isDisplayed()))
    }

    fun verifySettingsMenuVisible() {
        settingsMenu()
            .check(matches(isDisplayed()))
    }

    // ==============================
    // Actions
    // ==============================

    fun clickFab() {
        fab()
            .perform(click())
    }

    fun longClickFab() {
        fab()
            .perform(longClick())
    }

    fun clickSettingsMenu() {
        settingsMenu()
            .perform(click())
    }

    // ==============================
    // Generic Helpers
    // ==============================

    fun verifyTextDisplayed(text: String) {
        onView(withText(text))
            .check(matches(isDisplayed()))
    }

    fun longClickFabAndVerifyText(expectedText: String) {
        fab().perform(longClick())
        verifyTextDisplayed(expectedText)
    }
}