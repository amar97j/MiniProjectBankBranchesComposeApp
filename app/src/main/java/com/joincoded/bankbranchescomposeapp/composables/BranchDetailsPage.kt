package com.joincoded.bankbranchescomposeapp.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joincoded.bankbranchescomposeapp.model.BankBranchInformation
import com.joincoded.bankbranchescomposeapp.R


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BranchDetailsPage(
    branch: BankBranchInformation,
    onFavoriteClick: (BankBranchInformation) -> Unit
) {
    var isFavourite by remember { mutableStateOf(false) }
    var localUriHandler = LocalUriHandler.current
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = branch.name) },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },

            )
        },

        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                val imageModifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                if (branch.imageURI != 0) {
                    Image(
                        painter = painterResource(id = branch.imageURI),
                        contentDescription = null,
                        modifier = imageModifier,
                        contentScale = ContentScale.Crop
                    )
                } else {

                    Image(

                        painter = painterResource(id = R.drawable.kfh_default),
                        contentDescription = null,
                        modifier = imageModifier,
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))


                Text(text = "Address: ${branch.address}", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Phone: ${branch.phone}", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Hours: ${branch.hours}", fontSize = 16.sp)

                Spacer(modifier = Modifier.height(16.dp))

                ClickableText(text = AnnotatedString("Location" )
                ){
                    localUriHandler.openUri(branch.location)
                }

                Button(
//                    onClick = { onFavoriteClick(branch) }
                    onClick = { isFavourite =! isFavourite },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(

                    )
                ) {
                    Icon(imageVector = Icons.Default.Star, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Add to Favorites")
                }
            }
        }
    )
}
