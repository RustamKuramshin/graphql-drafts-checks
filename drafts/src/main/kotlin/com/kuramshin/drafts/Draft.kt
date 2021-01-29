package com.kuramshin.drafts

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Draft(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val payeeAccount: String,
    val payerAccount: String,
    val sum: BigDecimal
)
