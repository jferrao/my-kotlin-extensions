package util

import java.util.Calendar
import java.util.Date
import java.util.concurrent.TimeUnit


/**
 * Set Calendar for the first day of the current month.
 */
fun Calendar.firstOfTheMonth() =
        this.set(Calendar.DAY_OF_MONTH, this.getActualMinimum(Calendar.DAY_OF_MONTH))

/**
 * Set Calendar to the next calendar day.
 */
fun Calendar.nextDay() = this.add(Calendar.DAY_OF_MONTH, 1)

/**
 * Set Calendar to the previous calendar day.
 */
fun Calendar.previousDay() = this.add(Calendar.DAY_OF_MONTH, -1)

/**
 * Set Calendar to the current day.
 */
fun Calendar.today() {
    this.time = Date()
    this.set(Calendar.HOUR_OF_DAY, this.get(Calendar.HOUR_OF_DAY))
    this.set(Calendar.MINUTE, this.get(Calendar.MINUTE))
    this.set(Calendar.SECOND, this.get(Calendar.SECOND))
    this.set(Calendar.MILLISECOND, this.get(Calendar.MILLISECOND))
}

/**
 * Set Calendar to tomorrow.
 */
fun Calendar.tomorrow() {
    this.today()
    this.add(Calendar.DAY_OF_MONTH, 1)
}

/**
 * Set Calendar to yesterday.
 */
fun Calendar.yesterday() {
    this.today()
    this.add(Calendar.DAY_OF_MONTH, -1)
}

/**
 * Set Calendar to midnight.
 */
fun Calendar.midnight() {
    this.set(Calendar.HOUR_OF_DAY, 0)
    this.clear(Calendar.MINUTE)
    this.clear(Calendar.SECOND)
    this.clear(Calendar.MILLISECOND)
}

/**
 * Seconds from Unix epoch timestamp for Calendar's date and time.
 */
var Calendar.epoch: Int
    get() = TimeUnit.MILLISECONDS.toSeconds(this.timeInMillis).toInt()
    set(seconds) { this.timeInMillis = TimeUnit.SECONDS.toMillis(seconds.toLong()) }

/**
 * Check if calendars are set to the same day, month and year.
 *
 * @param calendar Any other calendar used to match against
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
 */
fun Calendar.isSameMonth(calendar: Calendar): Boolean =
        this.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) && this.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)

/**
 * Check if calendars are set to the same year.
 *
 * @param calendar Any other calendar used to match against
 */
fun Calendar.isSameYear(calendar: Calendar): Boolean = this.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)

/**
 * Check if calendars are set to the same day of the week.
 *
 * @param calendar Any other calendar used to match against
 */
fun Calendar.isSameDayOfWeek(calendar: Calendar): Boolean =
        this.get(Calendar.DAY_OF_WEEK) == calendar.get(Calendar.DAY_OF_WEEK)

/**
 * Check if both calendars are set to the desired year.
 *
 * @param calendar Any other calendar used to match against
 * @param year Year against which to compare against both calendars
 */
fun Calendar.areInYear(calendar: Calendar, year: Int): Boolean =
        this.isSameYear(calendar) && this.get(Calendar.YEAR) == year
