package com.example.contatos.presentation
import com.example.contatos.application.command.*
import com.example.contatos.application.query.*
import com.example.contatos.domain.model.Contact
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/contacts")
class ContactController(
    private val createContactHandler: CreateContactCommandHandler,
    private val updateContactHandler: UpdateContactCommandHandler,
    private val deleteContactHandler: DeleteContactCommandHandler,
    private val getContactHandler: GetContactQueryHandler,
    private val listContactsHandler: ListContactsQueryHandler
) {

    @PostMapping
    fun createContact(@RequestBody command: CreateContactCommand): ResponseEntity<Contact> {
        val createdContact = createContactHandler.handle(command)
        return ResponseEntity.ok(createdContact)
    }

    @GetMapping("/{id}")
    fun getContact(@PathVariable id: Long): ResponseEntity<Contact> {
        val contact = getContactHandler.handle(GetContactQuery(id)) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(contact)
    }

    @GetMapping
    fun listContacts(): ResponseEntity<List<Contact>> {
        val contacts = listContactsHandler.handle(ListContactsQuery())
        return ResponseEntity.ok(contacts)
    }

    @PutMapping("/{id}")
    fun updateContact(
        @PathVariable id: Long,
        @RequestBody command: UpdateContactCommand
    ): ResponseEntity<Contact> {
        if (getContactHandler.handle(GetContactQuery(id)) == null) {
            return ResponseEntity.notFound().build()
        }
        val updatedContact = updateContactHandler.handle(command.copy(id = id))
        return ResponseEntity.ok(updatedContact)
    }

    @DeleteMapping("/{id}")
    fun deleteContact(@PathVariable id: Long): ResponseEntity<Void> {
        if (getContactHandler.handle(GetContactQuery(id)) == null) {
            return ResponseEntity.notFound().build()
        }
        deleteContactHandler.handle(DeleteContactCommand(id))
        return ResponseEntity.noContent().build()
    }
}