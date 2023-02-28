package io.gers.library.application.controllers.author

import io.gers.library.application.controllers.author.dto.AuthorResponse
import io.gers.library.application.controllers.author.dto.PageAuthorResponse
import io.gers.library.domain.author.SearchAuthor
import jakarta.servlet.http.HttpServletResponse
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/authors")
class ListAuthorsController(
    private val searchAuthor: SearchAuthor
) {

    @GetMapping
    fun findAll(
        @RequestParam(value = "page", defaultValue = "1") page: Int,
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        builder: UriComponentsBuilder,
        response: HttpServletResponse
    ): ResponseEntity<PageAuthorResponse> {
        val page = searchAuthor.searchAllAuthors(Pageable.ofSize(size))
        val authors = page.content.map { AuthorResponse(it.id, it.name) }
        return ResponseEntity.ok(PageAuthorResponse(totalPages = page.totalPages, size = page.size, authors = authors))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") id: Long): ResponseEntity<AuthorResponse> {
        val author = searchAuthor.searchById(id)
        return ResponseEntity.ok(AuthorResponse(author.id, author.name))
    }

}