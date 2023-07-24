package com.example.springbootkotlinmavengraphql

import com.example.springbootkotlinmavengraphql.schemagenerate.BookMutation
import com.example.springbootkotlinmavengraphql.schemagenerate.BookQuery
import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.extensions.print
import com.expediagroup.graphql.generator.toSchema
import graphql.schema.GraphQLSchema
import java.nio.file.Paths
import java.util.function.Predicate

fun generateSdl(schema: GraphQLSchema): String = schema.print(
	includeDirectivesFilter = Predicate {
		true
	}
)

fun main(args: Array<String>) {
	val widgetQuery = BookQuery()
	val widgetMutation = BookMutation()
	val basePackages = listOf(
		"com.example.springbootkotlinmavengraphql",
	)
	val schema = toSchema(
		config = SchemaGeneratorConfig(
			supportedPackages = basePackages
		),
		queries = listOf(TopLevelObject(widgetQuery)),
		mutations = listOf(TopLevelObject(widgetMutation))
	)

	val sdl = generateSdl(schema)


	print(sdl.toString())
	Paths.get("./src/main/resources/graphql", "schema.graphqls").toFile().writeText(sdl)
}
