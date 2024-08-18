package me.kunalbhagawati.InsertANodeAtASpecificPositionInALinkedList

import java.util.Scanner

class SinglyLinkedListNode(
    nodeData: Int,
) {
    public var data: Int
    public var next: SinglyLinkedListNode?

    init {
        data = nodeData
        next = null
    }
}

class SinglyLinkedList {
    public var head: SinglyLinkedListNode?
    public var tail: SinglyLinkedListNode?

    init {
        head = null
        tail = null
    }

    public fun insertNode(nodeData: Int) {
        var node = SinglyLinkedListNode(nodeData)

        if (head == null) {
            head = node
        } else {
            tail?.next = node
        }

        tail = node
    }
}

fun printSinglyLinkedList(
    head: SinglyLinkedListNode?,
    sep: String,
) {
    var node = head

    while (node != null) {
        print(node?.data)
        node = node?.next

        if (node != null) {
            print(sep)
        }
    }
}

/*
 * Complete the 'insertNodeAtPosition' function below.
 *
 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
 * The function accepts following parameters:
 *  1. INTEGER_SINGLY_LINKED_LIST llist
 *  2. INTEGER data
 *  3. INTEGER position
 */


fun insertNodeAtPosition(
    llist: SinglyLinkedListNode?,
    data: Int,
    position: Int,
): SinglyLinkedListNode? {
    require(llist != null) { "Head node cannot be null" }

    var currentPos = 0
    var headNode: SinglyLinkedListNode = llist
    var currentNode: SinglyLinkedListNode? = llist
    var parentNode: SinglyLinkedListNode? = null

    while (currentPos <= position) {
        if (position == currentPos) {
            val newNode = SinglyLinkedListNode(data)
            newNode.next = currentNode

            when (parentNode) {
                null -> headNode = newNode
                else -> parentNode.next = newNode
            }
            break
        }

        parentNode = currentNode
        currentNode = currentNode!!.next
        currentPos += 1

    }

    return headNode
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val llistCount = scan.also { print("List len: ") }.nextLine().trim().toInt()
    val llist = SinglyLinkedList()

    for (i in 0 until llistCount) {
        val llist_item = scan.also { print("Item ${i}: ") }.nextLine().trim().toInt()
        llist.insertNode(llist_item)
    }

    val data = scan.also { print("Data: ") }.nextLine().trim().toInt()

    val position = scan.also { print("Position: ") }.nextLine().trim().toInt()

    val llist_head = insertNodeAtPosition(llist?.head, data, position)

    printSinglyLinkedList(llist_head, " ")
}
