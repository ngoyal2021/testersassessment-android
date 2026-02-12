package com.abnamro.apps.referenceandroid.common

import android.util.Log
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.abnamro.apps.referenceandroid.MainActivity
import com.abnamro.apps.referenceandroid.pages.MainPage
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestName

open class BaseTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    @get:Rule
    val testName = TestName()


    protected lateinit var mainPage: MainPage

    @Before
    open fun setUp() {
        mainPage = MainPage()
        Log.d("Test", "Starting test: ${testName.methodName}")
    }

    fun measureResponseTime(view: ViewInteraction) {
        val startTime = System.currentTimeMillis()
        ActivityScenario.launch(MainActivity::class.java)

        view.check(matches(isDisplayed()))

        val endTime = System.currentTimeMillis()
        val launchTime = endTime - startTime

        assertTrue("App launch took too long: $launchTime ms", launchTime < 3000)
    }




    @After
    fun logTestEnd() {
        Log.d("Test", "Test finished : ${testName.methodName}")
    }
}