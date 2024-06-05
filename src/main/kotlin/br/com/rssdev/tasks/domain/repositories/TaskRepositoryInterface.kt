package br.com.rssdev.tasks.domain.repositories

import br.com.rssdev.tasks.domain.model.Task
import java.util.UUID

interface TaskRepositoryInterface {
    fun findById(id: UUID): Task?
    fun findAll(): List<Task>
    fun findAllByCategoryId(categoryId: UUID): List<Task>
    fun create(task: Task): Task
    fun update(task: Task): Task
    fun deleteById(id: UUID)
}