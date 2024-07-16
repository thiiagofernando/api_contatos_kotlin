package com.example.contatos.application.query

import com.example.contatos.domain.model.Contact
import com.example.contatos.domain.repository.ContactRepository
import org.springframework.stereotype.Service

@Service
class ListContactsQueryHandler(private val repository: ContactRepository) {
    fun handle(query: ListContactsQuery): List<Contact> {
        return repository.findAll()
    }
}