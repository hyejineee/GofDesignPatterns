package Composite

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class CompositeTest {
    lateinit var outContent: ByteArrayOutputStream

    @Before
    fun setUp() {
        outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
    }

    @Test
    fun `형제가 없는 디렉토리 구조 만들기 테스트`() {
        val directory = Directory("/")

//        directory.add("root")
//        directory.add("bin")
//        directory.add("tmp")
//        directory.add("usr")

        directory.add(Directory("root"))
        directory.add(Directory("bin"))
        directory.add(Directory("tmp"))
        directory.add(Directory("usr"))

        directory.printDir("")

        assertThat(outContent.toString()).isEqualTo("/root/bin/tmp")
    }

    @Test
    fun `형제가 있는 디렉토리 구조 만들기 테스트`() {

        val rootDir = Directory("root")
        val binDir = Directory("bin")
        val tmpDir = Directory("tmp")
        val usrDir = Directory("usr")

        rootDir.apply {
            add(binDir)
            add(tmpDir)
            add(usrDir)
        }

        rootDir.printDir("")

        assertThat(outContent.toString()).isEqualTo(
                "/root\n" +
                        "/root/bin\n" +
                        "/root/tmp\n" +
                        "/root/usr\n"
        )
    }

}