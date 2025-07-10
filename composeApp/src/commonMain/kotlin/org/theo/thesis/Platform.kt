package org.theo.thesis

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform