class Node:
    def __init__(self,data):
        self.data=data
        self.next=None

class LinkedList:
    def __init__(self):
        self.head=None

    def Traverse(self):
        if self.head==None:
            print("Linked list is empty")
        else:
            n=self.head
            while n is not None:
                print(n.data,end="-->")
                n=n.next
            print(end="\n")
    
    def InsBeg(self,data):
        temp=Node(data)
        temp.next=self.head
        self.head=temp

    def InsEnd(self,data):
        temp=Node(data)
        if self.head is None:
            self.head=temp
        else:
            n=self.head
            while n.next is not None:
                n=n.next
            n.next=temp

    def InsAfter(self,data,x):
        n=self.head
        while n is not None:
            if x==n.data:
                break
            n=n.next
        if n is None:
            print("Node is not present")
        else:
            temp=Node(data)
            temp.next=n.next
            n.next=temp

    def DelBeg(self):
        x=self.head.data
        if self.head==None:
            print("List is empty")
        else:
            self.head=self.head.next
        return x

    def DelEnd(self):
        if self.head is None:
            print("List is empty")
        else:
            p=self.head
            while p.next.next is not None:
                p=p.next
            x=p.next.data
            p.next=None
        return x

    


l1=LinkedList()
l1.InsBeg(10)
l1.InsBeg(20)
l1.InsEnd(40)
l1.InsEnd(50)
l1.InsAfter(60,40)
l1.Traverse()
x=l1.DelBeg()
y=l1.DelEnd()
l1.Traverse()
print(x,y)

