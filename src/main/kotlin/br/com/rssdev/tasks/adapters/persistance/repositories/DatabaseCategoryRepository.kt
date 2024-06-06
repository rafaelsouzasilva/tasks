package br.com.rssdev.tasks.adapters.persistance.repositories

import br.com.rssdev.tasks.adapters.persistance.entities.CategoryEntity
import br.com.rssdev.tasks.application.ports.repositories.CategoryRepositoryInterface
import br.com.rssdev.tasks.core.models.Category
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class DatabaseCategoryRepository(private val repository: CategoryRepository) : CategoryRepositoryInterface {

    override fun findById(id: UUID): Category? =
        repository.findById(id).map(CategoryEntity::toDomain).orElse(null)

    override fun findAll(): List<Category> = repository.findAll().map { it.toDomain() }

    override fun create(category: Category): Category = save(category)

    override fun update(category: Category): Category = save(category)

    override fun deleteById(id: UUID) = repository.deleteById(id)

    private fun save(category: Category) =
        CategoryEntity.fromDomain(category).let { entity ->
            repository.save(entity)
        }.toDomain()
}