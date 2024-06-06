package br.com.rssdev.tasks.adapters.events

import br.com.rssdev.tasks.core.events.Event
import org.springframework.context.ApplicationEvent

class GenericSpringEvent(private val domainEvent: Event) : ApplicationEvent(domainEvent) {
    fun getDomainEvent(): Event = domainEvent
}
