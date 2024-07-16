package com.example.contatos.infrastructure.persistence


import jakarta.persistence.*

@Entity
@Table(name = "contacts")
data class ContactEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val email: String,
    val phone: String
)