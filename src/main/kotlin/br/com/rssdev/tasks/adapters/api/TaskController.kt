package br.com.rssdev.tasks.adapters.api

import br.com.rssdev.tasks.application.ports.services.TaskServiceInterface
import br.com.rssdev.tasks.core.models.Task
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.UUID

@RestController
@RequestMapping("/tasks")
class TaskController(private val service: TaskServiceInterface) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun list(): List<Task> = service.findAll()

    @GetMapping("/{id}")
    fun find(@PathVariable("id") id: UUID): ResponseEntity<Task> =
        service.find(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody category: Task): Task = service.create(category)

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable("id") id: UUID, @RequestBody category: Task): Task =
        service.update(category.copy(id = id))

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable("id") id: UUID) = service.delete(id)

}