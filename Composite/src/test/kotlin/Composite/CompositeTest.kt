package Composite

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CompositeTest {
    lateinit var outContent: ByteArrayOutputStream

    @Before
    fun setUp() {
        outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
    }

    @Test
    fun `디렉토리 만들기 테스트`() {
        makeDirectory("root")
        
        assertThat(outContent.toString()).isEqualTo("/root")
    }

}