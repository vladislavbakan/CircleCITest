package com.bakan.circlecitest

class HelloProcessor {

    fun sayHello(name: String?): String? {
        return if (name.isNullOrBlank()) {
            null
        } else "Hello, $name!"
    }

}