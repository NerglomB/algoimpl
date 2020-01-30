package de.berndh.algoimpl

object Helper {
    fun <T> compareByDescending(vararg selectors: (T) -> Comparable<*>?): Comparator<T> {
        return Comparator { b, a -> compareValuesBy(a, b, *selectors) }
    }
}
