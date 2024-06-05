package br.com.rssdev.tasks.domain.repositories

import br.com.rssdev.tasks.domain.model.Category
import java.util.UUID

interface CategoryRepositoryInterface {
    fun findById(id: UUID): Category?
    fun findAll(): List<Category>
    fun create(task: Category): Category
    fun update(task: Category): Category
    fun deleteById(id: UUID)
}