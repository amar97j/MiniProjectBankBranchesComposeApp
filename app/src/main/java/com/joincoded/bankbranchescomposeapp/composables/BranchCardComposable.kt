package com.joincoded.bankbranchescomposeapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joincoded.bankbranchescomposeapp.model.BankBranchInformation
import com.joincoded.bankbranchescomposeapp.R


@Composable
fun BranchCardComposable(branch: BankBranchInformation, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            val imageModifier = Modifier
                .height(120.dp)
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

            Text(text = branch.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = branch.address, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Type: ${branch.type.name}", fontSize = 14.sp)
        }
    }
}
