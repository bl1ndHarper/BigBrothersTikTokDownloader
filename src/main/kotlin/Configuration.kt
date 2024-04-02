package org.example

import java.io.FileInputStream
import java.util.Properties

object Configuration {
    private val properties = Properties()

    init {
        val configFile = "config.properties"
        properties.load(FileInputStream(configFile))
    }

    fun getProperty(key: String): String {
        return properties.getProperty(key)
    }
}