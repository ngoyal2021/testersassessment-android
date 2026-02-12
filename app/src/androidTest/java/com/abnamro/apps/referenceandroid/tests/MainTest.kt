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
        mainPage.checkHelloWorldDisplayed()
        mainPage.checkFabIsDisplayed()
        openContextualActionModeOverflowMenu()
        mainPage.checkSettingsMenuVisible()

    }

    @Test
    @SmokeTest
    fun verifyAppLaunchtime()
    {
        measureResponseTime(mainPage.getHelloWorld())
    }

    @Test
    @RegressionTest
    fun verifySnackBarTextOnSimpleClick()
    {
        mainPage.checkFabIsClickable()
        mainPage.clickFab()
        mainPage.checkSnackbarTextDisplayed()
    }

    @Test
    @RegressionTest
    fun verifySnackBarTextOnLongClick()
    {
        mainPage.verifyTextLongClick("Replace with your own action")
        mainPage.checkSnackbarTextDisplayed()
    }



    @Test
    @RegressionTest
    fun verifyHelloWorldText()
    {
        mainPage.checkHelloWorldDisplayed()
        mainPage.getHelloWorldText().check(matches(isDisplayed()))
    }

    @Test
    @RegressionTest
    fun clickMenuItem()
    {
        openContextualActionModeOverflowMenu()
        mainPage.checkSettingsMenuVisible()
        CommonMethod.clickMenuItem("Settings")
    }

    @Test
    @RegressionTest
    fun verifyResponseTime()
    {
        PerformanceUtils.measureClickResponseTime(clickableView = mainPage.getEmailFab(),
            resultView = mainPage.getSnackbarText(),
            maxTimeMs = 1000 )
    }


}