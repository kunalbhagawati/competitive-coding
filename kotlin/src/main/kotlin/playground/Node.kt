package me.kunalbhagawati.playground

import java.util.UUID

data class Node<T>(
    val value: T,
    val left: Node<T>? = null,
    val right: Node<T>? = null,
) {
    @Suppress("unused")
    private val id: UUID = UUID.randomUUID()

    constructor(value: T, left: T, right: T) : this(value = value, left = Node<T>(left), right = Node<T>(right))
    constructor(value: T, left: Node<T>, right: T) : this(value = value, left = left, right = Node<T>(right))
    constructor(value: T, left: T, right: Node<T>) : this(value = value, left = Node<T>(left), right = right)

    fun draw(depth: Int = 0): String {
        val t = "\t".repeat(depth)

        fun drawChildNode(n: Node<T>?): String {
            var s = "\n$t├ "
            if (n == null) {
                s += "⤫"
                return s
            }
            s += n.draw(depth + 1)
            return s
        }

        var r = "\"${value}\""
        r += drawChildNode(left)
        r += drawChildNode(right)
        return r
    }

    override fun toString(): String {
        fun childToString(n: Node<T>?): String {
            if (n == null) {
                return "⤫"
            }
            var r = "❬ \"${n.value}\""
            if (n.left != null || n.right != null) {
                r += " ... "
            }
            r += " ❭"
            return r
        }
        return "❬ \"${value}\" | L: ${childToString(left)} / R: ${childToString(right)} ❭"
    }
}

fun main() {
    val tree = Node('k', Node('b', 'a', 'c'), 'B')
    println(tree)
    println(tree.draw())
}
