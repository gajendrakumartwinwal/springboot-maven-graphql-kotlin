package com.example.springbootkotlinmavengraphql.schemagenerate

import java.util.*

class utils {
    companion object {
        private var books = Arrays.asList(
            Book("book-1", "Effective Java", 416, "author-1"),
            Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2"),
            Book("book-3", "Down Under", 436, "author-3")
        )

        fun bookById(id: String): Book? {
            return books.stream()
                .filter { book: Book? -> book!!.id == id }
                .findFirst()
                .orElse(null)
        }

        fun saveWidget(book : Book): Book? {
            books.add(0,book)
            return book
        }
    }
}