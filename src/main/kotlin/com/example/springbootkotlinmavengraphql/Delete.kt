package com.example.springbootkotlinmavengraphql

import com.example.springbootkotlinmavengraphql.schemagenerate.BookQuery
import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.extensions.print
import com.expediagroup.graphql.generator.federation.FederatedSchemaGeneratorConfig
import com.expediagroup.graphql.generator.federation.FederatedSchemaGeneratorHooks
import com.expediagroup.graphql.generator.federation.toFederatedSchema
import graphql.schema.GraphQLSchema
import java.nio.file.Paths
import java.util.function.Predicate

fun generateSdl1(schema: GraphQLSchema): String = schema.print(
	includeDirectivesFilter = Predicate {
		true
	}
)

fun main(args: Array<String>) {
	val basePackages = listOf(
		"com.example.springbootkotlinmavengraphql",
	)

	// Resolve a "Product" type from the _entities query

	// Generate the schema
	val resolvers = listOf(ProductResolver())
	val hooks = FederatedSchemaGeneratorHooks(resolvers)
	val config = FederatedSchemaGeneratorConfig(supportedPackages = basePackages, hooks = hooks)
	val queries = listOf(TopLevelObject(BookQuery()))

	val schema = toFederatedSchema(config, queries)


	val sdl = generateSdl1(schema)


	print(sdl.toString())
	Paths.get("./src/main/resources/graphql", "schema.graphqls").toFile().writeText(sdl)
}
