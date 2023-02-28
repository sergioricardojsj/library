package io.gers.library.infrastructure.exception

class ObjectNotFoundException(override val message: String) : RuntimeException(message) {
}