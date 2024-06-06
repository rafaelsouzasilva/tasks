package br.com.rssdev.tasks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class TasksApplication

fun main(args: Array<String>) {
	runApplication<TasksApplication>(*args)
}
