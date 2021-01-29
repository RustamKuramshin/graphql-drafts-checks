package com.kuramshin.checks

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ChecksController {

    @Autowired
    private lateinit var checksService: ChecksService

    @PostMapping(path = ["/checks/draft"])
    fun createCheckDraft(@RequestBody draft: Draft): ChecksResp {
        return checksService.checkDraft(draft)
    }

    @PostMapping(path = ["/checks/field"])
    fun createCheckField(@RequestBody field: Field): CheckFieldRes {
        return checksService.checkField(field)
    }
}