package com.abnamro.apps.referenceandroid.utils

import android.os.SystemClock
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId

object PerformanceUtils {

    fun measureClickResponseTime(
        clickableView: ViewInteraction,
        resultView: ViewInteraction,
        maxTimeMs: Long
    ) {
        val startTime = SystemClock.elapsedRealtime()

        clickableView.perform(click())
        resultView.check(matches(isDisplayed()))

        val endTime = SystemClock.elapsedRealtime()
        val responseTime = endTime - startTime

        assert(responseTime <= maxTimeMs) {
            "Response time $responseTime ms exceeded limit of $maxTimeMs ms"
        }
    }
}