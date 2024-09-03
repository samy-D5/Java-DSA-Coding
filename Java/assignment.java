import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
public class assignment {
    public static void additionOfDigit(int num) {
        int temp=0,n=num,sum=0;
        while(n>0){
            temp=n%10;
            sum+=temp;
            n/=10;
        }
        System.out.println(sum);
    }

    public static void reverse(int num) {
        int temp=0,ans=0;
        while(num>0){
            temp=num%10;
            ans=(ans*10)+temp;
            num/=10;
        }
        System.out.println(ans);
    }

    public static void sumAlternate(int n) {
        int sum=0;
        for(int i=1;i<=n;i++){
        if(i%2==0)   sum-=i;
        if(i%2!=0)   sum+=i;
        }
        System.out.println(sum);
    }

    public static void factorial(int n) {
        int ans=1;
        for(int i=1;i<=n;i++){
            ans*=i;
            System.out.print(ans+" ");
        }
        
    }

    public static void power(int a,int b) {
        int ans=1;
        for(int i=1;i<=b;i++){
            ans*=a;
        }
        System.out.println(ans);
    }

    public static void squarePattern(int r,int c) {
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0||i==r-1||j==0||j==c-1)
                System.out.print("*");
               else
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void triangle(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // *
    // **  
    // *** 
    // ****

    public static void triangle2(int n) {
        
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=1;j<=n-i;j++)  System.out.print(" ");
            //starts
            for(int k=1;k<=i;k++)   System.out.print("*");
            System.out.println();
        }
    }
//      *
//     **
//    ***
//   ****

    public static void traingle3(int n) {
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++)    System.out.print("*"+" ");
            System.out.println();
        }
    }
// * * * * 
// * * *   
// * *     
// * 

    public static void pyramid(int n) {
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=0;j<n-i;j++){  
                System.out.print(" "); 
            }
            //stars
            for(int k=0;k<(2*i)-1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
//     *   
//    ***  
//   ***** 
//  *******

    public static void numericalPattern(int r,int c) {
        for(int i=1;i<=r;i++){
            for(int j=i;j<=c;j++)   System.out.print(j+" ");
            for(int k=1;k<=i-1;k++)  System.out.print(k+" ");
        System.out.println();
        }
    }
// 1 2 3 4 
// 2 3 4 1 
// 3 4 1 2 
// 4 1 2 3 

    public static void numericalPattern2(int c,int r) {     
        for(int i=0;i<r;i++){
            for(int j=1;j<=c;j++)  System.out.print(j+" ");
        System.out.println();
        }
    }
// 1 2 3 4  
// 1 2 3 4 
// 1 2 3 4  
// 1 2 3 4  

    public static void numericalPattern3(int r,int c) {
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if((i+j)%2==0)    System.out.print(1+" ");
                else    System.out.print(2+" ");
            }
        System.out.println();
        }
    }
// 1 2 1 2 
// 2 1 2 1 
// 1 2 1 2 
// 2 1 2 1 

    public static void numericalPattern4(int r,int c) {
        for(int i=1;i<=r;i++){
            for(int j=1;j<=i;j++)   System.out.print(j+" ");
        System.out.println();
        }
    }
// 1 
// 1 2     
// 1 2 3   
// 1 2 3 4

    public static void numericalPattern5(int n) {
        for(int i=1;i<=n;i++){
            //space
            for(int s=1;s<=n-i;s++)    System.out.print(" ");
            //half numbers
            for(int j=1;j<=i;j++)  System.out.print(j);
            //other half numbers
            for(int j=i-1;j>0;j--)  System.out.print(j);
        System.out.println();
        }
    }
//      1   
//     121  
//    12321 
//   1234321

    public static void numericalPattern6(int n) {
        for(int i=1;i<=n;i++){
            //spaces
            for(int s=0;s<n-i;s++)     System.out.print(" ");
            //number
            for(int j=1;j<=2*i-1;j++){
                if(j==1 || j==2*i-1 || i==1 || i==n)    System.out.print(i);
                else  System.out.print(" ");
            }
        System.out.println();
        }
    }
// Hollow triangle
//      1   
//     2 2  
//    3   3 
//   4444444

    public static void fibbonacci(int n) {
        int sum=0,a=0,b=1;
        System.out.print(a+" "+b+" ");
        for(int i=1;i<n;i++){
            sum=a+b;
            a=b;
            b=sum;
            System.out.print(sum+" ");
        }
    }
//0 1 1 2 3 5 8 13 21 
    public static void fact(int n) {
    int sum = 1;
    for (int i = 1; i <= n; i++) {
        sum *= i;
        System.out.println(sum);
    }
}

    public static boolean armstrong(int n) {
        int num=n,temp=0,count=0,ans=0;
        while(num!=0){
            num/=10;
            count++;
        }
        num=n;
        while(num!=0){
            temp=num%10;
            ans+=Math.pow(temp, count);
            num/=10;
        }
        if(ans==n) return true;
        return false;
    }

    public static void armstrongNumber(int n) {
        for(int i=0;i<=n;i++){
            if(armstrong(i)==true) System.out.println(i);
        }
    }

    public static void freq(int[] arr,int n) {
        int[]freq=new int[1];
        for(int x:arr){
            if(x==n) freq[0]++;
        }
        System.out.println(freq[0]);
    }

    public static void sortNegPos(int[] arr,int l,int r) {
        while(l<r){
            if(arr[l]<0 && arr[r]>0){
                arr[l]=arr[l]^arr[r];
                arr[r]=arr[l]^arr[r];
                arr[l]=arr[l]^arr[r];
            l++;
            r--;
            }
            else if(arr[l]>0)  l++; 
            else if(arr[r]<0)  r--; 
            
        }
        for(int x:arr){
            System.out.print(x+" ");
        }
    }
//  1 5 6 3      -5 -5 -7 -4

    public static void sort(int[] a,int k) {
        Arrays.sort(a);
        System.out.println(a[k-1]);
    }

    public static void subArray(int[] arr,int sum) {
        int ans;
        for(int i=0;i<arr.length;i++){
            ans=0;
            for(int j=i;j<arr.length;j++){
                ans+=arr[j];
                if(ans>sum)     break;
                if(ans==sum){
                    System.out.print(i+" "+j);
                    return;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        for(int x:arr){
            System.out.print(x+" ");
        }
    }

    public static void printArray(int[][] arr) {
        for(int []x:arr){
            printArray(x);
            System.out.println();
        }
    }
    public static void isExist(int[][] a,int k) {
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]==k)  System.out.println(i+" "+j);
            }
        } 
    }

    public static void oneDToTwoD(int[] arr,int n,int m) {
        int[][]ans=new int[n][m];
        int index=0;
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                ans[i][j]=arr[index++];
            }
        }
        printArray(ans);
    }
//1,2,3,4,5,6,7,8
   // 1 2 3 4 
   // 5 6 7 8 

   public static void sumTwoD(int[][] arr,int r1,int c1,int r2,int c2) {
    int sum=0;
    for(int i=r1;i<=r2;i++){
        for(int j=c1;j<=c2;j++){
            sum+=arr[i][j];
        }
    }
    System.out.println(sum);
   }

  public static void reverseRow(int[][] arr) {
    for(int[]x:arr){
        pattern.reverse(x);
    }
    //printArray(arr);
  }

  public static int binarySearch(int[] arr,int k) {
    int left=0,right=arr.length-1,mid=0;
    while(left<=right){
        mid=(left+right)/2;
        if(arr[mid]==k) return mid;
        else if(arr[mid]>k)  right=mid-1;
        else    left=mid+1;
    }
    return -1;
  }

  public static void binarySearch2D(int[][] arr,int k) {
    for(int i=0;i<arr.length;i++){
        int index=binarySearch(arr[i], k);
        if(index!=-1){
             System.out.println("row: "+i+" "+"coloumn: "+index);
             return;
        }
    }
  }

  public static void multiply2D(int[][] arr,int[][]arr1) {
    int r1,c1,r2,c2;
    r1=arr.length;
    c1=arr[0].length;
    r2=arr1.length;
    c2=arr1[0].length;
    int [][]ans=new int[r1][c2];
    if(c1!=r2){
          System.out.println("Invalid Output !!!");
          return;
    }
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                for(int k=0;k<r2;k++){
                ans[i][j]+=arr[i][k]*arr1[k][j];
                }
            }
        }
        printArray(ans);
  }

  public static void rotate90InAntiClockwise(int[][] arr) {
    reverseRow(arr);
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<i;j++){
            arr[i][j]=arr[i][j]^arr[j][i];
            arr[j][i]=arr[i][j]^arr[j][i];
            arr[i][j]=arr[i][j]^arr[j][i];
        }
    }
    printArray(arr);
  }
//Input: 
//   {1,2,3},
//   {4,5,6},
//   {8,9,10}
//Output: 
// 3 6 10 
// 2 5 9  
// 1 4 8

  public static boolean toeplitz(int[][] arr) {
    for(int i=1;i<arr.length;i++){
        if(arr[i][i]==arr[0][0]) return true;
    }
    return false;
  }

  public static void isOverlapping(int[][] arr) {
    int[][] currIndex={{arr[0][0],arr[0][1]}};
    int ans=0;
    for(int i=1;i<arr.length;i++){
        if(!(arr[i][0]>=currIndex[0][0] && arr[i][1]<=currIndex[0][1])) ans++;
    }
    System.out.println(ans);
  }

  public static boolean isPerfect(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length; j++) {
            if(i==j){
                if(arr[i][j]==0) return false;
            }                
            else if(arr[i][j]!=0) return false;
        }
    }
    return true;
  }

  public static void upperTriangle(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
        for(int j=0;j<i;j++){
            System.out.print(" ");
        }
        for(int j=i;j<arr[0].length;j++){
            System.out.print(arr[i][j]);
        }
        System.out.println();
    }
  }

  
    public static void main(String[] args) {
        Integer [] arr={-1,8,-3,0,-9,6,-7,8};
        ArrayList <Integer> list=new ArrayList<>(Arrays.asList(arr));
        ArrayList <Integer> ans=new ArrayList<>();
        for(Integer x:list){
            if(x>=0)    ans.add(x);
        }
        Scanner sc= new Scanner(System.in);
        StringBuilder str=new StringBuilder(sc.nextLine());
        for(int i=0;i<str.length();i++){
            Boolean flag=true; //CAPITAL 
            int ascii = (int) str.charAt(i);
            if(ascii>=97) flag=false;
            else if(flag==true){
                 ascii+=32;
                }

        }


    }
}
