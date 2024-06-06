package br.com.rssdev.tasks.adapters.persistance.repositories

import br.com.rssdev.tasks.application.ports.repositories.CategoryRepositoryInterface
import br.com.rssdev.tasks.core.models.Category
import java.util.UUID

class DatabaseCategoryRepository : CategoryRepositoryInterface {
    override fun findById(id: UUID): Category? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Category> {
        TODO("Not yet implemented")
    }

    override fun create(task: Category): Category {
        TODO("Not yet implemented")
    }

    override fun update(task: Category): Category {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }
}