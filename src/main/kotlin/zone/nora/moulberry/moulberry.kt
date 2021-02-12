package zone.nora.moulberry

fun switch(any: Any, switch: Switch.() -> Switch): Unit = switch.invoke(Switch()).runSwitch(any)

class Switch {
    private val cases: MutableList<Triple<Any, () -> Unit, Boolean>> = mutableListOf()
    private var defaultMethod: () -> Unit = { }

    fun case(vararg matches: Any, breakStatement: Boolean = true, method: () -> Unit): Switch = apply {
        matches.forEach {
            cases.add(Triple(it, method, breakStatement))
        }
    }

    infix fun default(method: () -> Unit): Switch = apply {
        defaultMethod = method
    }

    internal fun runSwitch(any: Any) {
        cases.forEach {
            if (any == it.first) {
                it.second.invoke()
                if (it.third) {
                    return
                }
            }
        }
        defaultMethod.invoke()
    }
}