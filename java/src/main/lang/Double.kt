package lang


/**
 * Rounds a number down to its nearest half.
 */
fun Double.roundDownToNearestHalf(): Double = Math.floor(this * 2) / 2.0
