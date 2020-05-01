package Composite

class File(name: String, size: Int) : Entry(name, size) {
    override fun add(entry: Entry) {
    }

    override fun printList(parentsDir: String) {
        print("$parentsDir/$name")
    }
}