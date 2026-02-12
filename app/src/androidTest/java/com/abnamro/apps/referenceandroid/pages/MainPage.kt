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
    private val helloWorldText = onView(withId(R.id.fragment))
    private val helloWorldMatcher = withId(R.id.fragment)
    private val emailIcon = onView(withId(R.id.fab))
    private val settingsMenuItem = onView(withText("Settings"))
    private val snackbarText = onView(withText("Replace with your own action"))

    fun checkHelloWorldDisplayed() {
        helloWorldText.check(matches(isDisplayed()))
    }

    fun clickFab() {
        emailIcon.perform(click())
    }

    fun checkSnackbarTextDisplayed() {
        snackbarText.check(matches(isDisplayed()))
    }


    fun checkSettingsMenuVisible() {
        settingsMenuItem.check(matches(isDisplayed()))
    }

    fun clickSettingsMenu() {
        settingsMenuItem.perform(click())
    }

    fun checkFabIsDisplayed() {
        emailIcon.check(matches(isDisplayed()))
    }

    fun checkFabIsClickable()
    {
        emailIcon.check(matches(isClickable()))
    }



    fun  getHelloWorldText() : ViewInteraction {
            return onView(
                allOf(
                    withText("Hello World!"),
                    isDescendantOfA(helloWorldMatcher)
                )
            )
        }

    fun verifyTextLongClick(text: String) {
        onView(withId(R.id.fab))
            .perform(longClick())

        // If it shows Snackbar or toast, verify it
        onView(withText(text))
            .check(matches(isDisplayed()))
    }

    fun getEmailFab(): ViewInteraction = emailIcon

    fun getSnackbarText(): ViewInteraction = snackbarText

    fun getHelloWorld(): ViewInteraction = helloWorldText
    }

