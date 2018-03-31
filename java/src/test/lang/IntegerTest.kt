package lang

import org.junit.Assert.assertEquals
import org.junit.Test


class IntegerTest {

    @Test
    fun `to binary string`() {
        assertEquals("101", 5.toBinaryString())
        assertEquals("110010", 50.toBinaryString())
        assertEquals("10001100101000", 9000.toBinaryString())
    }

}
