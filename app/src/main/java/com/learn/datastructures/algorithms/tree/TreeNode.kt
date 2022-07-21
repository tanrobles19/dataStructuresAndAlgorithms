package com.learn.datastructures.algorithms.tree

import com.learn.datastructures.algorithms.queue.ArrayListQueue
import com.learn.datastructures.algorithms.queue.Queue

//typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(val value: T) {
    val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    fun depthFirst(nodeTree: TreeNode<T>) {

        println(nodeTree.value)

        nodeTree.children.forEach{ node ->
            node.depthFirst(node)
        }

    }

    fun levelOrderTraversal(nodeTree: TreeNode<T>) {

        println(nodeTree.value)

        val queue = ArrayListQueue<TreeNode<T>>()
        nodeTree.children.forEach { queue.enqueue(it) }

        var node = queue.dequeue()

        while (node != null) {
            println(node.value)
            node.children.forEach {
                queue.enqueue(it)
            }
            node = queue.dequeue()
        }

    }// end fun levelOrderTraversal

    fun search(nodeTree: TreeNode<T>, value: T): TreeNode<T>? {

        val queue = ArrayListQueue<TreeNode<T>>()
        nodeTree.children.forEach { queue.enqueue(it) }

        var nodeTemp = queue.dequeue()

        while (nodeTemp != null) {
            if(nodeTemp.value == value) {
                return nodeTemp
            }
            nodeTemp.children.forEach {
                queue.enqueue(it)
            }
            nodeTemp = queue.dequeue()
        }

        return null

    }// end fun search

    fun searchChallengeOne(root: TreeNode<T>) {

        val queue = ArrayListQueue<TreeNode<T>>()

        root.children.forEach { queue.enqueue(it) }

        println(root.value)

        joinLevel(queue)

    }// end fun searchChallengeOne()

    private fun joinLevel(queue: Queue<TreeNode<T>>) {

        var nodeTemp = queue.dequeue()
        val newQueue = ArrayListQueue<TreeNode<T>>()

        while (nodeTemp != null) {

            nodeTemp.value?.let { print("$it ") }

            nodeTemp.children.forEach { newQueue.enqueue(it) }

            nodeTemp = queue.dequeue()

        }// end while

        println("")
        if(!newQueue.isEmpty) joinLevel(newQueue)

    }// end fun joinLevel()

//    fun forEachDepthFirst(visit: Visitor<T>) {
//        visit(this)
//        children.forEach{
//            it.forEachDepthFirst(visit)
//        }
//    }

}