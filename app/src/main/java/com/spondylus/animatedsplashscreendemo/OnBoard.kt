package com.spondylus.animatedsplashscreendemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.compose.runtime.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

//
//@Composable fun OnBoard(navController: NavHostController){
//    navController.popBackStack()
//}

//@Composable
//fun SecondScreen(){
//    Scaffold {
//        BodyContent()
//    }
//}

//@Composable
//fun BodyContent() {
//    Column() {
    class OnBoard : AppCompatActivity(){
        private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter
        private lateinit var indicatorsContainer: LinearLayout

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            setOnboardingItems()
            setupIndicators()
            setCurrentIndicator(0)
        }

        private fun setOnboardingItems() {
            onboardingItemsAdapter = OnboardingItemsAdapter(
                listOf(
                    OnboardingItem(
                        onboardingImage = R.drawable.onboarding_1,
                        title = "Facturación Electrónica en la nube, ahora puedes facturar desde cualquier parte del mundo",
//                        description = "Ahora puedes facturar desde cualquier parte del mundo",
                        color = R.color.custom_color_background
                    ),
                    OnboardingItem(
                        onboardingImage = R.drawable.onboarding_2,
                        title = "Se más productivo, ahorra hasta un 70% de tiempo y recursos",
//                        description = "Ahorra hasta un 70% de tiempo y recursos",
                        color = R.color.custom_color_background
                    ),
                    OnboardingItem(
                        onboardingImage = R.drawable.onboarding_3,
                        title = "Todo en un solo sitio, realiza tus trámites y papeleo desde tu dispositivo",
//                        description = "Realiza tus trámites y papeleo desde tu dispositivo",
                        color = R.color.custom_color_background
                    )
                )
            )
            val onboardingViewPager = findViewById<ViewPager2>(R.id.onboardingViewPager)
            onboardingViewPager.adapter = onboardingItemsAdapter
            onboardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    setCurrentIndicator(position)
                }
            })
            (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER
            findViewById<ImageView>(R.id.imageNext).setOnClickListener{
                if (onboardingViewPager.currentItem+1 < onboardingItemsAdapter.itemCount) {
                    onboardingViewPager.currentItem += 1
                }else {
                    navigateToHomeActivity()
                }
            }
            findViewById<TextView>(R.id.textSkip).setOnClickListener {
                navigateToHomeActivity()
            }
            findViewById<Button>(R.id.buttonGetStarted).setOnClickListener{
                navigateToHomeActivity()
            }
        }

        private fun navigateToHomeActivity() {
            startActivity(Intent(applicationContext, WebView::class.java))
            finish()
        }

        private fun setupIndicators() {
            indicatorsContainer = findViewById(R.id.indicatorsContainer)
            val indicators = arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
            val layoutParams: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            layoutParams.setMargins(8,0,8,0)
            for (i in indicators.indices) {
                indicators[i] = ImageView(applicationContext)
                indicators[i]?.let {
                    it.setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.indicator_inactive_background
                        )
                    )
                    it.layoutParams = layoutParams
                    indicatorsContainer.addView(it)
                }
            }
        }

        private fun setCurrentIndicator(position: Int) {
            val childCount = indicatorsContainer.childCount
            for (i in 0 until childCount) {
                val imageView = indicatorsContainer.getChildAt(i) as ImageView
                if (i == position) {
                    imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.indicator_active_background
                        )
                    )
                } else {
                    imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.indicator_inactive_background
                        )
                    )
                }
            }
        }
    }
//
//
//  }
//        Text(text = "Hola")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview(){
//    SecondScreen()
//}
