package com.example.neo4jlistcontainstest

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node

@Node
data class TestNode(
    @Id
    @GeneratedValue
    val id: Long,

    val description: String,
    val items: List<String>,
)
