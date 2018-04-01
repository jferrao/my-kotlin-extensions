package lang

import java.text.Normalizer;
import java.util.Locale


/**
 * Replace any non-ASCII characters in a String by another String.
 *
 * @param replacement Replacement String
 */
fun String.replaceNonAscii(replacement: String): String = this.replace("[^\\p{ASCII}]".toRegex(), replacement)

/**
 * Remove all non-ASCII characters from a String.
 */
fun String.removeNonAscii(): String = this.replaceNonAscii("")

/**
 * Remove all emojis from a String.
 *
 * @see <a href="https://stackoverflow.com/a/49516025">stackoverflow.com/a/49516025</>
 */
fun String.removeEmoji(): String =
        this.replace("[^\\p{L}\\p{M}\\p{N}\\p{P}\\p{Z}\\p{Cf}\\p{Cs}\\s]".toRegex(), "")

/**
 * Adjust diacritical marks or letter accents or glyph to its closest non-accented letter.
 * e.g. "ã" gets converted to "a"
 *
 * @see <a href="https://en.wikipedia.org/wiki/Diacritic">Diacritic at Wikipedia</a>
 */
fun String.convertDiacritics(): String {
    if (!Normalizer.isNormalized(this, Normalizer.Form.NFD)) {
        val normalizedString = Normalizer.normalize(this, Normalizer.Form.NFD)
        return normalizedString.replace("\\p{InCombiningDiacriticalMarks}+".toRegex(), "")
    }
    return this
}

/**
 * Generate an URL friendly slug.
 *
 * TODO: this could be improved adjusting some other non-ascii chars like ø to o and remove #, ? and /
 */
fun String.toSLug(): String {
    return this
            .convertDiacritics()
            .removeNonAscii()
            .trim()
            .replace("\\s+".toRegex(), "-")
            .toLowerCase(Locale.ENGLISH)
}
