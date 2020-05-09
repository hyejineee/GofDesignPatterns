package Composite

abstract class Entry(val name: String, size: Int) {
    open var size = size
    abstract fun add(entry: Entry)
    abstract fun printList(parentsDir: String = "")
    abstract fun printSize(dir: String = "", size: Int = 0)
}