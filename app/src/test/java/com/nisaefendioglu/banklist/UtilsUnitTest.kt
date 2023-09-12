package com.nisaefendioglu.banklist

import com.nisaefendioglu.banklist.utils.setTextViewText
import org.junit.Assert.assertEquals
import org.junit.Test

class UtilsUnitTest {

    @Test
    fun `setTextViewText function should return value if not null or empty`() {
        val value = "Test Value"
        val infoNotAvailable = "No Information \uD83D\uDEAB"

        val result = setTextViewText(value, infoNotAvailable)
        assertEquals(result, value)
    }

    @Test
    fun `setTextViewText function should return default value if value is null or empty`() {
        val value: String? = null
        val infoNotAvailable = "No Information \uD83D\uDEAB"

        val result = setTextViewText(value, infoNotAvailable)

        assertEquals(result, infoNotAvailable)
    }
}
