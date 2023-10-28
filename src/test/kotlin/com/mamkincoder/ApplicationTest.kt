package com.mamkincoder

import com.mamkincoder.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun `Test Root Page`() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }

    @Test
    fun `Test About Page`() = testApplication {
        application {
            configureRouting()
        }
        client.get("/about").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("About page.", bodyAsText())
        }
    }
}
