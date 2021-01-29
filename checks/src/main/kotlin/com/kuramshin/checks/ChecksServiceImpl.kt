package com.kuramshin.checks

import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ChecksServiceImpl : ChecksService {

    override fun checkDraft(draft: Draft): ChecksResp {

        val checksResp = ChecksResp(mutableListOf())

        checksResp.res.add(checkField(Field("payeeAccount", draft.payeeAccount)))
        checksResp.res.add(checkField(Field("payerAccount", draft.payerAccount)))
        checksResp.res.add(checkField(Field("sum", draft.sum)))

        return checksResp
    }

    override fun checkField(field: Field): CheckFieldRes {

        val unknownErr = CheckFieldRes(field.fieldName, "Неизвестная ошибка")

        return when (field.fieldName) {
            "payeeAccount", "payerAccount" -> when (field.fieldValue) {
                is String -> when (field.fieldValue.length) {
                    20 -> CheckFieldRes(field.fieldName, "OK")
                    else -> CheckFieldRes(field.fieldName, "Банковский счет должен содержать 20 символов")
                }
                else -> unknownErr
            }

            "sum" -> when (field.fieldValue) {
                is BigDecimal -> when (field.fieldValue >= BigDecimal.ZERO) {
                    true -> CheckFieldRes(field.fieldName, "OK")
                    else -> CheckFieldRes(field.fieldName, "Сумма документа не может быть меньше нуля")
                }
                else -> unknownErr
            }
            else -> unknownErr
        }
    }
}