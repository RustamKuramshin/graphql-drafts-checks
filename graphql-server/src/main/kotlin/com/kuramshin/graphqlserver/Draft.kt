package com.kuramshin.graphqlserver

import java.math.BigDecimal

data class Draft(
    val id: Long? = null,
    val payeeAccount: String,
    val payerAccount: String,
    val sum: BigDecimal
)