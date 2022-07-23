package com.learn.datastructures.algorithms.bst

import com.learn.datastructures.algorithms.binary.tree.BinaryNode

class BinarySearchTree<T: Comparable<T>>() {

    var root : BinaryNode<T>? = null

    override fun toString() = root.toString() ?: "empty tree"

    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(node: BinaryNode<T>?, value: T): BinaryNode<T> {

        node ?: return BinaryNode(value)

        if(value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        }else{
            node.rightChild = insert(node.rightChild, value)
        }

        return node
    }// end insert()

    fun contains(value: T): BinaryNode<T>? {

        if(root == null) return null

        var treeNode = root

        while (treeNode != null) {
            println(treeNode.value)
            if(value == treeNode.value) return treeNode

            treeNode = if(value > treeNode.value) treeNode.rightChild else treeNode.leftChild

        }// end while

        return null

    }// end fun contains()

}