package com.kuramshin.graphqlserver

import java.math.BigDecimal

interface PaymentDocumentDraftService {
    fun findAllDrafts(count: Int): MutableList<Draft>?
    fun findDraftById(id: Int): Draft?
    fun createDraft(payeeAccount: String, payerAccount: String, sum: BigDecimal): Draft?
}