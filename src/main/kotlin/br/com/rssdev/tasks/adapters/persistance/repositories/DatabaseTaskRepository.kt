package br.com.rssdev.tasks.adapters.persistance.repositories

import br.com.rssdev.tasks.adapters.persistance.entities.TaskEntity
import br.com.rssdev.tasks.core.models.Task
import br.com.rssdev.tasks.application.ports.repositories.TaskRepositoryInterface
import br.com.rssdev.tasks.core.models.TaskStatus
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.UUID

@Repository
class DatabaseTaskRepository(private val repository: TaskRepository) : TaskRepositoryInterface {

    override fun findById(id: UUID): Task? =
        repository.findById(id).map(TaskEntity::toDomain).orElse(null)

    override fun findAll(): List<Task> = repository.findAll().map { it.toDomain() }

    override fun findAllByCategoryId(categoryId: UUID): List<Task> =
        repository.findAllByCategoryId(categoryId).map { it.toDomain() }

    override fun create(task: Task): Task = save(task)

    override fun update(task: Task): Task = save(task)

    override fun deleteById(id: UUID) = repository.deleteById(id)

    override fun findAllByStatusAndDueTime(status: TaskStatus, dueDateTime: LocalDateTime): List<Task> =
        repository.findAllByStatusAndDueDateBetween(status, LocalDateTime.now(), dueDateTime).map { it.toDomain() }

    private fun save(task: Task) =
        TaskEntity.fromDomain(task).let { entity ->
            repository.save(entity)
        }.toDomain()
}
