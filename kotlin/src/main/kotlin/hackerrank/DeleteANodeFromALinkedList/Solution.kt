/**
 * https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem?isFullScreen=true
 */
package me.kunalbhagawati.hackerrank.DeleteANodeFromALinkedList

import java.util.Scanner

class SinglyLinkedListNode(nodeData: Int) {
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

fun printSinglyLinkedList(head: SinglyLinkedListNode?, sep: String) {
    var node = head;

    while (node != null) {
        print(node?.data)
        node = node?.next

        if (node != null) {
            print(sep)
        }
    }
}

/*
 * Complete the 'deleteNode' function below.
 *
 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
 * The function accepts following parameters:
 *  1. INTEGER_SINGLY_LINKED_LIST llist
 *  2. INTEGER position
 */

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     data: Int
 *     next: SinglyLinkedListNode
 * }
 *
 */

fun deleteNode(llist: SinglyLinkedListNode?, position: Int): SinglyLinkedListNode? {
    require(llist != null) {"Condition failed, Head node cannot be null"}
    
    var currentNode: SinglyLinkedListNode? = llist
    var headNode = llist
    var currentPos = 0
    var parentNode: SinglyLinkedListNode? = null
    
    while (currentPos <= position) {
        if (currentNode == null) // reached ending of list.
            break
        
        if (position == currentPos) {
            when(parentNode) {
                null -> headNode = currentNode.next
                else -> parentNode.next = currentNode.next
            }
            break
        } 
        
        // Iterate over the list.
        parentNode = currentNode
        currentNode = currentNode.next
        currentPos += 1
    }
    
    return headNode
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val llistCount = scan.also { print("Len List: ") }.nextLine().trim().toInt()
    val llist = SinglyLinkedList()

    for (i in 0 until llistCount) {
        val llist_item = scan.also { print("Item ${i}: ") }.nextLine().trim().toInt()
        llist.insertNode(llist_item)
    }

    val position = scan.also { print("Position: ") }.nextLine().trim().toInt()

    val llist1 = deleteNode(llist?.head, position)

    printSinglyLinkedList(llist1, " ")
}
