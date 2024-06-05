package br.com.rssdev.tasks.ports.services

import br.com.rssdev.tasks.core.models.Task
import java.util.UUID

interface TaskServiceInterface {
    fun create(task: Task): Task
    fun find(id: UUID): Task?
    fun findAll(): List<Task>
    fun findAllByCategoryId(id: UUID): List<Task>
    fun delete(id: UUID)
    fun update(task: Task): Task
}