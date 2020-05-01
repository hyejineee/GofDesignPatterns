package Composite

class Directory(name: String, size: Int = 0) : Entry(name, size) {
    private var childs = listOf<Entry>()

    override fun add(entry: Entry) {
        val copy = childs.toMutableList().apply {
            this.add(entry)
        }
        childs = copy
    }

    override fun printList(parentsDir: String) {
        print("$parentsDir/$name\n")

        if (childs.isNotEmpty()) {
            childs.map {
                it.printList("$parentsDir/$name")
            }
        }
    }
}