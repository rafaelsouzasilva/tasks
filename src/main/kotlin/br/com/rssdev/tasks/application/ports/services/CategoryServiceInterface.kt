package br.com.rssdev.tasks.application.ports.services

import br.com.rssdev.tasks.core.models.Category
import java.util.UUID

interface CategoryServiceInterface {
    fun findAll(): List<Category>
    fun findById(id: UUID): Category?
    fun create(category: Category): Category
    fun update(category: Category): Category
    fun deleteById(id: UUID)
}