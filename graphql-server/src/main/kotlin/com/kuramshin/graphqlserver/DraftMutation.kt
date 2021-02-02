package com.kuramshin.graphqlserver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class DraftMutation: GraphQLMutationResolver {

    @Autowired
    private lateinit var paymentDocumentDraftService: PaymentDocumentDraftService

    fun createDraft(payeeAccount: String, payerAccount: String, sum: BigDecimal): Draft? {
        return paymentDocumentDraftService.createDraft(payeeAccount, payerAccount, sum)
    }
}