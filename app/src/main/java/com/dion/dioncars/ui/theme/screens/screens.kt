package com.dion.dioncars.ui.theme.screens

sealed class Screens (val screen: String){
    data object HomeScreen: Screens("home")
    data object About: Screens("about")
    data object Settings: Screens("settings")
    data object Profile: Screens("profile")
    data object Contact: Screens("contact")
    data object Search: Screens("search")
    data object Services: Screens("services")

}