package br.com.rssdev.tasks.application.services

import br.com.rssdev.tasks.application.ports.repositories.TaskRepositoryInterface
import br.com.rssdev.tasks.core.models.Task
import br.com.rssdev.tasks.application.ports.services.TaskServiceInterface
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TaskService(private val repository: TaskRepositoryInterface): TaskServiceInterface {
    override fun create(task: Task): Task = repository.create(task)

    override fun find(id: UUID): Task? = repository.findById(id)

    override fun findAll(): List<Task> = repository.findAll()

    override fun findAllByCategoryId(categoryId: UUID): List<Task> = repository.findAllByCategoryId(categoryId)

    override fun delete(id: UUID) = repository.deleteById(id)

    override fun update(task: Task): Task = repository.update(task)
}