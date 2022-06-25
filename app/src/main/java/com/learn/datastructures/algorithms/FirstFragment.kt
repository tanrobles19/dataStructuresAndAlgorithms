package com.learn.datastructures.algorithms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.learn.datastructures.algorithms.databinding.FragmentFirstBinding
import com.learn.datastructures.algorithms.linked.list.LinkedList
import com.learn.datastructures.algorithms.linked.list.mergeSorted
import com.learn.datastructures.algorithms.sort.InsertionSort

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {

            val insertionSort = InsertionSort()

            val list: IntArray = intArrayOf( 10, 5, 2, 4, 12, 6, 100, 3, 8, 20, 25, 1 )

//            insertionSort.printList(5, list)
            insertionSort.insertionSort(11, list)

            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.buttonLinkedList.setOnClickListener {

            val listA = LinkedList<Int>().apply {
                add(6)
                add(8)
                add(9)
            }

            val listB = LinkedList<Int>().apply {
                add(1)
                add(2)
                add(3)
                add(4)
            }

            listB.mergeSorted(listA)

//            list.removeAll(listOf(1, 3, 5, 7, 9))

//            list.removeAll(listOf(2, 10))

//            list.remove(1)

//            println()

//            list.removeByValue(3)

//            println("size: " + list.size)
//
//            for (item in list) {
//                println("Node: $item")
//            }

//            list.reverse()

//            for (item in list) {
//                println("Node: $item")
//            }


//            println("The Middle of the list:")
//            println(list.middleOfTheList())

//            val reverseList = list.reverseList()

//            list.printInReverse()
//
//            for (item in reverseList) {
//                println("reverse: $item")
//            }

//            val list = LinkedList<Int> ()

//            list.append(1)
//            list.append(2)

//            println(list)

//            println("Pop() ${list.pop()}")

//            println("RemoveLast() ${list.removeLast()}")

//            list.pop()

//            list.removeByValue(10)

//            list.removeByIndex(3)

//            list.nodeAt(10)?.let {
//                val node = Node(70, null)
//                list.insert(node, it)
//            }

//            println(list)

        }

    }// end fun onViewCreated

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}