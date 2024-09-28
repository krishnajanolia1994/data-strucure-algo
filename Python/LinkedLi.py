class Node :
    def __init__(self,data) :
        self.dada=data
        self.next=None


head=None

def reverse(h):
    if(h.next==None):
        return h
    next=reverse(h.next)
    next.next=h
    h.next=None
    return h

if head==None:
    head= Node(5)

node= Node(7)
tail=head

while tail.next!=None:
    tail=tail.next
tail.next=node

print(head)
node= Node(8)
tail=head
while tail.next!=None:
    tail=tail.next
tail.next=node
print(head)

node= Node(9)
tail=head
while tail.next!=None:
    tail=tail.next
tail.next=node

node= Node(15)
tail=head
while tail.next!=None:
    tail=tail.next
tail.next=node

print(head)
temp=head
while temp!=None :
    print(temp.dada)
    temp=temp.next

temp=head


temp=head  
while temp!=None:
    print(type(temp.dada),temp.dada)
    da=int(temp.dada)
    if da==8:
       break
    temp=temp.next
if temp!=None:
    next=None
    if temp.next!=None:
        next=temp.next
    node=Node(100)
    temp.next=node
    node.next=next

temp=head
while temp!=None :
    print(temp.dada)
    temp=temp.next

temp=head
tail=head
while tail.next!=None:
    tail=tail.next
reverse(temp)
print()
head=tail

while(tail!=None):
    print(tail.dada)
    tail=tail.next

prev = Node(13)

dummy=prev
print(prev.dada)

newHead=None

next=None
nextnext=None
found=True
while head!=None and head.next!=None:
    print(head.dada,"h")
    next=head.next
   
    

    nextnext=next.next
    
    next.next=head
    head.next=nextnext

    
    prev.next=next

    prev=head
    head=nextnext

print()
while dummy!=None:
    print(dummy.dada)
    dummy=dummy.next






