package com.blindknot.extensions.java.util

import java.util.Calendar
import java.util.concurrent.TimeUnit

/**
 * Set Calendar to midnight.
 */
fun Calendar.midnight(): Calendar {
    this.set(Calendar.HOUR_OF_DAY, 0)
    this.clear(Calendar.MINUTE)
    this.clear(Calendar.SECOND)
    this.clear(Calendar.MILLISECOND)
    return this
}

/**
 * Set Calendar for the first day of the current month.
 */
fun Calendar.firstOfTheMonth(): Calendar {
    this.set(Calendar.DAY_OF_MONTH, this.getActualMinimum(Calendar.DAY_OF_MONTH))
    return this
}

/**
 * Seconds from Unix epoch timestamp for current date and time.
 */
var Calendar.epoch: Int
    get() = TimeUnit.MILLISECONDS.toSeconds(this.timeInMillis).toInt()
    set(seconds) { this.timeInMillis = TimeUnit.SECONDS.toMillis(seconds.toLong()) }

/**
 * Check if calendars are set to the same day, month and year.
 *
 * @param calendar Any other calendar used to match against
 * @return True if all conditions match
 */
fun Calendar.isSameDay(calendar: Calendar): Boolean {
    return this.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH) &&
            this.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
            this.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)
}

/**
 * Check if calendars are set to the same month and year.
 *
 * @param calendar Any other calendar used to match against
 * @return True if all conditions match
 */
fun Calendar.isSameMonth(calendar: Calendar): Boolean {
    return this.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) && this.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)
}

/**
 * Check if calendars are set to the same year.
 *
 * @param calendar Any other calendar used to match against
 * @return True if all conditions match
 */
fun Calendar.isSameYear(calendar: Calendar): Boolean {
    return this.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)
}

/**
 * Check if calendars are set to the same day of the week.
 *
 * @param calendar Any other calendar used to match against
 * @return True if all conditions match
 */
fun Calendar.isSameDayOfWeek(calendar: Calendar): Boolean {
    return this.get(Calendar.DAY_OF_WEEK) == calendar.get(Calendar.DAY_OF_WEEK)
}

/**
 * Check if both calendars are set to the desired year.
 *
 * @param calendar Any other calendar used to match against
 * @param year Year against which to compare against both calendars
 * @return True if all conditions match
 */
fun Calendar.areInYear(calendar: Calendar, year: Int): Boolean {
    return this.isSameYear(calendar) && this.get(Calendar.YEAR) == year
}
