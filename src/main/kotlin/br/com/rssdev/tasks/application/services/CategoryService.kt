package br.com.rssdev.tasks.application.services

import br.com.rssdev.tasks.application.ports.repositories.CategoryRepositoryInterface
import br.com.rssdev.tasks.core.models.Category
import br.com.rssdev.tasks.application.ports.services.CategoryServiceInterface
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CategoryService(private val repository: CategoryRepositoryInterface) : CategoryServiceInterface {
    override fun findAll(): List<Category> = repository.findAll()

    override fun find(id: UUID): Category? = repository.findById(id)

    override fun create(category: Category): Category = repository.create(category)

    override fun update(category: Category): Category = repository.update(category)

    override fun delete(id: UUID) = repository.deleteById(id)
}
