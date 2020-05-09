package Composite

class File(name: String, size: Int = 0) : Entry(name, size) {
    override fun add(entry: Entry) {
    }

    override fun printList(parentsDir: String) {
        print("$parentsDir/$name")
    }

    override fun printSize(dir: String, size: Int) {
        print("$dir/$name , size = ${this.size}\n")
    }
}