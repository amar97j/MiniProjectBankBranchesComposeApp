package com.joincoded.bankbranchescomposeapp.repo

import com.joincoded.bankbranchescomposeapp.model.BankBranchInformation
import com.joincoded.bankbranchescomposeapp.model.BranchType
import com.joincoded.bankbranchescomposeapp.R

object DummyDataRepository {
    val dummyBranches: List<BankBranchInformation> by lazy {
        initializeDummyBranches()
    }

    private fun initializeDummyBranches(): List<BankBranchInformation> {
        return listOf(
            BankBranchInformation(
                id = 1,
                name = "FAIHA ",
                type = BranchType.VIPBRANCH,
                address = "Soor Street",
                phone = "222-456-3424",
                hours = "Mon-Fri: 9 AM - 5 PM",
                location = "https://maps.app.goo.gl/AinqjALWMf8ZyM3X9?g_st=ic",
                imageURI = R.drawable.kfh_default
            ),
            BankBranchInformation(
                id = 2,
                name = "Crystal",
                type = BranchType.KFHBRANCH,
                address = "456 Oak St",
                phone = "987-654-3210",
                hours = "Mon-Fri: 10 AM - 6 PM",
                location = "https://maps.app.goo.gl/MQvQeq4RhydcRmBZA?g_st=ic",
                imageURI = R.drawable.kfh_default
            ),
            BankBranchInformation(
                id = 3,
                name = "CODED",
                type = BranchType.VIPBRANCH,
                address = "21 street ",
                phone = "112-654-3210",
                hours = "Mon-Fri: 10 AM - 6 PM",
                location = "https://maps.app.goo.gl/ykyWCetNLuEy9dmJ9?g_st=ic",
                imageURI = R.drawable.kfh_default
            )

        )
    }
}
