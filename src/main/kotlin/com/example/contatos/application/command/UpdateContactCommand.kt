package com.example.contatos.application.command

data class UpdateContactCommand(val id: Long, val name: String, val email: String, val phone: String)
