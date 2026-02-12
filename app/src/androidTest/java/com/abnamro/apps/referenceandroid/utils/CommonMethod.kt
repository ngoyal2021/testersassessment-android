package com.abnamro.apps.referenceandroid.utils

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText

object CommonMethod {

    fun clickMenuItem(menuText: String) {
        onView(withText(menuText))
            .perform(click())
    }
}