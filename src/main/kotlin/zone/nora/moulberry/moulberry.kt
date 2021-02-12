package zone.nora.moulberry

fun <T> switch(value: T, build: Switch<T>.() -> Switch<T>): Unit = Switch<T>().build().run(value)

fun javaSwitch(value: Any, build: Switch<Any>.() -> Switch<Any>): Unit = switch(value, build)

class Switch<T> {
    private val cases: MutableList<Case<T>> = mutableListOf()
    private var defaultMethod: () -> Unit = { }

    fun case(vararg matches: T, fallthrough: Boolean = false, method: () -> Unit): Switch<T> = apply {
        cases.add(Case(matches.toList(), method, fallthrough))
    }

    fun addCase(match: T, fallthrough: Boolean = false, method: Runnable): Switch<T> = apply {
        cases.add(Case(listOf(match), { method.run() }, fallthrough))
    }

    infix fun default(method: () -> Unit): Switch<T> = apply {
        defaultMethod = method
    }

    fun setDefault(method: Runnable): Switch<T> = apply {
        defaultMethod = { method.run() }
    }

    internal fun run(value: T) {
        var fallthrough = false
        cases.forEach {
            if (it.values.contains(value) && !fallthrough) {
                it.method()
                if (it.fallthrough) {
                    fallthrough = true
                } else {
                    return
                }
            } else if (fallthrough) {
                it.method()
                if (!it.fallthrough) {
                    return
                }
            }
        }
        defaultMethod.invoke()
    }

    internal data class Case<T>(val values: List<T>, val method: () -> Unit, val fallthrough: Boolean)
}