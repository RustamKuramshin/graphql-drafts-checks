package com.kuramshin.drafts

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/drafts")
class DraftController {
    @Autowired
    private lateinit var draftService: DraftService

    @GetMapping
    fun findAllDrafts(): DraftList {
        return draftService.findAllDrafts()
    }

    @GetMapping("/{id}")
    fun findDraftById(@PathVariable id: Long): Optional<Draft> {
        return draftService.findDraftById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createDraft(@RequestBody draft: Draft): Draft {
        return draftService.createDraft(draft)
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateDraft(@RequestBody draft: Draft): Draft {
        return draftService.updateDraft(draft)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteDraft(@PathVariable id: Long) {
        draftService.deleteDraft(id)
    }
}