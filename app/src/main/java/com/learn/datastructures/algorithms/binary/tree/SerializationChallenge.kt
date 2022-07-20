package com.learn.datastructures.algorithms.binary.tree

import com.learn.datastructures.algorithms.queue.Queue

// This is a Pre-order traversal function
fun serialization(tree: BinaryNode<String>, queue: Queue<String>): Queue<String> {

    queue.enqueue(tree.value)

    tree.leftChild?.let { serialization(it, queue) } ?: queue.enqueue(null)

    tree.rightChild?.let { serialization(it, queue) }?: queue.enqueue(null)

    return queue

}// end fun serialization()

fun deSearializable(tree: BinaryNode<String>, queue: Queue<String>): BinaryNode<String> {

    if(!queue.isEmpty) {

        queue.dequeue()?.let {
            tree.leftChild = BinaryNode(it)
            deSearializable(tree.leftChild!!, queue)
        }

        queue.dequeue()?.let {
            tree.rightChild = BinaryNode(it)
            deSearializable(tree.rightChild!!, queue)
        }

    }// end if

    return tree

}// end fun desearializable()

// How to test the Challenge

//println("start")
//
//val queue = ArrayListQueue<String>()
//val serializableQueue = serialization(root, queue)
//
//println(serializableQueue.toString())
//
//val deSearializableTree = serializableQueue.dequeue()?.let {
//    deSearializable(BinaryNode(it), queue)
//}
//
//println( deSearializableTree )
//
//println()
//println("end")
