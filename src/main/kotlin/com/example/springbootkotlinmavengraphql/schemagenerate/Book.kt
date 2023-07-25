package com.example.springbootkotlinmavengraphql.schemagenerate

import com.expediagroup.graphql.generator.federation.directives.FieldSet
import com.expediagroup.graphql.generator.federation.directives.KeyDirective

@KeyDirective(fields = FieldSet("id"))
data class Book(val id: String, val name: String, val pageCount: Int, val authorId: String)