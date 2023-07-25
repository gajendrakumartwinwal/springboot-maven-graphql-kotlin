package com.example.springbootkotlinmavengraphql

import com.example.springbootkotlinmavengraphql.schemagenerate.Book
import com.example.springbootkotlinmavengraphql.schemagenerate.utils
import graphql.schema.DataFetchingEnvironment
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller


@Controller
class BookController {
    @QueryMapping
    fun bookById(@Argument id: String?, environment: DataFetchingEnvironment): Book? {
        return utils.bookById(id!!)
    }

    @SchemaMapping
    fun saveWidget(book: Book): Book? {
        return utils.saveWidget(book)
    }
}