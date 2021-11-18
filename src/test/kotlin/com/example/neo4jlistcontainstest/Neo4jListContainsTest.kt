package com.example.neo4jlistcontainstest

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.neo4j.harness.Neo4j
import org.neo4j.harness.Neo4jBuilders
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@SpringBootTest
class Neo4jListContainsTest {

    @Autowired
    private lateinit var testNodeRepository: TestNodeRepository

    @Test
    fun `Should find test node by items containing`() {
        val testNode = testNodeRepository.findByItemsContains("item 2")
        assertNotNull(testNode)
    }

    @Test
    fun `Should find test node by using explicit query`() {
        val testNode = testNodeRepository.findByItemsContainsWithExplicitQuery("item 2")
        assertNotNull(testNode)
    }

    @Test
    fun `Should find test node by description in`() {
        val testNode = testNodeRepository.findByDescriptionIn(listOf("desc 1", "desc 2", "desc 3"))
        assertNotNull(testNode)
    }

    @TestConfiguration
    class Neo4jTestHarnessConfig {

        @Bean
        fun neo4j(): Neo4j = Neo4jBuilders.newInProcessBuilder()
            .withDisabledServer()
            .withFixture("CREATE (testNode:TestNode{id: 1, items: ['item 1', 'item 2', 'item 3'], description: 'desc 1'})")
            .build()
    }
}
