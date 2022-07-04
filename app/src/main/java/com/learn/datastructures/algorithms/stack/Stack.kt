package com.learn.datastructures.algorithms.stack

interface Stack<T: Any> {

    val count: Int
        get

    val isEmpty: Boolean
        get() = count == 0

    fun peek(): T?

    fun push(element: T)
    fun pop(): T?
}