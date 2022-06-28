package com.learn.datastructures.algorithms.stack

class StackImpl<T: Any> : Stack<T> {

    private val storage = arrayListOf<T>()

    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("--------")
    }

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if(isEmpty()) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }

    private fun isEmpty() :Boolean {
        return storage.size == 0
    }

}