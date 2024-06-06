package br.com.rssdev.tasks.application.services

import br.com.rssdev.tasks.application.ports.events.EventPublisherInterface
import br.com.rssdev.tasks.application.ports.repositories.TaskRepositoryInterface
import br.com.rssdev.tasks.application.services.helper.StubTaskRepository
import br.com.rssdev.tasks.core.events.TaskCreatedEvent
import br.com.rssdev.tasks.core.models.Task
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TaskServiceTest {
    @Test
    fun `calls repository to save and publishes event when creating task`() {
        val repository = mockk<TaskRepositoryInterface>(relaxed = true)
        val publisher = mockk<EventPublisherInterface>(relaxed = true)
        val task = mockk<Task>()
        val event = TaskCreatedEvent(payload = task)
        every { repository.create(task) } returns task

        TaskService(repository, publisher).create(task)

        verify { repository.create(task) }
        verify { publisher.publish(event) }
    }

    @Test
    fun `returns found tasks when find all tasks`() {
        val task = mockk<Task>()
        val tasks = listOf(task, task)
        val repository: TaskRepositoryInterface = StubTaskRepository(tasks)
        val publisher = mockk<EventPublisherInterface>(relaxed = true)

        val result = TaskService(repository, publisher).findAll()

        assertEquals(result, tasks)
    }
}