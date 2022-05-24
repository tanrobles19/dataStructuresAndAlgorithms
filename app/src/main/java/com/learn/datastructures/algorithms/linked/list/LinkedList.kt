package com.learn.datastructures.algorithms.linked.list

class LinkedList<T: Any> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean = size == 0

    override fun toString(): String {
        return if (isEmpty()) "Empty List" else head.toString()
    }

}