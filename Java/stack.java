import java.util.*;

import org.w3c.dom.Node;
public class stack{

    public static void reverse(Stack<Integer>st) {
    //reverse the order
    Stack<Integer> rt=new Stack<>();
    while(st.size()>0){
        //int x=st.peek();
        rt.push(st.pop());
    }
    System.out.println(rt);
    }

    public static void insertAt(Stack<Integer>st,int index,int element) {
        Stack<Integer> rt=new Stack<>();
        while(st.size()>index){
            rt.push(st.pop());
        }
        st.push(element);
        while(rt.size()>0){
            st.push(rt.pop());
        }
        System.out.println(st);
    }
    public static void insertAtUsingArray(Stack<Integer>st,int index,int element) {
        int[] arr=new int[50];
        int count=0;
        while(st.size()>0){
            arr[count++]=st.pop();
        }
        st.push(element);
        for(int i=count-1;i>0;i--){
            st.push(arr[i]);
        }
        System.out.println(st);
    }

    public static void print(Stack<Integer>st) {
        Stack<Integer> rt=new Stack<>();
        while(st.size()>0){
            rt.push(st.pop());
        }
        while(rt.size()>0){
            System.out.println(st.push(rt.pop()));
        }
    }

    public static void printRec(Stack<Integer>st) {
        if(st.size()==0) return;
        int x=st.pop();
        printRec(st);
        System.out.print(x+" ");
        st.push(x);
    }

    public static void insertAtRec(Stack<Integer>st,int index,int element) {
       if(st.size()==index){
            st.push(element);
       }
        int x=st.pop();
        insertAt(st, index, element);
        st.push(x);
    }

    public static void reverseStack(Stack<Integer>st) {
        if(st.size()==1) return;
        int x=st.pop();
        reverseStack(st);
        insertAtBottom(st, x);
    }

    public static void insertAtBottom(Stack<Integer>st,int element) {
        if(st.size()==0){
            st.push(element);
            return;
        }
        int x=st.pop();
        insertAtBottom(st, element);
        st.push(x);
    }

    public static void removeIndexRec(Stack<Integer>st,int index) {
        if(st.size()==index+1){
            st.pop();
            return;
        }
        int temp=st.pop();
        removeIndexRec(st, index);
        st.push(temp);
    }

    public static void removeIndex(Stack<Integer>st,int index) {
        Stack<Integer> rt = new Stack<>();
        while(st.size()>index+1){
            rt.push(st.pop());
        }
        st.pop();
        while (rt.size()>0) {
            st.push(rt.pop());
        }
    }

    public static void reverseUsingArray(Stack<Integer>st) {
        int [] arr = new int[st.size()];
        int count=0;
        while(st.size()>0)  arr[count++]=st.pop();
        for(int i=0;i<count;i++)  st.push(arr[i]); 
    }

    public static void reverseUsing3Stack(Stack<Integer>st) {
        Stack<Integer> rt = new Stack<>();
        Stack<Integer> ut = new Stack<>();
        while(st.size()>0) rt.push(st.pop());
        while(rt.size()>0) ut.push(rt.pop());
        while(ut.size()>0) st.push(ut.pop());
    }

    public static int MinNum(String str){
        int ans=0;
        Stack<Character> s=new Stack<>();
        for(char x:str.toCharArray()){
            if(x=='('){
                s.push(x);
            }
            else{
                if(s.size()>0) s.pop();
                else ans++;
            }
        }
        return ans+s.size();
    }

    public static void checkRepetative(int[] arr){
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(stk.size()==0) stk.push(arr[i]);
            else if(i<arr.length-1){
                if(stk.peek()==arr[i]){
                    if(arr[i]!=arr[i+1]) stk.pop();
                }else stk.push(arr[i]);
            }else{
                if(arr[i]!=arr[i-1]) stk.push(arr[i]);
                else stk.pop();
            }
        }
        System.out.println(stk);
    }

    public static void nextGreater(int[] arr){
        Stack<Integer> stk = new Stack<>();
        stk.push(arr[arr.length-1]);
        arr[arr.length-1]=-1;
        for(int i=arr.length-2;i>=0;i--){
            int temp=arr[i];
            while(stk.size()>0 && arr[i]>stk.peek()) stk.pop();
            if(stk.size()==0) arr[i]=-1;
            else arr[i]=stk.peek();
            stk.push(temp);
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void nextGreater2(int[] arr) {
        myStack stk = new myStack();
        int[] ans=new int[arr.length];
        stk.pushh(0);
        for(int i=1;i<arr.length;i++){
            while(stk.sizee()>0 && arr[i]>arr[stk.peekk()])
                ans[stk.popp()]=arr[i];
            stk.pushh(i);
        }
        while(stk.sizee()>0) ans[stk.popp()]=-1;
        for(int i=0;i<arr.length;i++){
            System.out.print(ans[i]+" ");
        }
    }

    public static void prevGreater(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        stk.push(arr[0]);
        arr[0]=-1;
        for(int i=1;i<arr.length;i++){
            int temp=arr[i];
            while(stk.size()>0 && arr[i]>stk.peek()) stk.pop();
            if(stk.size()==0) arr[i]=-1;
            else arr[i]=stk.peek();
            stk.push(temp);
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
public static void main(String args[]){
    Stack<Integer> st= new Stack<>();
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);
    st.push(5);
    st.push(6);
     //reverse(st);
    // insertAt(st, 5, 4);
    //insertAtUsingArray(st, 0, 0);
    //reverseStack(st);
    //removeIndex(st, 2);
    //reverseUsingArray(st);
    //reverseUsing3Stack(st);
    // myStack s = new myStack();
    // s.pushh(1);
    // System.out.println(s);
    // s.pushh(2);
    // System.out.println(s);
    // s.peekk();
    // System.out.println(s);
    // s.pushh(3);
    // s.popp();
    // System.out.println(s);
    // s.pushh(4);
    // System.out.println(s);
    // s.sizee();
    // System.out.println(s);
    //System.out.println(st);
    // printRec(st);
    myLinkedList ll=new myLinkedList();
    ll.push(1);
    ll.push(1);
    ll.push(1);
    ll.push(1);
    ll.push(1);
    //System.out.println(ll);
    //System.out.println(MinNum("(()())))()()(()))"));
    int[] arr={1,5,8,7,4,3,7};
    //checkRepetative(arr);
    nextGreater2(arr);
    //prevGreater(arr);
}
}

class myStack{
    int[] arr=new int[50];
    int index=-1;
    public void pushh(int element) {
        // if(isFull()==true){
        //      System.out.println("Stack is Full!");
        //      return;
        //     }
        arr[++index]=element;
    }
    public int popp() {
        // if(isEmpty()==true){
        //     System.out.println("Stack is Empty!");
        //     return -1;
        // }
        return arr[index--];
    }
    public int peekk() {
        return arr[index];
    }
    int sizee(){
        return index+1;
    }
    boolean isEmpty(){
        if(index==0) return true;
        return false;
    }
    boolean isFull(){
        if(index==arr.length) return true;
        return false;
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<=index;i++){
            str.append(arr[i]+",");
        }
        return str.toString();
    }
}

class myLinkedList{
    node t=new node(100);
    node head=t.next;
    int size=0;
    public void push(int x){
        node temp=new node(x);
        temp.next=head;
        head=temp;
        size++;
    }
    public int pop(){
        int x=head.data;
        head=head.next;
        size--;
        return x;
    }
    int size(){
        return size;
    }
    boolean isEmpty(){
        return size==0;
    }
    int peek(){
        return head.data;
    }
    public String toString(){
        StringBuilder sb=new StringBuilder();
        Stack<Integer> m=new Stack<>();
        for(node temp=head;temp!=null;temp=temp.next){
            m.push(temp.data);
        }
        sb.append("[");
        while(m.size()>0){
            sb.append(m.pop()+",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }
}