package com.abnamro.apps.referenceandroid.tests

import androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.abnamro.apps.referenceandroid.annotations.RegressionTest
import com.abnamro.apps.referenceandroid.annotations.SmokeTest
import com.abnamro.apps.referenceandroid.common.BaseTest
import com.abnamro.apps.referenceandroid.utils.CommonMethod
import com.abnamro.apps.referenceandroid.utils.PerformanceUtils
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainTest : BaseTest(){

    @Test
    @SmokeTest
    fun verifyMainPage()
    {
        mainPage.verifyHelloWorldDisplayed()
        mainPage.verifyFabDisplayed()
        openContextualActionModeOverflowMenu()
        mainPage.verifySettingsMenuVisible()

    }

    @Test
    @SmokeTest
    fun verifyAppLaunchtime()
    {
        measureResponseTime(mainPage.helloWorld())
    }

    @Test
    @RegressionTest
    fun verifySnackBarTextOnSimpleClick()
    {
        mainPage.verifyFabClickable()
        mainPage.clickFab()
        mainPage.verifySnackbarDisplayed()
    }

    @Test
    @RegressionTest
    fun verifySnackBarTextOnLongClick()
    {
        mainPage.longClickFabAndVerifyText("Replace with your own action")
        mainPage.verifySnackbarDisplayed()
    }



    @Test
    @RegressionTest
    fun verifyHelloWorldText()
    {
        mainPage.verifyHelloWorldDisplayed()
        mainPage.helloWorld().check(matches(isDisplayed()))
    }

    @Test
    @RegressionTest
    fun clickMenuItem()
    {
        openContextualActionModeOverflowMenu()
        mainPage.verifySettingsMenuVisible()
        CommonMethod.clickMenuItem("Settings")
    }

    @Test
    @RegressionTest
    fun verifyResponseTime()
    {
        PerformanceUtils.measureClickResponseTime(clickableView = mainPage.fab(),
            resultView = mainPage.snackbar(),
            maxTimeMs = 1000 )
    }


}