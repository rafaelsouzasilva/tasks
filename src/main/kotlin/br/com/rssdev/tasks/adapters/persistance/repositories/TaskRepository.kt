package br.com.rssdev.tasks.adapters.persistance.repositories

import br.com.rssdev.tasks.adapters.persistance.entities.TaskEntity
import br.com.rssdev.tasks.core.models.TaskStatus
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.UUID

@Repository
interface TaskRepository : CrudRepository<TaskEntity, UUID> {
    fun findAllByCategoryId(categoryId: UUID): List<TaskEntity>
    fun findAllByStatusAndDueDateBetween(
        taskStatus: TaskStatus,
        startDateTime: LocalDateTime,
        endDateTime: LocalDateTime
    ): List<TaskEntity>
}
