package com.jeandarwinnewmanrios.horoscapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
//import R
import com.jeandarwinnewmanrios.horoscapp.R
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.runner.RunWith
//import hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import com.jeandarwinnewmanrios.horoscapp.ui.detail.HoroscopeDetailActivity
import org.junit.After

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class MainActivityTest{

    @get:Rule( order =  0 )
    val hintRule = HiltAndroidRule(this)
    @get:Rule( order =  1 )
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup(){
        hintRule.inject()
        Intents.init()
    }

    @After
    fun tearDown(){
        Intents.release()
    }
    @Test
    fun when_mainActivity_is_Created_then_open_luckyFragment(){
        onView(withId(R.id.luckFragment)).perform(click())
    }

    @Test
    fun when_horoscope_is_selected_then_open_detail(){// hay que ir a configuracion para desactivar las animaciones de transicion para poder probar esto
        onView(withId(R.id.rvHoroscope))
            .perform(RecyclerViewActions
                .actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        intended(hasComponent(HoroscopeDetailActivity::class.java.name))
    }
}