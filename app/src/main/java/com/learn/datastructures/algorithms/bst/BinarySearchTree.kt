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

    fun remove(value: T) {
        root = remove(root, value)
    }

    private fun remove(node: BinaryNode<T>?, value: T): BinaryNode<T>? {
        node ?: return null

        when{
            value == node.value -> validateNode(node)
            value > node.value -> node.rightChild = remove(node.rightChild , value)
            else -> node.leftChild = remove(node.leftChild, value)

        }// end when
        return node
    }// end fun remove()

    private fun validateNode(node: BinaryNode<T>): BinaryNode<T>? {

        if(node.leftChild == null && node.rightChild == null) {
            //Leaf node
            return null
        }

        if (node.leftChild == null)
            return node.rightChild

        if (node.rightChild == null)
            return node.leftChild

        node.rightChild?.min?.value?.let {
            //replace the node that you removed with the smallest node in its right subtree
            // it will be the replaced value
            node.value = it
        }

        node.rightChild = remove(node.rightChild, node.value)

        return null

    }// end fun validateNode()

}