package br.com.rssdev.tasks.core.events

import java.util.UUID

abstract class Event (val id: UUID = UUID.randomUUID(), open val name: String, open val payload: Any)
