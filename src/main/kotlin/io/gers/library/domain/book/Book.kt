package io.gers.library.domain.book

import io.gers.library.domain.author.Author
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val title: String,
    val pages: Int,
    val chapters: Int
) {
    @OneToMany
    lateinit var authors: List<Author>
}
