package com.kuramshin.drafts

import java.util.*

interface DraftService {
    fun findAllDrafts(): DraftList
    fun findDraftById(id: Long): Optional<Draft>
    fun createDraft(draft: Draft): Draft
    fun updateDraft(draft: Draft): Draft
    fun deleteDraft(id: Long)
}