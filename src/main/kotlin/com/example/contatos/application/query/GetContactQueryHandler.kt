package com.example.contatos.application.query

import com.example.contatos.domain.model.Contact
import com.example.contatos.domain.repository.ContactRepository
import org.springframework.stereotype.Service

@Service
class GetContactQueryHandler(private val repository: ContactRepository) {
    fun handle(query: GetContactQuery): Contact? {
        return repository.findById(query.id)
    }
}