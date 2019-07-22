package com.bakan.circlecitest

import org.junit.Assert
import org.junit.Test

class HelloProcessorTest {

    private val sut = HelloProcessor()

    @Test
    fun sayHello_emptyName_returnNull() {
        val result = sut.sayHello("")
        Assert.assertEquals(null, result)
    }

    @Test
    fun sayHello_blankName_returnNull() {
        val result = sut.sayHello("  ")
        Assert.assertEquals(null, result)
    }

    @Test
    fun sayHello_notEmptyName_returnHello() {
        val result = sut.sayHello("Sam")
        Assert.assertEquals("Hello, Sam!", result)
    }

}