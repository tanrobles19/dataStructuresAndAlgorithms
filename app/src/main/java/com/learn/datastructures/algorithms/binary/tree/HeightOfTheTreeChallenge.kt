package com.learn.datastructures.algorithms.binary.tree

import com.learn.datastructures.algorithms.queue.ArrayListQueue

fun heightOfTheTree(root: BinaryNode<String>): Int {

    val queue = ArrayListQueue<BinaryNode<String>>()

    root.leftChild?.let { queue.enqueue(it) }
    root.rightChild?.let { queue.enqueue(it) }

    println(root.value)

    return queue.peek()?.let { level(queue) }?: 0

}

private fun level(queue: ArrayListQueue<BinaryNode<String>>): Int {

    val newQueue = ArrayListQueue<BinaryNode<String>>()

    var node = queue.dequeue()

    while (node != null) {

        print(node.value + " ")

        node.leftChild?.let { newQueue.enqueue(it) }
        node.rightChild?.let { newQueue.enqueue(it) }

        node = queue.dequeue()
    }

    println(" ")

    val distance : Int = newQueue.peek()?.let {
        level(newQueue)
    }?: 0

    return distance + 1

}// end fun testRecursive()