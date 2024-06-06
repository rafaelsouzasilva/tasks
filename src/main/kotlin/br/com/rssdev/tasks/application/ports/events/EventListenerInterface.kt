package br.com.rssdev.tasks.application.ports.events

import br.com.rssdev.tasks.core.events.Event

interface EventListenerInterface<T : Event> {
    fun <T : Event> consume(event: T)

    fun <T : Event> process(event: T) {
        if (isEventValid(event).not()) return

        consume(event)
    }

    fun <T : Event> isEventValid(event: T): Boolean
}
