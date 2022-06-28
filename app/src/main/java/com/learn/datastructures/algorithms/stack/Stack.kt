package com.learn.datastructures.algorithms.stack

interface Stack<T: Any> {
    fun push(element: T)
    fun pop(): T?
}