// KJS_WITH_FULL_RUNTIME
// EXPECTED_REACHABLE_NODES: 1519

class ArrayWrapper<T>() {
    val contents = ArrayList<T>()

    fun add(item: T) {
        contents.add(item)
    }

    operator fun plusAssign(rhs: ArrayWrapper<T>) {
        contents.addAll(rhs.contents)
    }

    fun get(index: Int): T {
        return contents.get(index)
    }
}

fun box(): String {
    var v1 = ArrayWrapper<String>()
    val v2 = ArrayWrapper<String>()
    v1.add("foo")
    val v3 = v1
    v2.add("bar")
    v1 += v2
    return if (v1.contents.size == 2 && v3.contents.size == 2) "OK" else "fail"
}
