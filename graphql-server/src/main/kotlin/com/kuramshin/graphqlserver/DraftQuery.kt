package com.kuramshin.graphqlserver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DraftQuery: GraphQLQueryResolver {

    @Autowired
    private lateinit var paymentDocumentDraftService: PaymentDocumentDraftService

    fun getDrafts(count: Int): MutableList<Draft>? {
        return paymentDocumentDraftService.findAllDrafts(count)
    }

    fun getDraft(id: Int): Draft? {
        return paymentDocumentDraftService.findDraftById(id)
    }
}