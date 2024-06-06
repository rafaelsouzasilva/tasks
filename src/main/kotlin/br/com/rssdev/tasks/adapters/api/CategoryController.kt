package br.com.rssdev.tasks.adapters.api

import br.com.rssdev.tasks.adapters.api.resources.CategoryDto
import br.com.rssdev.tasks.application.ports.services.CategoryServiceInterface
import br.com.rssdev.tasks.core.models.Category
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
@RequestMapping("/categories")
class CategoryController(private val service: CategoryServiceInterface) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun list(): List<Category> = service.findAll()

    @GetMapping("/{id}")
    fun find(@PathVariable("id") id: UUID): ResponseEntity<Category> =
        service.find(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody category: CategoryDto): Category = service.create(category.toDomain())

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable("id") id: UUID, @RequestBody category: CategoryDto): Category =
        service.update(category.toDomain().copy(id = id))

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable("id") id: UUID) = service.delete(id)

}