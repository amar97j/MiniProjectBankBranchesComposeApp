package com.joincoded.bankbranchescomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joincoded.bankbranchescomposeapp.composables.BranchDetailsPage
import com.joincoded.bankbranchescomposeapp.composables.BranchListPage
import com.joincoded.bankbranchescomposeapp.repo.DummyDataRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "branchList") {
                composable("branchList") {
                    BranchListPage(
                        branchList = DummyDataRepository.dummyBranches,
                        onBranchClick = { branch ->
                            navController.navigate("branchDetails/${branch.id}")
                        }
                    )
                }
                composable("branchDetails/{branchId}") { backStackEntry ->
                    val branchId = backStackEntry.arguments?.getString("branchId")?.toIntOrNull()
                    if (branchId != null) {
                        val selectedBranch =
                            DummyDataRepository.dummyBranches.firstOrNull { it.id == branchId }
                        if (selectedBranch != null) {
                            BranchDetailsPage(
                                branch = selectedBranch,
                                onFavoriteClick = { /* handle favorite click */ }
                            )
                        } else {

                            DisplayError("The requested branch does not exist.")
                        }
                    } else {

                        DisplayError("Invalid Branch ID")
                    }
                }
            }

        }
    }

    @Composable
    fun DisplayError(errorMessage: String) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(errorMessage, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Please check the branch ID and try again.", fontSize = 16.sp)

        }
    }
}

