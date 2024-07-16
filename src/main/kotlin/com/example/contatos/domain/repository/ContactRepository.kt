package com.example.contatos.domain.repository

import com.example.contatos.domain.model.Contact

interface ContactRepository {
    fun save(contact: Contact): Contact
    fun findById(id: Long): Contact?
    fun findAll(): List<Contact>
    fun deleteById(id: Long)
}