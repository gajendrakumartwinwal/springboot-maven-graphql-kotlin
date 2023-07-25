package com.example.springbootkotlinmavengraphql

import com.example.springbootkotlinmavengraphql.schemagenerate.Book
import com.expediagroup.graphql.generator.federation.execution.FederatedTypeResolver
import graphql.schema.DataFetchingEnvironment

class ProductResolver : FederatedTypeResolver<Book> {
    override val typeName = "Book"

    override suspend fun resolve(environment: DataFetchingEnvironment, representations: List<Map<String, Any>>): List<Book?> = representations.map { keys ->
        keys["id"]?.toString()?.let { id -> Book(id, "fdas", 23, "aurhtr") }
    }
}