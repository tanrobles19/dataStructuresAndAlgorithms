package com.learn.datastructures.algorithms.queue

import com.learn.datastructures.algorithms.linked.list.DoublyLinkedList

class LinkedListQueue<T: Any> : Queue<T> {

    private val list = DoublyLinkedList<T>()

    private var size = 0

    override val count: Int
        get() = size

    /*
    * Time Complexity O(1)
    * */
    override fun enqueue(element: T?): Boolean {
        list.append(element!!)
        size++
        return true
    }

    override fun dequeue(): T? {
        return list.first?.let {
            list.remove(it)
        }
    }

    override fun peek(): T? = if (list.isEmpty()) null else list.first?.value
}