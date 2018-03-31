package lang

import org.junit.Assert.assertEquals
import org.junit.Test


class DoubleTest() {

    @Test
    fun `should round down to nearest half`() {
        assertEquals(1.0, 1.2.roundDownToNearestHalf(), 0.0)
        assertEquals(1.0, 1.3.roundDownToNearestHalf(), 0.0)
        assertEquals(1.5, 1.5.roundDownToNearestHalf(), 0.0)
        assertEquals(1.5, 1.999.roundDownToNearestHalf(), 0.0)
    }

}
