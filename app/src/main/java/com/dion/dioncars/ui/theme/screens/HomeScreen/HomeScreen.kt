package com.dion.dioncars.ui.theme.screens.HomeScreen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dion.dioncars.R
import com.dion.dioncars.ui.theme.DionCarsTheme
import com.dion.dioncars.ui.theme.Purple80
import com.dion.dioncars.ui.theme.screens.Contact
import com.dion.dioncars.ui.theme.screens.Profile
import com.dion.dioncars.ui.theme.screens.Screens
import com.dion.dioncars.ui.theme.screens.Search
import com.dion.dioncars.ui.theme.screens.Services
import com.dion.dioncars.ui.theme.screens.Settings
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout {
            val (redBorder) = createRefs()
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .constrainAs(redBorder) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .background(color = Color.Black)
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp, end = 10.dp, start = 10.dp)
                    .fillMaxWidth()
            )
            {
                Column(
                    modifier = Modifier
                        .height(60.dp)
                        .padding(start = 8.dp)
                        .weight(0.7f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "DionCars",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontFamily = FontFamily.Cursive
                    )

                }
                Image(painter = painterResource(id = R.drawable.person), contentDescription = null,
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .clickable {}
                )

            }
        }
        var searchText by rememberSaveable {
                mutableStateOf("")
            }

            TextField(
                value = searchText, onValueChange = { searchText = it },
                label = { Text(text = "Search cars...") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search, contentDescription = null,
                        modifier = Modifier
                            .size(38.dp)
                            .padding(end = 6.dp)
                    )
                }, shape = RoundedCornerShape(50.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedPlaceholderColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(top = 24.dp, end = 24.dp, start = 24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(50.dp))
                    .background(Color.White, CircleShape)
            )
        ConstraintLayout (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, end = 24.dp, start = 24.dp)
            .shadow(5.dp, shape = RoundedCornerShape(25.dp))
            .height(150.dp)
            .background(color = Color.DarkGray)
        ){
            val (bannerImage, flatText, freeText, couponText) = createRefs()
            Image(modifier = Modifier.constrainAs(bannerImage){
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }, painter = painterResource(id = R.drawable.bmw),
                contentDescription = null)
            Text(text = "FLAT 50% OFF",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .constrainAs(flatText) {
                        top.linkTo(parent.top)
                        end.linkTo(bannerImage.start)
                        start.linkTo(parent.start)
                    }
            )
            Text(text = "Free Insurance",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.constrainAs(freeText){
                    top.linkTo(flatText.bottom)
                    end.linkTo(flatText.end)
                    start.linkTo(flatText.start)
                })
            Text(text = "Coupon: MAZDA213",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .constrainAs(couponText) {
                        top.linkTo(freeText.bottom)
                        end.linkTo(freeText.end)
                        start.linkTo(freeText.start)
                    })

        }
        Text(text = "CATEGORIES",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Green,
            modifier = Modifier.padding(top = 16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.audi), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "Audi",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Cyan
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bmw), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "BMW",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Cyan
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.honda), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "Honda",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Cyan
                )
            }

        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lexus), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "Lexus",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Cyan
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mazda), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "Mazda",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Cyan
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mercedes),
                    contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "Mercedes",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Cyan
                )
            }

        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.nissan),
                    contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "Nissan",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Cyan
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.porsche),
                    contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "Porsche",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Cyan
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.toyota),
                    contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text(
                    text = "Toyota",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Cyan
                )
            }

        }


    }
    }
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnNavBotSheet() {
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext

    val selected = remember  {
        mutableStateOf(Icons.Default.Home)
    }
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember {
        mutableStateOf(false)
    }
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(modifier = Modifier
                    .background(Color.Cyan)
                    .fillMaxWidth()
                    .height(150.dp)){
                    Text(text = "")
                }
                Divider()
                NavigationDrawerItem(label = { Text(text = "Home", color = Color.Cyan) },
                    selected = false,
                    icon = { Image(imageVector = Icons.Default.Home, contentDescription = "home")},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.HomeScreen.screen){
                            popUpTo(0)
                        }
                    })
                NavigationDrawerItem(label = { Text(text = "Profile", color = Color.Cyan) },
                    selected = false,
                    icon = { Image(imageVector = Icons.Default.Person, contentDescription = "home")},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Profile.screen){
                            popUpTo(0)
                        }
                    })
                NavigationDrawerItem(label = { Text(text = "Settings", color = Color.Cyan) },
                    selected = false,
                    icon = { Image(imageVector = Icons.Default.Settings, contentDescription = "settings")},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Settings.screen){
                            popUpTo(0)
                        }
                    })
                NavigationDrawerItem(label = { Text(text = "Logout", color = Color.Cyan) },
                    selected = false,
                    icon = { Image(imageVector = Icons.Default.ExitToApp, contentDescription = "log out")},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context,"Logout", Toast.LENGTH_SHORT).show()

                    })
            }
        },
    ) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar(title = { Text(text = "DionCars" ) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Purple80,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White

                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                Icons.Rounded.Menu, contentDescription = "MenuButton"
                            )

                        }
                    },
                )

            },
            bottomBar = {
                BottomAppBar(containerColor = Purple80) {
                    IconButton(onClick = {
                        selected.value = Icons.Default.Home
                        navigationController.navigate(Screens.HomeScreen.screen){
                            popUpTo(0)
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(Icons.Default.Home, contentDescription = null, modifier = Modifier.size(20.dp),
                            tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray)

                    }
                    IconButton(onClick = {
                        selected.value = Icons.Default.Search
                        navigationController.navigate(Screens.Search.screen){
                            popUpTo(0)
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(20.dp),
                            tint = if (selected.value == Icons.Default.Search) Color.White else Color.DarkGray)

                    }
                    IconButton(onClick = {
                        selected.value = Icons.Default.Settings
                        navigationController.navigate(Screens.Settings.screen){
                            popUpTo(0)
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(Icons.Default.Settings, contentDescription = null, modifier = Modifier.size(20.dp),
                            tint = if (selected.value == Icons.Default.Settings) Color.White else Color.DarkGray)

                    }
                    IconButton(onClick = {
                        selected.value = Icons.Default.Person
                        navigationController.navigate(Screens.Profile.screen){
                            popUpTo(0)
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(20.dp),
                            tint = if (selected.value == Icons.Default.Search) Color.White else Color.DarkGray)

                    }
                    Box (modifier = Modifier
                        .weight(1f)
                        .padding(10.dp),
                        contentAlignment = Alignment.Center){
                        FloatingActionButton(onClick = {
                            showBottomSheet = true
                        }) {
                            Icon(Icons.Default.Add, contentDescription = null, tint = Purple80)

                        }

                    }

                }
            }

        ) {
            NavHost(navController = navigationController,
                startDestination = Screens.HomeScreen.screen ) {
                composable(Screens.HomeScreen.screen){ HomeScreen(rememberNavController()) }
                composable(Screens.Profile.screen){ Profile() }
                composable(Screens.Settings.screen){ Settings() }
                composable(Screens.Search.screen){ Search() }
                composable(Screens.Contact.screen){ Contact() }
                composable(Screens.Services.screen){ Services() }

            }

        }
        if (showBottomSheet) {
            ModalBottomSheet(onDismissRequest = { showBottomSheet = false},
                sheetState = sheetState) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    BottomSheetItem(icon = Icons.Default.ShoppingCart, title = "Add to Cart") {
                        showBottomSheet = false
                        navigationController.navigate(Screens.About.screen) {
                            popUpTo(0)
                        }

                    }
                    BottomSheetItem(icon = Icons.Default.Share, title = "Share") {
                        Toast.makeText(context,"Share", Toast.LENGTH_SHORT).show()

                    }
                    BottomSheetItem(icon = Icons.Default.LocationOn, title = "Location") {
                        Toast.makeText(context,"Location", Toast.LENGTH_SHORT).show()

                    }


                }


            }
        }

    }
}

@Composable
fun BottomSheetItem(icon: ImageVector, title: String, onClick: () -> Unit) {
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.clickable { onClick() }

    ){
        Icon(icon, contentDescription = null, tint = Purple80)
        Text(text = title, color = Purple80, fontSize = 22.sp)

    }

}




@Preview(showBackground = true)
@Composable
private fun DisplayHomeScreen() {
    DionCarsTheme {
        HomeScreen(rememberNavController())
    }
    LearnNavBotSheet()

}