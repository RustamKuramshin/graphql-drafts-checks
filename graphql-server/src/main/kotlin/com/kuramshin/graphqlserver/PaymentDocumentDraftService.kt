package com.kuramshin.graphqlserver

interface PaymentDocumentDraftService {
    fun findAllDrafts(count: Int): MutableList<Draft>?
    fun findDraftById(id: Int): Draft?
}