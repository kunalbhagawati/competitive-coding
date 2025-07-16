from dataclasses import dataclass
from typing import Optional
from uuid import UUID, uuid4


@dataclass
class Node:
    val: str

    id: UUID | None = None
    left: str | Optional["Node"] = None
    right: str | Optional["Node"] = None

    def __post_init__(self):
        if self.id is None:
            self.id = uuid4()

        if isinstance(self.left, str):
            self.left = Node(self.left)

        if isinstance(self.right, str):
            self.right = Node(self.right)

    def find(self, val: str) -> Optional["Node"]:
        if self.val == val:
            return self

        if self.left is not None:
            node = self.left.find(val)
            if node is not None:
                return node

        if self.right is not None:
            node = self.right.find(val)
            if node is not None:
                return node

        return None

    def draw(self, depth=0) -> str:
        t = "\t" * depth

        def draw_child_node(n) -> str:
            s = f"\n{t}├ "
            if not n:
                s += "⤫"
                return s
            s += n.draw(depth + 1)
            return s

        r = f'"{self.val}"'
        r += draw_child_node(self.left)  # draw left node recursively
        r += draw_child_node(self.right)  # draw right node recursively
        return r

    def __repr__(self) -> str:
        def child_repr(n) -> str:
            if n is None:
                return "⤫"
            r = f'❬ "{n.val}"'
            if n.left or n.right:
                r += " ... "
            r += " ❭"
            return r

        return (
            f'❬ "{self.val}" | L: {child_repr(self.left)} R: {child_repr(self.right)} ❭'
        )


if __name__ == "__main__":
    tree = Node("k", left=Node('u', left='a', right=Node('l')), right=Node('B', left='h'))

    print(tree)
