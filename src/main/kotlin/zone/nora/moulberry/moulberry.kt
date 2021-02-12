package zone.nora.moulberry

fun <T> switch(value: T, switch: Switch<T>.() -> Switch<T>): Unit = switch.invoke(Switch()).runSwitch(value)

class Switch<T> {
    private val cases: MutableList<Case<T>> = mutableListOf()
    private var defaultMethod: () -> Unit = { }

    fun case(vararg matches: T, fallthrough: Boolean = false, method: () -> Unit): Switch<T> = apply {
        cases.add(Case(matches.toList(), method, fallthrough))
    }

    infix fun default(method: () -> Unit): Switch<T> = apply {
        defaultMethod = method
    }

    internal fun runSwitch(value: T) {
        var fallthrough = false
        cases.forEach {
            if (it.values.contains(value) && !fallthrough) {
                it.method.invoke()
                if (it.fallthrough) {
                    fallthrough = true
                } else {
                    return
                }
            } else if (fallthrough) {
                it.method.invoke()
                if (!it.fallthrough) {
                    return
                }
            }
        }
        defaultMethod.invoke()
    }

    internal data class Case<T>(val values: List<T>, val method: () -> Unit, val fallthrough: Boolean)
}