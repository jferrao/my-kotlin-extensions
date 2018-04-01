package lang

import org.junit.Assert.assertEquals
import org.junit.Test


class StringTest() {

    @Test
    fun `all non-ascii replaced`() {
        val name = "João"
        assertEquals("JoAo", name.replaceNonAscii("A"))
    }

    @Test
    fun `all non-ascii removed`() {
        val name = "João"
        assertEquals("Joo", name.removeNonAscii())
    }

    @Test
    fun `all emojis removed from string`() {
        val name = "João hello world _# 皆さん、こんにちは！　私はジョンと申します。\uD83D\uDD25⭐"
        assertEquals("João hello world _# 皆さん、こんにちは！　私はジョンと申します。", name.removeEmoji())
    }

    @Test
    fun `all diacritics replaced`() {
        val name = "João"
        assertEquals("Joao", name.convertDiacritics())
    }

    @Test
    fun `is a URL friendly slug`() {
        val name = "Køtlin extensions by João ©±† €uro \uD83D\uDD25⭐"
        assertEquals("ktlin-extensions-by-joao-uro", name.toSLug())
    }

}
