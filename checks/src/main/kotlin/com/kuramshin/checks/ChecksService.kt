package com.kuramshin.checks

interface ChecksService {
    fun checkDraft(draft: Draft): ChecksResp
    fun checkField(field: Field): CheckFieldRes
}