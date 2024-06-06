package br.com.rssdev.tasks.adapters.persistance.repositories

import br.com.rssdev.tasks.adapters.persistance.entities.TaskEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface TaskRepository : CrudRepository<TaskEntity, UUID>