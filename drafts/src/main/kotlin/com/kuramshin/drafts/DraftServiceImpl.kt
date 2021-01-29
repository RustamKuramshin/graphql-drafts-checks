package com.kuramshin.drafts

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class DraftServiceImpl : DraftService {

    @Autowired
    private lateinit var draftRepository: DraftRepository

    override fun findAllDrafts(): DraftList {
        val draftList = DraftList(mutableListOf())
        draftRepository.findAll().forEach { draftList.drafts.add(it) }
        return draftList
    }

    override fun findDraftById(id: Long): Optional<Draft> {
        return draftRepository.findById(id)
    }

    override fun createDraft(draft: Draft): Draft {
        return draftRepository.save(draft)
    }

    override fun updateDraft(draft: Draft): Draft {
        return draftRepository.save(draft)
    }

    override fun deleteDraft(id: Long) {
        draftRepository.deleteById(id)
    }
}