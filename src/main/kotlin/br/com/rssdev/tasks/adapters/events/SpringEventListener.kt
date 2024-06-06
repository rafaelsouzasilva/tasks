package br.com.rssdev.tasks.adapters.events

import br.com.rssdev.tasks.application.ports.events.EventListenerInterface
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class SpringEventListener(
    private val listeners: List<EventListenerInterface<*>>
) : ApplicationListener<GenericSpringEvent> {
    override fun onApplicationEvent(event: GenericSpringEvent) {
        listeners.forEach { listener -> listener.process(event.getDomainEvent()) }
    }
}
