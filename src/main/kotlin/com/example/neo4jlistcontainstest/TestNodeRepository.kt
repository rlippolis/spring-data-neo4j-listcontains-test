package com.example.neo4jlistcontainstest

import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.neo4j.repository.query.Query

interface TestNodeRepository: Neo4jRepository<TestNode, Long> {

    fun findByItemsContains(item: String): TestNode?

    @Query("""MATCH (t:TestNode) WHERE ${"$"}item IN t.items RETURN t""")
    fun findByItemsContainsWithExplicitQuery(item: String): TestNode?

    fun findByDescriptionIn(descriptions: List<String>): TestNode?
}
