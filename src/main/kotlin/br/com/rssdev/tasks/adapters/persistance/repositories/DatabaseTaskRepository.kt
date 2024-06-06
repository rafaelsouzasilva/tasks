package br.com.rssdev.tasks.adapters.persistance.repositories

import br.com.rssdev.tasks.core.models.Task
import br.com.rssdev.tasks.application.ports.repositories.TaskRepositoryInterface
import java.util.UUID

class DatabaseTaskRepository : TaskRepositoryInterface {
    override fun findById(id: UUID): Task? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Task> {
        TODO("Not yet implemented")
    }

    override fun findAllByCategoryId(categoryId: UUID): List<Task> {
        TODO("Not yet implemented")
    }

    override fun create(task: Task): Task {
        TODO("Not yet implemented")
    }

    override fun update(task: Task): Task {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }
}