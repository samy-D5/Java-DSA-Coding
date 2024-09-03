import java.util.*;
public class pattern {
    public static void patternFun(int n){
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=n-i;j>=1;j--){
                System.out.print(" ");
            }
            //numbers
            int count=1;
            for(int k=1;k<=(2*i)-1;k++){
              if(k<=((2*i)-1)/2) System.out.print(count+++" ");
              else System.out.print(count--+" ");
            }
            System.out.println();
        }
    }

    public static void butterfly(int n){
        for(int i=1;i<=n;i++){
            //stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            //spaces
            for(int j=1;j<=(n*2)-(i*2);j++){
                System.out.print(" ");
            }
            //stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n-1;i>=1;i--){
            //stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            //spaces
            for(int j=1;j<=(n*2)-(i*2);j++){
                System.out.print(" ");
            }
            //stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void binaryToDecimal(int binary){
        int dec=0,count=0;
        while(binary>0){
            if(binary%10==1)
                dec+=Math.pow(2, count);
                count++;
                binary/=10;
        }
        System.out.println(dec);
    }

    public static void decToBin(int dec){
        int bin=0,count=0;
    
        while(dec>0){
                bin+=dec%2*Math.pow(10, count);
                count++;
                dec/=2;
        }
        System.out.println(bin);
    }

    public static void arrayToFound(int[]arr,int key){
        for(int x:arr){
            if(x==key){
               System.out.println("Found");
                return; 
            } 
        }
        System.out.println("Not");
    }

    public static void minAndMaxArray(int[]arr){
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int x:arr){
            if(x<min) min=x;
            if(x>max) max=x;
        }
        System.out.println(min+" "+max);
    }

    public static boolean sorted(int[]arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]) return false;
        }
        return true;
    }

    public static int repeatedNumber(int[]arr) {
        
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]) return arr[i];
        }
        return -1;
    }

    public static void reverse(int[]arr,int left,int right) {
       while(left<right){
        arr[left]=arr[left]^arr[right];
        arr[right]=arr[left]^arr[right];
        arr[left]=arr[left]^arr[right];
        left++;
        right--;
       }
    }
    public static void reverse(int[] arr) {
       int left=0,right=arr.length-1;
        while(left<right){
            arr[left]=arr[left]^arr[right];
            arr[right]=arr[left]^arr[right];
            arr[left]=arr[left]^arr[right];
            left++;
            right--;
           }
    }

    public static void check(int[]arr,int k) {
        for(int x:arr){
            if(arr[x]==k) {System.out.println("True");
        }
        else System.out.println("False");
        }
        
    }
    public static void printArray(int[]arr) {
        for(int x:arr) System.out.print(x+" ");
        
    }
    public static void printArray(int[][]arr) {
        for(int x[]:arr){
            for(int y:x){
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }

    public static void rotate(int []arr,int k){
        int n=arr.length-1;
        reverse(arr, 0, n-k-1);
        reverse(arr, n-k, n);
        reverse(arr, 0, n);
       printArray(arr);
    }

    public static void frequency(int[]arr) {
        int[] freq=new int[arr.length];
        for(int x:arr) freq[x]++;
        printArray(freq);
    } 

    public static void twoDArrayMulti(int[][] m,int[][] n) {
        int r1,r2,c1,c2;
        r1=m.length;
        r2=m[0].length;
        c1=n.length;
        c2=n[0].length;
        if(r2!=c1) {
            System.out.println("Cannot be multiplied");
            return;
        }
        int result[][] = new int[r1][c2];
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                for(int k=0;k<c1;k++){
                    result[i][j]+=(m[i][k]*n[k][j]);
                }
            }
        }
        printArray(result);
    }

    public static int[][] transpose(int[][] m) {
        int r,c;
        r=m.length;
        c=m[0].length;
        int[][]result=new int[c][r];
        for(int i=0;i<c;i++){
            for(int j=0;j<r;j++){
                result[i][j]=m[j][i];
            }
        }
        // printArray(result);
        return result;
    }

    public static void rotate90degree(int[][] arr) {
        arr=transpose(arr);
        for(int x[]:arr) {
            reverse(x);
        }
        printArray(arr);
    }

    public static void pascal(int n) {
        int ans[][]=new int[n][];
        for(int i=0;i<n;i++){
            ans[i]=new int[i+1];
            for(int j=0;j<ans[i].length;j++){
                if(j==0||j==ans[i].length-1) ans[i][j]=1;
                else ans[i][j]=(ans[i-1][j]+ans[i-1][j-1]);
            }
        }
        printArray(ans);
    }
    
    public static void sort01(int[] arr) {
        int []freq=new int[2];
        for(int x:arr){
            if(x%2==0) freq[0]++;
            else freq[1]++;
        }
        
    }
    public static void sortedSquare(int[] arr) {
        int ans[]=new int[arr.length];
        int count=arr.length-1;
        int left=0,right=arr.length-1;
        while(left<right){
            ans[count--]=Math.max(Math.abs(arr[left]), Math.abs(arr[right]));
            ans[count--]=Math.min(Math.abs(arr[left]), Math.abs(arr[right]));
            left++;
            right--;
        }
        for(int i=0;i<ans.length;i++) ans[i]*=ans[i];
        printArray(ans);
    }

    public static void prefixSum(int[] arr) {
        for(int i=1;i<arr.length;i++){
            arr[i]+=arr[i-1];
        }
        // printArray(arr);
    }

    public static int rangePrefix(int[] arr,int left,int right) {
        // prefixSum(arr);
        if(left==0) return arr[right];
        return (arr[right]-arr[left-1]);
    }
     
    public static void matrixAddition(int[][] arr1,int[][]arr2) {
        if(arr1.length!=arr2.length ||arr1[0].length!=arr2[0].length ){ 
            System.out.println("Not euqual");
          return;
        }
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<arr2[i].length;j++){
                arr2[i][j]+=arr1[i][j];
            }
        }
        printArray(arr2);
    }

    public static void multiplicationMatrix(int[][] arr1,int[][]arr2) {
        int r1,c1,r2,c2;
        r1=arr1.length;c1=arr1[0].length;
        r2=arr2.length;c2=arr2[0].length;
        
        int [][]ans=new int[r1][c2];
        if(r2!=c1) System.out.println("Not equal !");
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[i].length;j++){
                for(int k=0;k<r2;k++){
                    ans[i][j]+=(arr1[i][k]*arr2[k][j]);
                }
            }
        }
        printArray(ans);
    }

    public static void tranposeMatrix(int[][] arr) {
       int [][]ans=new int[arr[0].length][arr.length];
        for(int i=0;i<arr[0].length;i++){
            for(int j=0;j<arr.length;j++){
                ans[i][j]=arr[j][i];
            }
        }
        printArray(ans);
    }

    public static void rotate90degrees(int[][] arr) {
        int [][]ans=new int[arr[0].length][arr.length];
        //transpose
        for(int i=0;i<arr[0].length;i++){
            for(int j=0;j<arr.length;j++){
                ans[i][j]=arr[j][i];
            }
        }
        //reverse
        for(int x[]:ans){ reverse(x); }
        printArray(ans);
    
    }

    public static void spiralMatrix(int[][] arr) {
        int startRow,endCol,endRow,startCol;
        startRow=0;
        startCol=0;
        endCol=arr[0].length;
        endRow=arr.length;
        //up
        for(int j=startCol;j<=endCol;j++){
            System.out.println(arr[startRow][j]);
        }startRow++;
        //right
        for(int i=startRow+1;i<=endRow;i++){
            System.out.println(arr[i][endCol]);
        }endCol--;
        //down
        for(int j=endCol-1;j>=startCol;j--){
            System.out.println(arr[endRow][j]);
        }endRow--;
        //left
        for(int i=endRow-1;i>=startRow+1;i--){
            System.out.println(arr[i][startCol]);
        }startCol++;
                
        
    }

    public static int rangeSum(int[][] arr,int startR,int startC,int endR,int endC) {
        int sum=0;
        for(int i=startR;i<=endR;i++){
            for(int j=startC;j<=endC;j++){
                sum+=arr[i][j];
            }
        }
        return sum;
    }

    public static void optimizedRangeSum(int[][] arr,int startR,int startC,int endR,int endC) {
        int sum=0;
        for(int x[]:arr){
            prefixSum(x);
        }
        for(int i=startR;i<=endR;i++){
        sum+=(rangePrefix(arr[i], startC, endC));
        }
        System.out.println(sum);
    }

    public static boolean equalSumPartition(int[] arr) {
        int[] suffix=arr.clone();
        int count=arr.length-1;
        for(int i=1;i<arr.length;i++){
            arr[i]+=arr[i-1];
        }
        for(int i=arr.length-2;i>=0;i--){
            suffix[i]+=suffix[i+1];
        } 
        for(int i=0;i<arr.length;i++){
            if(arr[i]==suffix[count--]) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(" ");
        int[] var={5,3,2,6,3,1};
        int[][]arr1={{6,3,4},
                     {1,2,3}};
        int[][]arr2={{1,1,1},
                     {1,1,1},
                     {1,1,1}};
        //  System.out.println(equalSumPartition(var));
        // matrixAddition(arr1, arr2);
        // multiplicationMatrix(arr1, arr2);
        // tranposeMatrix(arr1);
        // rotate90degrees(arr2);
        // pascal(5);
        // spiralMatrix(arr2);
        // System.out.println(rangeSum(arr2, 0, 0, 2, 2));
        optimizedRangeSum(arr2, 0, 0, 2, 2);
    }
}
class ani{ 
    protected int accNumber=1245,bankBalance=122435;
    protected String dob="4/4/523",name="adfaf";
     public int getAccNumber() {
        return accNumber;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public ani(){

    }
    int array[][]={{1,2,3},{5,6}};
    int arr[]=new int[array.length];
    int array2[][]=new int[arr.length][ ];
}