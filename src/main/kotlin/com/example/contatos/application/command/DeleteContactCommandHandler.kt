package com.example.contatos.application.command


import com.example.contatos.domain.repository.ContactRepository
import org.springframework.stereotype.Service

@Service
class DeleteContactCommandHandler(private val repository: ContactRepository) {
    fun handle(command: DeleteContactCommand) {
        repository.deleteById(command.id)
    }
}