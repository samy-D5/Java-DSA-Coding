public class linked {
    public static void main(String[] args) {
        link ll=new link();
        ll.append(10);
        ll.append(20);
        ll.append(30);
        ll.append(40);
        ll.append(50);
        ll.append(60);
        //ll.insertAtBegin(5);
        System.out.println(ll.size);
        //System.out.println(ll.getAt(4));
        //ll.insertAt(5, 0);
        ll.deleteAt(ll.size()-1);
        ll.display();
        System.out.println(ll.tail.data);
    }
    
}
class node{
    int data;
    node next;
    
    public node(int data){
        this.data = data;
    }

    public static void displayrecur(node head) {
        if(head==null) return;
        System.out.print(head.data+" ");
        displayrecur(head.next);        
    }
}

class link{
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

    void insertAtBegin(int val){
        node temp=new node(val);
        if(head==null) tail=temp;
        else temp.next=head;
        head=temp;
    }

    int getAt(int index){
        node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.data;
    } 

    void insertAt(int index,int val){
        node t=new node(val);
        node temp=head;
        if(index<0 || index>size-1)
            throw new IllegalArgumentException("Not valid! ");
        if(index==0){
            insertAtBegin(val);
            size++;
            return;
        }if(index==size-1){
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

    void deleteAt(int index){
        node temp=head;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if(index==0){
            head=head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            return;
        }
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        if(temp.next==tail){
            tail=temp;
            size--;
        }
        temp.next=temp.next.next;
        size--;
    }

    int size(){
        return size;
    }
    void display(){
        node.displayrecur(head);
        System.out.println();
    }
}
