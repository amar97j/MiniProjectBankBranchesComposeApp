package com.joincoded.bankbranchescomposeapp.model

data class BankBranchInformation (

    val id: Int,
    val name: String,
    val type: BranchType,
    val address: String,
    val phone: String,
    val hours: String,
    val location: String,//GOOGLE MAPS LINK
    val imageURI: Int

)
