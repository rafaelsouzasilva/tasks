package br.com.rssdev.tasks.application.ports.repositories

import br.com.rssdev.tasks.core.models.Category
import java.util.UUID

interface CategoryRepositoryInterface {
    fun findById(id: UUID): Category?
    fun findAll(): List<Category>
    fun create(category: Category): Category
    fun update(category: Category): Category
    fun deleteById(id: UUID)
}