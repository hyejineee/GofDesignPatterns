package Composite

class Directory(name: String, size: Int = 0) : Entry(name, size) {

    private var childs = listOf<Entry>()

    override var size: Int = 0
        get() = childs.sumBy { it.size }
        set(value) {
            field = value
        }

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

    override fun printSize(dir: String) {

        print("$dir/$name , size = ${this.size}\n")

        if (childs.isNotEmpty()) {
            childs.map {
                it.printSize("$dir/$name")
            }
        }


    }
}