package com.dion.dioncars.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.dion.dioncars.models.User
import com.dion.dioncars.navigation.ROUTE_HOME
import com.dion.dioncars.navigation.ROUTE_LOGIN
import com.dion.dioncars.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class AuthViewModel(var navController: NavHostController, var context: Context) {
    val mAuth:FirebaseAuth
    val progress: ProgressDialog

    init {
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    //SIGN UP CODE

    fun signup(name:String, email:String, pass:String){
        progress.show()
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
            var userId = mAuth.currentUser!!.uid
            var userProfile = User(name, email, pass, userId)
            // Create a reference table called Users inside of the Firebase database
            var usersRef = FirebaseDatabase.getInstance().getReference()
                .child("Users/$userId")
            usersRef.setValue(userProfile).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful){
                    Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                    navController.navigate(ROUTE_LOGIN)
                }else{
                    Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //LOGIN CODE

    fun login(email: String, password: String){
        progress.show()
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                navController.navigate(ROUTE_HOME)
            }else{
                Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }


//SIGN OUT CODE

    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }

    fun isLoggedIn(): Boolean = mAuth.currentUser != null
}