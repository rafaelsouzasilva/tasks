package br.com.rssdev.tasks.adapters.persistance.repositories

import br.com.rssdev.tasks.adapters.persistance.entities.CategoryEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface CategoryRepository : CrudRepository<CategoryEntity, UUID>