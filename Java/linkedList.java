public class linkedList {
    public static void main(String[] args) {
        // node a=new node(1);
        // node b=new node(2);
        // node c=new node(3);
        // node d=new node(4);
        // node e=new node(5);
        // node f=new node(7);

        // a.next=b;
        // b.prev=a;
        // b.next=c;
        // c.next=d;
        // d.next=e;
        // e.next=f;

        doublyLinked l=new doublyLinked();
        l.append(1);
        l.append(4);
        l.append(5);
        l.append(6);
        l.append(8);
        l.append(9);
        l.append(10);
       
        linked ll= new linked();
        ll.append(3);
        ll.append(5);
        ll.append(4);
        ll.append(1);
        ll.append(2);
        ll.append(8);
        
        //l.displayReverse(l.tail);
        // l.inserAt(5, 9);
        // l.deleteAt(6);
        //l.display(l.head);
        circularLinkedList c=new circularLinkedList(ll.head);
        circularLinkedList cc=new circularLinkedList(l.head);
        // cc.deleteHeadDoubly(cc.doublyCircularHead);
        //System.out.println(cc.palindrome());
        
        //cc.dbDisplay(cc.doublyCircularHead);
        cc.checkSum(13);
        //c.deleteHead(c.circularHead);
       // c.display(c.circularHead);
        
        // ll.display(ll.deepcopy(ll.head));  
        //ll.inserAtBegin(5055);
       // ll.insertAt(-2, 90);
        //System.out.println(ll.getAt(ll.size()-1));
        //ll.insertAtEnd(69);
        //ll.deleteAt(6);
        //System.out.println(ll.nthNode2(ll.head, 2));
        //ll.deleteNthNodeFromLast(ll.head, 2);
        //ll.display(ll.oddEven(ll.head));
        //System.out.println(ll.findLeftMiddleNode(ll.head));
        // System.out.println(ll.size());
        //System.out.println(ll.tail.data);
    }
}

 class linked {
    node head=null;
    node tail=null;
    int size=0;
    void append(int val){
        node temp=new node(val);
        if(head==null) head=temp;
        else tail.next=temp;
        tail=temp;
        size++;
    }
    void inserAtBegin(int val){
        node temp=new node(val);
        if(head==null) tail=temp;
        else temp.next=head;
        head=temp;
        size++;
    }
    void insertAt(int index,int val){
        node t=new node(val);
        node temp=head;
        if(index<0 || index>size) 
            throw new IllegalArgumentException("Enter valid index ");
        else if(index==0){
            inserAtBegin(val);
            size++;
            return;
        }else if(index==size){
            append(val);
            size++;
            return;
        }
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        t.next=temp.next;
        temp.next=t;
        size++;
    }
    int getAt(int index){
        node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.data;
    }
    void insertAtEnd(int val){
        node temp=new node(val);
        node t=head;
        for(int i=0;i<size()-1;i++){
            t=t.next;
        }
        t.next=temp;
        size++;
    }
    void deleteAt(int index){
        node temp=head;
        if(index==0){
            head=temp.next;
            size--;
            return;
        }
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        if(index==size-1){
            tail.next=null;
            tail=temp;
            size--;
            return;
        }
        temp.next=temp.next.next;
        size--;
    }
    void display(){
        node.display(head);
        System.out.println();
    }
    void display(node head){
        node.display(head);
        System.out.println();
    }
    int size(){
        return size;
    }
    
    int nthNode2(node head, int n) {
        node slow = head;
        node fast = head;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    void deleteNthNodeFromLast(node head, int n){
        node slow=head;
        node fast=head;
        for(int i=1;i<=n+1;i++)
            fast=fast.next;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
    }

    int findLeftMiddleNode(node head){
        node slow=head;
        node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }

    node oddEven(node head){
        node t = head;
        node tempe = new node(-1);
        node tempo = new node(9);
        node newHead = tempo;
        head = tempe;
        while (t != null) {
            if (t.data % 2 == 0) {
                tempe.next = t;
                tempe = tempe.next;
            } else {
                tempo.next = t;
                tempo = tempo.next;
            }
            t = t.next;
        }
        head = head.next;
        tempe.next = null;
        tempo.next = head;
        return newHead.next;
    }

    node deepcopy(node head){
        linked ll = new linked();
        for(node temp=head;temp!=null;temp=temp.next){
            ll.append(temp.data+1);
        }
        return ll.head;
    }
}


 
class node {
    int data;
    node next;
    node prev;

    public node(int data) {
        this.data = data;
    }

    public static void displayrecurr(node head) {
        if (head == null)
            return;
        System.out.print(head.data+" ");
        displayrecurr(head.next);
    }

    public static void display(node temp) {
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static int length(node start) {
        int count=0;
        while (start != null) {
            count++;
            start = start.next;
        }
        return count;
    }

    public static int lengthRecurr(node start) {
        if(start==null) return 0;
        return 1+lengthRecurr(start.next);
    }
}

class doublyNode{
    int data;
    doublyNode next;
    doublyNode prev;
    doublyNode(int data){
        this.data=data;
    }
}

class doublyLinked{
    doublyNode head=null;
    doublyNode tail=null;
    doublyNode prev=null;
    int size;

    void append(int val){
        doublyNode next=new doublyNode(val);
        if(head==null) head=next;
        else tail.next=next;
        tail=next;
        next.prev=prev;
        prev=next;
        size++;
    }

    void display(doublyNode head){
        for(doublyNode temp=head;temp!=null;temp=temp.next){
            System.out.print(temp.data+" ");
        }
        System.out.println();
    }

    void displayReverse(doublyNode tail){
        for(doublyNode temp=tail;temp!=null;temp=temp.prev){
            System.out.print(temp.data+" ");
        }
        System.out.println();
    }

    void inserAt(int index, int val){
        if(index==size) append(val);
        else if(index==0){
            doublyNode temp=new doublyNode(val);
            head.prev=temp;
            temp.next=head;
            head=temp;
            size++;
        }else{
            doublyNode temp=new doublyNode(val);
            doublyNode t=head;
            for(int i=1;i<index;i++){
                t=t.next;
            }
            t.next.prev=temp;
            temp.prev=t;
            temp.next=t.next;
            t.next=temp;
        }
    }

    void deleteAt(int index){
        doublyNode temp=head;
        if(index==0){
            head=head.next;
            head.prev=null;
        }else if(index==size-1){
            for(;temp.next.next!=null;temp=temp.next){}
            temp.next=null;
            tail=temp;
        }else{
            for(int i=1;i<index;i++){
                temp=temp.next;
            }
            temp.next.next.prev=temp;
            temp.next=temp.next.next;
            
        }size--;
    }   
}

class circularLinkedList{
    node circularHead=null;
    doublyNode doublyCircularHead=null;
    int size=1;
    public circularLinkedList(node head){
        node temp=head;
        for(;temp.next!=null;temp=temp.next){}
        temp.next=head;
        circularHead=head;
    }
    public circularLinkedList(doublyNode head){
        doublyNode temp=head;
        for(;temp.next!=null;temp=temp.next){}
        temp.next=head;
        head.prev=temp;
        doublyCircularHead=head;
    }

   void deleteHead(node head){
    node temp=head;
    for(;temp.next!=head;temp=temp.next){}
    temp.next=temp.next.next;
    circularHead=temp.next;
    }

    void deleteHeadDoubly(doublyNode head){
        doublyNode temp=head;
        temp.next.prev=temp.prev;
        temp.prev.next=temp.next;
        doublyCircularHead=temp.next;
    }

    boolean palindrome(){
        doublyNode t=doublyCircularHead;
        doublyNode f=doublyCircularHead.prev;
        while(t!=f){
            if(t.data!=f.data) return false;
            t=t.next;
            f=f.prev;
        }
        return true;
    }

    void checkSum(int target){
        doublyNode h=doublyCircularHead;
        doublyNode t=doublyCircularHead.prev;
        while(h.data<t.data){
            if(h.data+t.data==target){
                System.out.println(h.data+" "+t.data);
                return;
            }
            if(h.data+t.data>target) t=t.prev;
            if(h.data+t.data<target) h=h.next;
        }
    }

    void criticalPoint(){
        int min=size;
        int max=1;
        doublyNode t=doublyCircularHead.next;
        doublyNode arr[]=new doublyNode[size];
    }

    void display(node t){
        for(;t.next!=circularHead;t=t.next){
            System.out.print(t.data+" ");
            size++;
        }System.out.println(t.data);
    }
    void dbDisplay(doublyNode t){
        for(;t.next!=doublyCircularHead;t=t.next){
            System.out.print(t.data+" ");
            size++;
        }System.out.println(t.data);
    }
}