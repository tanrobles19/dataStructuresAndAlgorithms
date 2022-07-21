package com.learn.datastructures.algorithms.queue

class ArrayListQueue<T: Any> : Queue<T>{

    private val list = arrayListOf<T?>()

    override fun enqueue(element: T?): Boolean {
        list.add(element)
        return true
    }

    override fun dequeue(): T? = if (isEmpty) null else list.removeAt(0)

    //O(1) constant time
    override val count: Int
        get() = list.size

    //O(1) constant time
    override fun peek(): T? = if(isEmpty) null else list.get(0)

    override fun toString(): String = list.toString()
}