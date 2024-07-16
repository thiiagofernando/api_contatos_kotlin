package com.example.contatos.application.command

import com.example.contatos.domain.model.Contact
import com.example.contatos.domain.repository.ContactRepository
import org.springframework.stereotype.Service

@Service
class CreateContactCommandHandler(private val repository: ContactRepository) {
    fun handle(command: CreateContactCommand): Contact {
        val contact = Contact(name = command.name, email = command.email, phone = command.phone)
        return repository.save(contact)
    }
}