public class Array {
    // Rotate the array by K times without using extra space

    public static int[] swap(int[] arr, int left, int right) {

        while (left < right) {
            arr[left] = arr[left] ^ arr[right];
            arr[right] = arr[left] ^ arr[right];
            arr[left] = arr[left] ^ arr[right];
            left++;
            right--;
        }
        return arr;
    }
    public static int[] reverse(int[] arr) {
        int left=0, right=arr.length-1;
        while (left < right) {
            arr[left] = arr[left] ^ arr[right];
            arr[right] = arr[left] ^ arr[right];
            arr[left] = arr[left] ^ arr[right];
            left++;
            right--;
        }
        return arr;
    }
    
    public static void printArray(int arr[]) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void printArray(int arr[][]) {
        for (int x[] : arr) {
            for (int y : x)
                System.out.print(y + " ");
            System.out.println();
        }
    }

    public static void rotateArray(int[] arr, int k) {
        int t = k % (arr.length);
        int temp = 0;
        for (int i = 0; i < t; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                if (j == arr.length - 1) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                } else if (j == 0) {
                    arr[j] = temp;
                } else
                    arr[j] = arr[j - 1];
            }
        }
        printArray(arr);
    }

    // Rotate the array by K times without using extra space (with optimized👍)
    public static void reverseArray(int arr[], int start, int end) {
        swap(arr, start, end);
    }

    public static void reverseByKTimesOptimizes(int arr[], int k) {
        int n = arr.length;
        k = k % n;
        reverseArray(arr, 0, n - k - 1);
        reverseArray(arr, n - k, n - 1);
        reverseArray(arr, 0, n - 1);
        printArray(arr);
    }

    // sort an array consisting of only 0s and 1s(arr[left]==0 and arr[right]==1)
    // sort an array consisting of even int first followed by odd int
    // (arr[left]%2==0 and arr[right]!=0)
    public static void sortZerosAndOnesInOneArray(int[] arr) { 
        int n = arr.length;
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            while (left < right) {
                if (arr[left] % 2 != 0 && arr[right] % 2 == 0) {
                    swap(arr, left, right);
                }
                if (arr[left] % 2 == 0)
                    left++;
                if (arr[right] % 2 != 0)
                    right--;
            }
        }
        printArray(arr);
    }

    //array 'a'sorted in non-decreasing , return array of squares sorted in non-decreasing order
    public static void squareNonDecreasing(int[]arr){
        int left =0 ,right = arr.length-1;
        int k=arr.length-1;
        int ans[]=new int [arr.length];
        while(left<=right){
            if(Math.abs(arr[left])>Math.abs(arr[right])){
                ans[k--]=arr[left]*arr[left];
                left++;
            }else {
                ans[k--]=arr[right]*arr[right];
                right--;
            }
        }
         printArray(ans);   
        }

        //return the prefix sum array without new array
        public static int prefixSumRange(int[]arr,int l,int r){
            return(arr[r] - arr[l-1]); // return the sum from l to r (e.g. from 1 to 5) (using prefix)
        } 

        public static int[] prefixSum(int[]arr){
            for(int i=1;i<arr.length;i++){
                arr[i]=arr[i-1]+arr[i];
            }
            return arr;
        } 
        public static int[][] prefixSum(int[][]arr){
            for(int i=0;i<arr.length;i++){
               for(int j=1; j<arr[i].length;j++){
                arr[i][j]+=arr[i][j-1];
               }
            }
            return arr;
        } 
         
        //return true if subarray's sum is equal with additional prefix sum equal to sufix sum (i.e. equal element) 
        public static boolean isSubArrayEqual(int[]arr){
         int []prefix= new int[arr.length];
            for(int i=1;i<arr.length;i++){
               prefix[i]=arr[i-1]+prefix[i];
            }

            for(int i=arr.length-2;i>=0;i--){
                arr[i]=arr[i+1]+arr[i];
                if(i>0&&prefix[i]==arr[i-1]) return true;
            }
            return false;
        } 

        //Addition of Matrices.
        public static void twoDArraySum(int a[][],int[][]b){
            int sum[][]=new int[a.length][a[0].length];
            for(int i=0;i<a.length;i++){
                for(int j=0;j<a[0].length;j++){
                    sum[i][j]=a[i][j]+b[i][j];
                }
            }
            printArray(sum);
        }

        //multiplication of 2 matrices.
        public static void multiplicationMatrices(int[][]a,int [][]b){
           int r1=a.length;
           int c1=a[0].length;
           int r2=b.length;
           int c2=b[0].length;           
            if(r2!=c1){
                System.out.println("Matrix cant be multiplied !");
                return;
            }
            int [][]ans=new int[r1][c2];
            for(int i=0;i<r1;i++){
                for(int j=0;j<c2;j++){
                    for(int k=0;k<r2;k++){
                        ans[i][j]+=(a[i][k]*b[k][j]);
                    }
                }
            }
            printArray(ans);
        }
        
        //Transpose matrix
        public static void transposeMatrix(int [][]arr){
            int [][]arr2 = new int[arr[0].length][arr.length];
            for(int i=0;i<arr2.length;i++){
                for(int j=0;j<arr2[i].length;j++){
                    arr2[i][j]=arr[j][i];
                }
            }
            printArray(arr2);
        }

        //Transpose matrix in place(without creating new array)
        public static int[][] transposeInPlace(int [][]arr){
            for(int i=0;i<arr.length;i++){
                for(int j=i;j<arr[i].length;j++){
                    if (i==j) continue;
                  arr[i][j]=arr[i][j]^arr[j][i];
                  arr[j][i]=arr[i][j]^arr[j][i];
                  arr[i][j]=arr[i][j]^arr[j][i];
                }
            }
            return arr;
        }

        // rotate array by 90 degrees
        public static void rotateBy90Degree(int [][]arr){
           transposeInPlace(arr);
            for(int i=0;i<arr[0].length;i++){
                reverse(arr[i]);
            }
            printArray(arr);
        }

        //Pascal Traingle
        public static void pascalTriangle(int n){
            int [][]arr = new int[n][];
            for(int i=0;i<n;i++){
                arr[i]=new int[i+1];
                for(int j=0;j<arr[i].length;j++){
                    if(j==0 || j==arr[i].length-1) arr[i][j]=1;
                    else arr[i][j]=arr[i-1][j]+arr[i-1][j-1];  
                }
            }
            printArray(arr);
        }

        //Spiral matrix
        public static void spiralMatrix(int arr[][]){
            int startRow=0 ,endCol=arr[0].length-1, endRow=arr.length-1 , startCol=0 ;
            while(startRow<=endRow && startCol<=endCol){
                //upper side(startRow)
                for(int j=startCol;j<=endCol;j++){
                    System.out.print(arr[startRow][j]+ " ");
                }
                //right side(endCol)
                for(int i=startRow+1;i<=endRow;i++){
                    System.out.print(arr[i][endCol]+ " ");
                }

                //down side(endRow)
                for(int j=endCol-1;j>=startCol;j--){
                    if(endRow==startRow) break;
                    System.out.print(arr[endRow][j]+ " ");
                    
                }
                
                //left side(startCol)
                for(int i=endRow-1;i>=startRow+1;i--){
                    if(endCol==startCol) break;
                    System.out.print(arr[i][startCol]+ " ");
                }
                startRow++;
                endCol--;
                endRow--;
                startCol++;

            }
        }
        
        public static void nSquareSpiralMatrix( int n){
            int arr[][] = new int[n][n];
            int startRow = 0,
             endCol = arr[0].length - 1,
              endRow = arr.length - 1,
               startCol = 0,
                count = 1;
            while(startRow<=endRow && startCol<=endCol){
                //upper side(startRow)
                for(int j=startCol;j<=endCol;j++){
                    arr[startRow][j]=count++;
                    
                }
                //right side(endCol)
                for(int i=startRow+1;i<=endRow;i++){
                    arr[i][endCol]=count++;
                    
                }

                //down side(endRow)
                for(int j=endCol-1;j>=startCol;j--){
                    if(endRow==startRow) break;
                    arr[endRow][j]=count++;
                    
                }
                
                //left side(startCol)
                for(int i=endRow-1;i>=startRow+1;i--){
                    if(endCol==startCol) break;
                    arr[i][startCol]=count++;
                    
                }
                startRow++;
                endCol--;
                endRow--;
                startCol++;

            }
            printArray(arr);
        }

        //
        public static int sumOfRectangleMatrix(int arr[][] , int r1 ,int c1 ,int r2, int c2) {
            int sum=0;
            for(int i=r1 ; i<=r2; i++){
                for(int j=c1; j<=c2 ; j++){
                    sum+=arr[i][j];
                }
            }
            return sum;
        }

        //
        public static void prefixSumSumOfRectangleMatrix(int arr[][] , int r1 ,int c1 ,int r2, int c2) {
            int prefSum[][]= new int[arr.length][arr[0].length];
            prefixSum(arr);
            int sum=0;
            for(int i=r1; i<=r2; i++){
                sum+=(prefixSumRange(arr[i], c1, c2));
            }
            System.out.println(sum);
        }

        public static void slidingWindow(int[] arr, int k){
            int sum=0, max=0;
            for(int i=0;i<k;i++){
                sum+=arr[i];
            }
            int l=0, r=k-1;
            while(r<arr.length){
                sum-=arr[l];
                sum+=arr[r];
                max=Math.max(sum, max);
                 l++;
                 r++;
            }
            System.out.print(max);
        }

        public static void slidingWindow2(int[] arr,int k) {
            int max=1, sum=arr[0];
            int l=0, r=0;
            while(r<arr.length){
                sum+=arr[r];
                if(sum>k){ 
                    sum-=arr[r];
                    l++;
                }
                else if(sum<=k){
                    max=Math.max(max, r-l+1);
                }
                r++;
            }
            System.out.println(max);
        }
    
    public static void main(String args[]) {
        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int c[]={2,5,1,7,10};
        slidingWindow2(c, 14);
    }
}