import java.util.ArrayList;

public class recursion {
    public static int oneToN(int n) {
        if(n==1)  return n;
        return oneToN(n+1);
    }

    public static int factorial(int n) {
        if(n==0||n==1){
            return 1;
        }
        return factorial(n-1)*n;  
    }

    public static int fibonacci(int n) {
        if(n==0||n==1) return n;
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static void Factorial1toN(int n) {
        if(n==1){
            System.out.println(n+" ");
            return;
        }
        Factorial1toN(n-1);
        System.out.println(factorial(n));
    }

    public static int factAddition(int s) {
        if(s==1){
            return 1;
        }
        return factAddition(s-1)+factorial(s);
    }

    public static int nto1Recursion(int n) {
        if(n==1|| n==0){
            return n;
        }
        return nto1Recursion(n-1)+fibonacci(n);
    }

    public static int sumOfDigits(int n) {
        if(n==0){
            return 0;
        }
        return sumOfDigits(n/10)+(n%10);
    }

    public static int intPow(int p,int q) {
        if(q==0){
            return 1;
        }
        int pow=intPow(p, q/2);
        if(q%2==0) return pow*pow;
        return p*pow*pow;
    }

    public static void multiplesK(int n,int k) {
        if(k==1){
            System.out.print(n+" ");
            return;
        }multiplesK(n,k-1);
        System.out.print(n*k+" ");
    }

    public static int alternateSum(int n) {
        if(n==1)    return 1;
        if(n%2!=0)  return alternateSum(n-1)+n;
        return  alternateSum(n-1)-n;
    }

    public static int gcd(int a,int b) {
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }

    public static boolean armstrong(int n) {
       int count=0;
       int copy=n,result=0;
        while(copy>0){
            count++;
            copy/=10;
        }copy=n;
        while(n>0){
            result+=Math.pow(n%10, count);
            n/=10;
        }
        if(result==copy) return true;
        return false;
    }

    public static int recusrionArmstrong(int num,int dig) {
        if(num==0) return 0;
        return intPow(num%10, dig)+recusrionArmstrong(num/10, dig);
    }

    public static int multiplication(int a,int b) {
        if(b==1) return a;
        return multiplication(a, b-1)+a;
    }

    public static void printArray(int[] arr,int index) {
        if(index==0){
             System.out.print(arr[index]+" ");
             return;} 
        
        printArray(arr, index-1);
        System.out.print(arr[index]+" ");
    }

    public static int maxElement(int[] arr,int index) {
        if(index==arr.length-1) return arr[index];
        maxElement(arr, index-1);
        if(arr[index]>arr[index+1]) arr[index+1]=arr[index];
        return arr[index+1];
    }

    public static int sumOfArrays(int[] arr,int index) {
        if(index==arr.length-1)    return arr[index];
        return sumOfArrays(arr, index+1)+arr[index];
    }

    public static boolean isExist(int[] arr,int k,int index) {
        if(index==arr.length) return false;
        if(arr[index]==k) return true;
        return isExist(arr, k, index+1);
    }

    public static ArrayList<Integer> findMultipleIndices(int[] arr,int target,int index) {
        if(index==arr.length)   return new ArrayList<>();
    ArrayList <Integer> ans=new ArrayList<>();
        if(arr[index]==target) ans.add(index);
        ans.addAll(findMultipleIndices(arr, target, index+1));
        return ans;
    }

    public static boolean isSorted(int[] arr,int index) {
        if(index==arr.length) return false;
        if(arr[index]>arr[index+1]) return false;
        return isSorted(arr, index+1);
    }

    public static String removeDuplicate(String str,char ch,int point) {
        StringBuilder sam=new StringBuilder();
        if(point==str.length()) return sam.toString();
        if(ch!=str.charAt(point)) sam.append(str.charAt(point)); 
        sam.append(removeDuplicate(str, ch,point+1));
        return sam.toString();
    }

    public static String nTo1String(String str) {
        if(str.length()==0)    return str;
        return nTo1String(str.substring(1))+str.charAt(0);
    }

    public static boolean isPalindrom(String str) {
        if(nTo1String(str).equals(str))     return true;
        return false;
    }

    public static boolean palindromeOptimized(String str,int l,int r) {
        if(l>=r) return true;
        return (str.charAt(l)==str.charAt(r)&&palindromeOptimized(str, l+1, r-1));
    }

    public static int numReverse(int n,int var) {
        if(n==0) return var;
        var=(var*10)+(n%10);
        return numReverse(n/10, var);
    }

    public static boolean numPalindrome(int n) {
      if(n==numReverse(n, 0))   return true;
      return false;
    }

    public static void revers(int[] arr) {
        int l=0,r=arr.length-1;
        while(l<r){
            arr[l]=arr[l]^arr[r];
            arr[r]=arr[l]^arr[r];
            arr[l]=arr[l]^arr[r];
            l++;
            r--;
        }
        for(int x:arr)  System.out.print(x+" ");
    }

    public static ArrayList<String> subsequence(String a) {
        ArrayList<String>str=new ArrayList<>();
        if(a.length()==0){
            str.add("");
            return str;
        }
        char ch=a.charAt(0);
        ArrayList<String> small=subsequence(a.substring(1));
        for(String x:small){
            str.add(x);
            str.add(ch+x);
        }
        return str;        
    }
    public static void subsequencePrint(String a,String ans) {
        if(a.length()==0){
            System.out.print(ans+" ");
            return;
        }
        char ch=a.charAt(0);
        subsequencePrint(a.substring(1), ans+ch);
        subsequencePrint(a.substring(1), ans);
    }

    public static void subsequenceSum(int[] arr,int sum,int index) {
        if(index==arr.length){
            System.out.print(sum+" ");
            return;
        }
        subsequenceSum(arr, sum+arr[index],index+1);
        subsequenceSum(arr,sum, index+1);
    }

    public static int frog(int[] arr,int index) {
        if(index==arr.length-1)     return 0;
        if(index==arr.length-2)     return Math.abs(arr[index]-arr[index+1]);
        int op1=Math.abs(arr[index]-arr[index+1])+frog(arr, index+1);
        int op2=Math.abs(arr[index]-arr[index+2])+frog(arr, index+2);
        return Math.min(op1,op2);
    }

    public static int frogJump(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length-2;i++)
             sum+=Math.abs(arr[i]-Math.min(arr[i+1],arr[i+2]));
        return sum;
    }

    public static void keypadCombination(String dig,String[] kp,String ans) {
        if(dig.length()==0){
            System.out.print(ans+" ");
            return;
        }
        int num=dig.charAt(0)-'0';
        String temp=kp[num];
        for(int i=0;i<temp.length();i++){
            keypadCombination(dig.substring(1), kp, ans+temp.charAt(i));
        }
    }

    //assignments:-
    public static void arithmatic(int n) {
        if(n<0){
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" ");
        arithmatic(n-5);
        System.out.print(n+" ");
    }

    public static int sumRecurrion(int n,int m) {
        if(m==1)    return oneToN(n);
        return sumRecurrion(sumRecurrion(n, m-1), 1);
    }

    public static int power(int a,int b) {
        if(b==1){
            return a;
        }
        return power(a, b-1)*a;
    }

    public static int axb(int a,int b) {
        if(b==1){
            return a;
        }
        return axb(a, b-1)+a;
    }

    public static boolean prime(int n,int div) {
        if(div==2 && n%div!=0)    return true;
        if(n%div!=0 && prime(n, div-1)) return true;
        else return false;
    }

    public static int decToBinary(int n) {
        if(n==0||n==1) return n;
        return decToBinary(n/2)*10+n%2;
    }

    public static int grayCode(int bin) {
        if(bin==0||bin==1) return bin;
        int a=bin%10;
        int gray=grayCode(bin/10);
        bin=bin/10;
        int b=bin%10;
        return (gray*10)+(a^b);
    }

    public static void armstrongRecurr(int n) {
        
    }

    public static void insertion(int[] arr,int index) {
        if(index<0) return ;
        if(arr[index]>arr[index-1]) sort.swap(arr, index, index-1);
         insertion(arr, index-1);
         System.out.print(arr);
    }

    public static boolean binarySearch(int[] arr,int start,int end,int key) {
        if(start>end) return false;
        int mid=(start+end)/2;
        if(key<arr[mid]){
            return binarySearch(arr, start, mid-1, key);
        }
        else if(key>arr[mid]) return binarySearch(arr, mid+1, end, key);
        return key==arr[mid];

    }

    public static void main(String[] args) {
        String str="racecar";
        int []arr={10,20,30,40,50,60};
        String[] kp={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        System.out.println(binarySearch(arr, 0, arr.length-1, 30));
    }
}
