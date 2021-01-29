package com.kuramshin.drafts

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "drafts", path = "drafts")
interface DraftRepository: PagingAndSortingRepository<Draft, Long> {
    fun findByPayeeAccount(@Param("payeeAccount") payeeAccount: String): List<Draft>
}