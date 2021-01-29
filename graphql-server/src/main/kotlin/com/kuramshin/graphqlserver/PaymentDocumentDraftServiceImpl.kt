package com.kuramshin.graphqlserver

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.stream.Collectors

@Service
class PaymentDocumentDraftServiceImpl : PaymentDocumentDraftService {

    @Value("\${drafts.api.url}")
    private lateinit var draftsApiUrl: String

    @Autowired
    private lateinit var restTemplate: RestTemplate

    override fun findAllDrafts(count: Int): MutableList<Draft>? {
        return restTemplate.getForObject("$draftsApiUrl/drafts", DraftList::class.java)
            ?.drafts
            ?.stream()
            ?.limit(count.toLong())
            ?.collect(
                Collectors.toList()
            )
    }

    override fun findDraftById(id: Int): Draft? {
        return restTemplate.getForObject("$draftsApiUrl/drafts/$id", Draft::class.java)
    }
}