package com.example.springbootkotlinmavengraphql.schemagenerate

import graphql.schema.DataFetchingEnvironment

class BookQuery {
    fun bookById(id: String, environment: DataFetchingEnvironment): Book? {
        return null
    }
}