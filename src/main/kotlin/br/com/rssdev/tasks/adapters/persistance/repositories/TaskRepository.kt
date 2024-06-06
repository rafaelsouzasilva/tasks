package br.com.rssdev.tasks.adapters.persistance.repositories

import br.com.rssdev.tasks.adapters.persistance.entities.TaskEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TaskRepository : CrudRepository<TaskEntity, UUID> {
    fun findAllByCategoryId(categoryId: UUID): List<TaskEntity>
}