package com.learn.datastructures.algorithms.binary.tree

// This is a Pre-order traversal function
fun serializationL(tree: BinaryNode<String>, list: MutableList<String?>): MutableList<String?> {

    list.add(tree.value)

    tree.leftChild?.let { serializationL(it, list) } ?: list.add(null)

    tree.rightChild?.let { serializationL(it, list) }?: list.add(null)

    return list

}// end fun serialization()

fun deSearializable(tree: BinaryNode<String>, list: MutableList<String?>): BinaryNode<String> {

    if(list.isNotEmpty()) {

        list.removeAt(0)?.let {
            tree.leftChild = BinaryNode(it)
            deSearializable(tree.leftChild!!, list)
        }

        list.removeAt(0)?.let {
            tree.rightChild = BinaryNode(it)
            deSearializable(tree.rightChild!!, list)
        }

    }// end if

    return tree

}// end fun desearializable()