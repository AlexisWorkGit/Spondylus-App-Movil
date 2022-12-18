package com.spondylus.animatedsplashscreendemo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.spondylus.animatedsplashscreendemo.navigation.SetupNavGraph
import com.spondylus.animatedsplashscreendemo.ui.theme.AnimatedSplashScreenDemoTheme


class MainActivity : ComponentActivity() {

    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
//        window.statusBarColor(Color.parseColor());
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedSplashScreenDemoTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
        Handler().postDelayed({
            val intent = Intent(this, OnBoard::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 3000 is the delayed time in milliseconds.




    }
//
//setContentView(R.layout.activity_main)
//        setOnboardingItems()

    }
//    private fun setOnboardingItems() {
//        onboardingItemsAdapter = OnboardingItemsAdapter(
//            listOf(
//                OnboardingItem(
//                    onboardingImage = R.drawable.onboarding_1,
//                    title = "Manage Your Task",
//                    description = "Organize all your to do s and projects"
//                ),
//                OnboardingItem(
//                    onboardingImage = R.drawable.onboarding_2,
//                    title = "Work On Time",
//                    description = "When you as Lorem Ipsum"
//                ),
//                OnboardingItem(
//                    onboardingImage = R.drawable.onboarding_3,
//                    title = "Work On Time",
//                    description = "When you as Lorem Ipsum"
//                )
//            )
//        )
//        val onboardingViewPager = findViewById<ViewPager2>(R.id.onboardingViewPager)
//        onboardingViewPager.adapter = onboardingItemsAdapter
//    }

