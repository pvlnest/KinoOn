package com.pvl.nest.kinoon.base.nav

import androidx.appcompat.app.AppCompatActivity
import com.pvl.nest.kinoon.R
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivityNavigator(activity: AppCompatActivity) : AppNavigator(
    activity = activity,
    containerId = R.layout.activity_main
)