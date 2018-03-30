package com.blindknot.extensions.java.util

import org.junit.Assert
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import java.util.Calendar
import java.util.TimeZone


class CalendarTest() {

    companion object {
        const val testDay = 18
        const val testMonth = 11
        const val testYear = 2009
        const val testHour = 13
        const val testMinutes = 6
        const val testSeconds = 8
        const val testEpoch = 1258549568
    }

    @Test
    fun `is set to the first day of the month`() {
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        calendar.firstOfTheMonth()

        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH))
    }

    @Test
    fun `is next day`() {
        val compareCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        val againstCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        againstCalendar.nextDay()

        Assert.assertNotEquals(againstCalendar.get(Calendar.DAY_OF_MONTH), compareCalendar.get(Calendar.DAY_OF_MONTH))

        compareCalendar.add(Calendar.DAY_OF_MONTH, 1)
        assertEquals(againstCalendar.get(Calendar.DAY_OF_MONTH), compareCalendar.get(Calendar.DAY_OF_MONTH))
    }

    @Test
    fun `is previous day`() {
        val compareCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        val againstCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        againstCalendar.previousDay()

        assertNotEquals(againstCalendar.get(Calendar.DAY_OF_MONTH), compareCalendar.get(Calendar.DAY_OF_MONTH))

        compareCalendar.add(Calendar.DAY_OF_MONTH, -1)
        assertEquals(againstCalendar.get(Calendar.DAY_OF_MONTH), compareCalendar.get(Calendar.DAY_OF_MONTH))
    }

    @Test
    fun `is today`() {
        val compareCalendar = Calendar.getInstance(TimeZone.getTimeZone("EST"))
        val againstCalendar = Calendar.getInstance(TimeZone.getTimeZone("EST"))
        againstCalendar.set(Calendar.HOUR_OF_DAY, 22)
        againstCalendar.today()

        Assert.assertEquals(againstCalendar.get(Calendar.DAY_OF_MONTH), compareCalendar.get(Calendar.DAY_OF_MONTH))
    }

    @Test
    fun `is tomorrow`() {
        val compareCalendar = Calendar.getInstance(TimeZone.getTimeZone("EST"))
        val againstCalendar = Calendar.getInstance(TimeZone.getTimeZone("EST"))
        againstCalendar.set(Calendar.HOUR_OF_DAY, 22)
        againstCalendar.tomorrow()

        assertNotEquals(againstCalendar.get(Calendar.DAY_OF_MONTH), compareCalendar.get(Calendar.DAY_OF_MONTH))

        compareCalendar.add(Calendar.DAY_OF_MONTH, 1)
        assertEquals(againstCalendar.get(Calendar.DAY_OF_MONTH), compareCalendar.get(Calendar.DAY_OF_MONTH))
    }

    @Test
    fun `is yesterday`() {
        val compareCalendar = Calendar.getInstance(TimeZone.getTimeZone("EST"))
        val againstCalendar = Calendar.getInstance(TimeZone.getTimeZone("EST"))
        againstCalendar.set(Calendar.HOUR_OF_DAY, 22)
        againstCalendar.yesterday()

        assertNotEquals(againstCalendar.get(Calendar.DAY_OF_MONTH), compareCalendar.get(Calendar.DAY_OF_MONTH))

        compareCalendar.add(Calendar.DAY_OF_MONTH, -1)
        assertEquals(againstCalendar.get(Calendar.DAY_OF_MONTH), compareCalendar.get(Calendar.DAY_OF_MONTH))
    }

    @Test
    fun `is set to midnight`() {
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        calendar.midnight()

        assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY))
        assertEquals(0, calendar.get(Calendar.MINUTE))
        assertEquals(0, calendar.get(Calendar.SECOND))
        assertEquals(0, calendar.get(Calendar.MILLISECOND))
    }

    @Test
    fun `is set to November 18th, 2009 at 10h 23m 00s using UNIX epoch timestamp`() {
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        calendar.epoch = testEpoch

        assertEquals(testDay, calendar.get(Calendar.DAY_OF_MONTH))
        assertEquals(testMonth, calendar.get(Calendar.MONTH) + 1)
        assertEquals(testYear, calendar.get(Calendar.YEAR))
        assertEquals(testHour, calendar.get(Calendar.HOUR_OF_DAY))
        assertEquals(testMinutes, calendar.get(Calendar.MINUTE))
        assertEquals(testSeconds, calendar.get(Calendar.SECOND))
    }

    @Test
    fun `is same day`() {
        val compareCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        val againstCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        againstCalendar.set(Calendar.HOUR_OF_DAY, testHour)
        againstCalendar.set(Calendar.MINUTE, testMinutes)
        againstCalendar.set(Calendar.SECOND, testSeconds)
        // Despite the time change both Calendars should still be on the same day
        assertTrue(compareCalendar.isSameDay(againstCalendar))

        // Set the Calendar to the next day
        againstCalendar.add(Calendar.DAY_OF_MONTH, 1)
        assertFalse(compareCalendar.isSameDay(againstCalendar))

        // Set the Calendar back to the previous day and set the month to the next one
        againstCalendar.add(Calendar.DAY_OF_MONTH, -1)
        assertTrue(compareCalendar.isSameDay(againstCalendar))
        againstCalendar.add(Calendar.MONTH, 1)
        assertFalse(compareCalendar.isSameDay(againstCalendar))

        // Set the Calendar back to the previous month and set the year to the next one
        againstCalendar.add(Calendar.MONTH, -1)
        assertTrue(compareCalendar.isSameDay(againstCalendar))
        againstCalendar.add(Calendar.YEAR, 1)
        assertFalse(compareCalendar.isSameDay(againstCalendar))
    }

    @Test
    fun `is same month`() {
        val compareCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        val againstCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        againstCalendar.set(Calendar.DAY_OF_MONTH, testDay)

        assertTrue(compareCalendar.isSameMonth(againstCalendar))

        // Set the Calendar to the next month
        againstCalendar.add(Calendar.MONTH, 1)
        assertFalse(compareCalendar.isSameMonth(againstCalendar))

        // Set the Calendar back to the previous month and set the year to the next one
        againstCalendar.add(Calendar.MONTH, -1)
        assertTrue(compareCalendar.isSameMonth(againstCalendar))
        againstCalendar.add(Calendar.YEAR, 1)
        assertFalse(compareCalendar.isSameMonth(againstCalendar))
    }

    @Test
    fun `is same year`() {
        val compareCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        val againstCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        againstCalendar.set(Calendar.DAY_OF_MONTH, testDay)
        againstCalendar.set(Calendar.MONTH, testMonth - 1)

        assertTrue(compareCalendar.isSameYear(againstCalendar))

        // Set the Calendar to the next Year
        againstCalendar.add(Calendar.YEAR, 1)
        assertFalse(compareCalendar.isSameYear(againstCalendar))
    }

    @Test
    fun `is same day of the week`() {
        val compareCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        val againstCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"))
        againstCalendar.add(Calendar.DAY_OF_MONTH, 7)

        assertTrue(compareCalendar.isSameDayOfWeek(againstCalendar))
    }

}
