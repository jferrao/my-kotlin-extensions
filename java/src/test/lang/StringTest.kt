package lang

import org.junit.Assert
import org.junit.Test


class StringTest() {

    @Test
    fun `all non-ascii replaced`() {
        val name = "João"
        Assert.assertEquals("JoAo", name.replaceNonAscii("A"))
    }

    @Test
    fun `all non-ascii removed`() {
        val name = "João"
        Assert.assertEquals("Joo", name.removeNonAscii())
    }

    @Test
    fun `all diacritics are replaced`() {
        val name = "João"
        Assert.assertEquals("Joao", name.convertDiacritics())
    }

    @Test
    fun `is a URL friendly slug`() {
        val name = "Køtlin extensions by João ©±† €uro"
        Assert.assertEquals("ktlin-extensions-by-joao-uro", name.toSLug())
    }

}
