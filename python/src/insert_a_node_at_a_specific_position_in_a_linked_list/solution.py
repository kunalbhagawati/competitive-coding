#!/usr/bin/env python3

import os
from pathlib import Path
from sys import stdout
from typing import Any, Optional


class SinglyLinkedListNode:
    next: Optional['SinglyLinkedListNode']
    data: Any

    def __init__(self, node_data: Any):
        self.data = node_data
        self.next = None
        
    def __repr__(self):
        return f"<{self.data}>"


class SinglyLinkedList:
    tail: SinglyLinkedListNode | None
    head: SinglyLinkedListNode | None

    def __init__(self):
        self.head = None
        self.tail = None

    def insert_node(self, node_data: Any):
        node = SinglyLinkedListNode(node_data)

        if not self.head:
            self.head = node
        else:
            self.tail.next = node

        self.tail = node


def print_singly_linked_list(node, sep, fptr):
    while node:
        fptr.write(str(node.data))

        node = node.next

        if node:
            fptr.write(sep)


#
# Complete the 'insertNodeAtPosition' function below.
#
# The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
# The function accepts following parameters:
#  1. INTEGER_SINGLY_LINKED_LIST llist
#  2. INTEGER data
#  3. INTEGER position
#

#
# For your reference:
#
# SinglyLinkedListNode:
#     int data
#     SinglyLinkedListNode next
#
#

def insertNodeAtPosition(llist: SinglyLinkedListNode, data: Any, position: int) -> SinglyLinkedListNode:
    current_pos = 0
    head_node = llist
    current_node = llist
    parent_node = None

    assert current_node, "Constraint failure, list empty"

    while current_pos <= position:  # This assumes the constraint 0 <= position <= len(list) 
        # Otherwise, replace the node.
        if position == current_pos:
            new_node = SinglyLinkedListNode(data)
            new_node.next = current_node

            if parent_node is None:
                head_node = new_node
            else:
                parent_node.next = new_node

            break

        parent_node = current_node
        current_node = current_node.next
        current_pos += 1

    return head_node


if __name__ == '__main__':
    output_path = os.environ.get('OUTPUT_PATH', None)
    # if output_path then write to file else write to stdout
    if output_path:
        f = Path(os.environ['OUTPUT_PATH'])
        f.mkdir(parents=True, exist_ok=True)
        fptr = open(f / "soln.txt", 'w+')
    else:
        fptr = stdout


    llist_count = int(input("List Count: "))

    llist = SinglyLinkedList()

    for idx in range(llist_count):
        llist_item = int(input(f"Item {idx}: "))
        llist.insert_node(llist_item)

    data = int(input("Data: "))

    position = int(input("Position: "))

    llist_head = insertNodeAtPosition(llist.head, data, position)

    # Actual output ---
    fptr.write('\n')
    print_singly_linked_list(llist_head, ' ', fptr)
    fptr.write('\n')
    # ---

    fptr.close()
