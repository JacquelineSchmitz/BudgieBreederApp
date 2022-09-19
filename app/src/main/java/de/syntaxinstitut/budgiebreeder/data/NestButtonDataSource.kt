package de.syntaxinstitut.budgiebreeder.data

import de.syntaxinstitut.budgiebreeder.data.model.NestButton

class NestButtonDataSource {
    fun loadNestButton(): List<NestButton> {
        return listOf(
            NestButton(
                1,
                "Nest 1"
            ),
            NestButton(
                2,
                "Nest 2"
            ),
            NestButton(
                3,
                "Nest 3"
            ),
            NestButton(
                4,
                "Nest 4"
            )
        )
    }
}