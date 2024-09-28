class Tree:
    def __init__(self,data):
        self.deta=data
        self.left=None
        self.right=None

class Level:
    def __init__(self,level,node):
        self.level=level
        self.node=node

node = Tree(20)
node1 = Tree(8)
node2 = Tree(22)
node3 = Tree(5)
node4 = Tree(3)
node5 = Tree(25)
node6 = Tree(10)
node7 = Tree(14)

node.left=node1
node.right=node2

node1.left=node3
node1.right=node4

node2.right=node5

node4.left=node6
node4.right=node7

li=[Level(0,node)]

dicctionary={}

dicctionary.update({0:node.deta})

while len(li)>0:
    level=li.pop(0)

    if level.node.left!=None:
        dicctionary.update({level.level-1:level.node.left.deta})
        li.append(Level(level.level-1,level.node.left))
        print(44,len(li))

        print(dicctionary)
    print(level.node.right,47)
    if level.node.right!=None:
        dicctionary.update({level.level+1:level.node.right.deta})
        li.append(Level(level.level+1,level.node.right))
        print(51,len(li))

        print(dicctionary)
    print(54,len(li))



print(dicctionary)
li=[]
li.sort()









