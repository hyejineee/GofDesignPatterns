package Composite

abstract class Entry(val name: String, val size: Int) {
    abstract fun add(entry: Entry)
    abstract fun printList(parentsDir: String = "")
}