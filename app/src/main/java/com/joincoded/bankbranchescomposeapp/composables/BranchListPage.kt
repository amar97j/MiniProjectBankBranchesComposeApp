package com.joincoded.bankbranchescomposeapp.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.joincoded.bankbranchescomposeapp.model.BankBranchInformation

@Composable
fun BranchListPage(branchList: List<BankBranchInformation>, onBranchClick: (BankBranchInformation) -> Unit) {
    LazyColumn {
        items(branchList) { branch ->
            BranchCardComposable(branch = branch, onClick = { onBranchClick(branch) })
            Divider(modifier = Modifier.padding(horizontal = 16.dp), color = Color.Gray)
        }
    }
}
