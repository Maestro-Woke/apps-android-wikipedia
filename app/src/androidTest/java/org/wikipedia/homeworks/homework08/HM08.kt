package org.wikipedia.homeworks.homework08

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import io.github.kakaocup.kakao.screen.Screen
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.matches
import org.wikipedia.R
import org.wikipedia.onboarding.OnboardingActivity

class OnboardingTest : Screen<OnboardingScreen>() {

    @get:Rule
    val activityRule = ActivityScenarioRule(OnboardingActivity::class.java)

    @Test
    fun testOnboardingImageIsDisplayed() {
        OnboardingScreen.imageViewCentered.isDisplayed()
    }

    @Test
    fun testPrimaryTextIsDisplayed() {
        OnboardingScreen.primaryTextView.isDisplayed()
    }

    @Test
    fun testSecondaryTextIsDisplayed() {
        OnboardingScreen.secondaryTextView.isDisplayed()
    }

    @Test
    fun testLanguageOptionAndAddButton() {
        // Проверка видимости опции языка
        onView(withId(R.id.languageRecyclerView))
            .check(matches(isDisplayed()))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))

        // Проверка кнопки добавления языка
        onView(withId(R.id.addLanguageButton))
            .check(matches(isDisplayed()))
            .perform(click())

        // Проверка, что язык был добавлен
        onView(withText("New Language"))
            .check(matches(isDisplayed()))
    }
}