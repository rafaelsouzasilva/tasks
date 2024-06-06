package br.com.rssdev.tasks.application.services

import br.com.rssdev.tasks.application.ports.events.EventPublisherInterface
import br.com.rssdev.tasks.application.ports.repositories.TaskRepositoryInterface
import br.com.rssdev.tasks.application.services.helper.StubTaskRepository
import br.com.rssdev.tasks.application.services.helper.TaskBuilder
import br.com.rssdev.tasks.core.events.TaskCreatedEvent
import br.com.rssdev.tasks.core.models.Task
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import java.util.UUID

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
        val task1 = TaskBuilder().withId(id = UUID.randomUUID()).build()
        val task2 = TaskBuilder().withId(id = UUID.randomUUID()).build()
        val tasks = mutableListOf(task1, task2)
        val repository: TaskRepositoryInterface = StubTaskRepository(tasks)
        val publisher = mockk<EventPublisherInterface>(relaxed = true)

        val result = TaskService(repository, publisher).findAll()

        assertEquals(result, tasks)
    }

    @Test
    fun `returns found task when find by id and it exists`() {
        val task1 = TaskBuilder().withId(id = UUID.randomUUID()).build()
        val task2 = TaskBuilder().withId(id = UUID.randomUUID()).build()
        val tasks = mutableListOf(task1, task2)
        val repository: TaskRepositoryInterface = StubTaskRepository(tasks)
        val publisher = mockk<EventPublisherInterface>(relaxed = true)
        val taskId = task1.id

        val result = TaskService(repository, publisher).find(taskId)

        assertEquals(result, task1)
    }

    @Test
    fun `returns null when find by id and it does not exists`() {
        val task1 = TaskBuilder().withId(id = UUID.randomUUID()).build()
        val task2 = TaskBuilder().withId(id = UUID.randomUUID()).build()
        val tasks = mutableListOf(task1, task2)
        val repository: TaskRepositoryInterface = StubTaskRepository(tasks)
        val publisher = mockk<EventPublisherInterface>(relaxed = true)
        val taskId = UUID.randomUUID()

        val result = TaskService(repository, publisher).find(taskId)

        assertNull(result)
    }

    @Test
    fun `removes task from saved tasks when deleting task`() {
        val task1 = TaskBuilder().withId(id = UUID.randomUUID()).build()
        val task2 = TaskBuilder().withId(id = UUID.randomUUID()).build()
        val tasks = mutableListOf(task1, task2)
        val repository: TaskRepositoryInterface = StubTaskRepository(tasks)
        val publisher = mockk<EventPublisherInterface>(relaxed = true)
        val taskId = task1.id

        val subject = TaskService(repository, publisher)
        subject.delete(taskId)
        val result = subject.findAll()

        val expected = tasks.filter { it.id != taskId }
        assertEquals(result, expected)
    }
}