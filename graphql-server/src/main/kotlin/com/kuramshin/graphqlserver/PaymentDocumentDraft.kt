package com.kuramshin.graphqlserver

data class PaymentDocumentDraft(
    val draft: Draft,
    val checksResp: ChecksResp
)
