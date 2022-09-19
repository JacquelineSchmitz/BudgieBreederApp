package de.syntaxinstitut.budgiebreeder.data

import de.syntaxinstitut.budgiebreeder.data.model.BirthDate

class DataSource {
    fun loadbirthdate (): List<BirthDate>{
        return listOf(
            BirthDate(
                1,
                "HanSolo PrinzessinLea",
                21.04

                    )
        )
    }
}