package com.blindknot.extensions.java.util

import org.junit.Test
import org.junit.Assert.assertEquals
import java.util.Calendar
import java.util.TimeZone

class CalendarTest() {

    @Test
    fun `is set to midnight`() {
        // given
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        calendar.midnight()

        // then
        assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY))
        assertEquals(0, calendar.get(Calendar.MINUTE))
        assertEquals(0, calendar.get(Calendar.SECOND))
        assertEquals(0, calendar.get(Calendar.MILLISECOND))
    }

    @Test
    fun `is set to the first day of the month`() {
        // given
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        calendar.firstOfTheMonth()

        // then
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH))
    }

}