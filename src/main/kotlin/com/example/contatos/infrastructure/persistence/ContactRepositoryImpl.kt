package com.example.contatos.infrastructure.persistence

import com.example.contatos.domain.model.Contact
import com.example.contatos.domain.repository.ContactRepository
import org.springframework.stereotype.Repository

@Repository
class ContactRepositoryImpl(
    private val jpaRepository: ContactJpaRepository
) : ContactRepository {

    override fun save(contact: Contact): Contact {
        val entity = ContactEntity(
            id = contact.id,
            name = contact.name,
            email = contact.email,
            phone = contact.phone
        )
        val savedEntity = jpaRepository.save(entity)
        return Contact(
            id = savedEntity.id,
            name = savedEntity.name,
            email = savedEntity.email,
            phone = savedEntity.phone
        )
    }

    override fun findById(id: Long): Contact? {
        val entity = jpaRepository.findById(id).orElse(null)
        return entity?.let {
            Contact(
                id = it.id,
                name = it.name,
                email = it.email,
                phone = it.phone
            )
        }
    }

    override fun findAll(): List<Contact> {
        return jpaRepository.findAll().map {
            Contact(
                id = it.id,
                name = it.name,
                email = it.email,
                phone = it.phone
            )
        }
    }

    override fun deleteById(id: Long) {
        jpaRepository.deleteById(id)
    }
}