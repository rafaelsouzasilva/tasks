package br.com.rssdev.tasks.application.services

import br.com.rssdev.tasks.application.ports.events.EventPublisherInterface
import br.com.rssdev.tasks.application.ports.repositories.TaskRepositoryInterface
import br.com.rssdev.tasks.core.models.Task
import br.com.rssdev.tasks.application.ports.services.TaskServiceInterface
import br.com.rssdev.tasks.core.events.TaskCreatedEvent
import br.com.rssdev.tasks.core.events.TaskUpdatedEvent
import br.com.rssdev.tasks.core.models.TaskStatus
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID

@Service
class TaskService(
    private val repository: TaskRepositoryInterface,
    private val publisher: EventPublisherInterface
): TaskServiceInterface {

    override fun create(task: Task): Task =
        repository.create(task).also { publisher.publish(TaskCreatedEvent(payload = it)) }

    override fun find(id: UUID): Task? = repository.findById(id)

    override fun findAll(): List<Task> = repository.findAll()

    override fun findAllByCategoryId(categoryId: UUID): List<Task> = repository.findAllByCategoryId(categoryId)

    override fun findAllPendingTasksWithCloseTimeReached(): List<Task> =
        repository.findAllByStatusAndDueTime(TaskStatus.PENDING, LocalDateTime.now().plusMinutes(5))

    override fun delete(id: UUID) = repository.deleteById(id)

    override fun update(task: Task): Task =
        repository.update(task).also { publisher.publish(TaskUpdatedEvent(payload = it)) }

}