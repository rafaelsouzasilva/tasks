package br.com.rssdev.tasks.domain.repositories

import br.com.rssdev.tasks.domain.model.User
import java.util.UUID

interface UserRepositoryInterface {
    fun findById(id: UUID): User?
    fun findAll(): List<User>
    fun create(task: User): User
    fun update(task: User): User
    fun deleteById(id: UUID)
}