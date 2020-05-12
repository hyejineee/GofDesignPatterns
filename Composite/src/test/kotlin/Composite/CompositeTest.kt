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
    fun `첫 테스트 - 형제가 없는 디렉토리 구조 만들기 테스트`() {
        val directory = Directory("/")

//        directory.add("root")
//        directory.add("bin")
//        directory.add("tmp")
//        directory.add("usr")

        directory.printList()

        assertThat(outContent.toString()).isEqualTo("/root/bin/tmp")
    }

    @Test
    fun `디렉터리 클래스 생성 - 형제가 없는 디렉토리 구조 만들기 테스트 `() {
        val rootDir = Directory("root").apply {
            add(
                    Directory("bin").apply {
                        add(
                                Directory("tmp").apply {
                                    add(Directory("usr"))
                                }
                        )
                    }
            )
        }

        rootDir.printList()
        assertThat(outContent.toString()).contains("/root/bin/tmp/usr")
    }

    @Test
    fun `디렉터리 클래스 생성 - 형제가 있는 디렉토리 구조 만들기 테스트`() {

        val rootDir = Directory("root")
        val binDir = Directory("bin")
        val tmpDir = Directory("tmp")
        val usrDir = Directory("usr")

        rootDir.apply {
            add(binDir)
            add(tmpDir)
            add(usrDir)
        }

        rootDir.printList()

        assertThat(outContent.toString()).isEqualTo(
                "/root\n" +
                        "/root/bin\n" +
                        "/root/tmp\n" +
                        "/root/usr\n"
        )
    }

    @Test
    fun `디렉터리, 파일 공통 인터페이스 생성 - 디렉터리 하위에 파일 추가하기 테스트 `() {

        val binDir = Directory("bin")
        val tmpDir = Directory("tmp")
        val usrDir = Directory("usr")

        val rootDir = Directory("root").apply {
            /**
             * 디렉토리에 자식을 추가하는 연산을 동일하게 사용하기 위해서
             * Directory class와 File class의 공통이 부분을 모아 인터페이스로 정의한다.
             * */
            add(File("memo.txt"))

            add(binDir)
            add(tmpDir)
            add(usrDir)
        }

        rootDir.printList()

        assertThat(outContent.toString()).isEqualTo(
                "/root\n" +
                        "/root/memo.txt" +
                        "/root/bin\n" +
                        "/root/tmp\n" +
                        "/root/usr\n"

        )
    }

    @Test
    fun `사이즈 구하기 테스트`() {

        val binDir = Directory("bin").apply {
            add(File("test1.txt", 200))
            add(File("test2.txt", 300))
        }
        val tmpDir = Directory("tmp").apply {
            add(File("test1.txt", 1000))
            add(File("test2.txt", 1000))
        }
        val usrDir = Directory("usr")

        val rootDir = Directory("root").apply {
            /**
             * 디렉토리에 자식을 추가하는 연산을 동일하게 사용하기 위해서
             * Directory class와 File class의 공통이 부분을 모아 인터페이스로 정의한다.
             * */
            add(File("memo.txt", 1000))

            add(binDir)
            add(tmpDir)
            add(usrDir)
        }

        rootDir.printSize()

        assertThat(outContent.toString()).isEqualTo(
                "/root , size = 3500\n" +
                        "/root/memo.txt , size = 1000\n" +
                        "/root/bin , size = 500\n" +
                        "/root/bin/test1.txt , size = 200\n" +
                        "/root/bin/test2.txt , size = 300\n" +
                        "/root/tmp , size = 2000\n" +
                        "/root/tmp/test1.txt , size = 1000\n" +
                        "/root/tmp/test2.txt , size = 1000\n" +
                        "/root/usr , size = 0\n"

        )
    }
}