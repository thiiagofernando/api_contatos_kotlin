package com.example.contatos.infrastructure.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface ContactJpaRepository : JpaRepository<ContactEntity, Long>