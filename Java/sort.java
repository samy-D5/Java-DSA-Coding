import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class sort {
    public static void swap(int[] arr,int l,int r) {
        if(l!=r){
            arr[l]=arr[l]^arr[r];
            arr[r]=arr[l]^arr[r];
            arr[l]=arr[l]^arr[r];
        }
    }

    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x+" ");
        }
    }
    public static void buuble(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    arr[j]=arr[j]^arr[j+1];
                    arr[j+1]=arr[j]^arr[j+1];
                    arr[j]=arr[j]^arr[j+1];
                }
            }
        }
        for (int x : arr) {
            System.out.print(x+" ");
        }
    }

    public static void selection(int[] arr) {
        
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            swap(arr, i, min);
        }
        for (int x : arr) 
            System.out.print(x+" ");        
    }

    public static void anotherSelection(int[] arr) {
        for(int i=arr.length-1;i>=0;i--){
            int max=i;
            for(int j=i-1;j>=0;j--){
                if(arr[j]>arr[max])   max=j;
            }
            swap(arr, i, max);
        }
        for (int x : arr) 
        System.out.print(x+" ");
    }

    public static void insertion(int[] arr) {
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j-1);
                }
            }
        }
        for (int x : arr) 
        System.out.print(x+" ");
    }

    public static void lastZero(int[] arr) {
        int temp;
        boolean check=true;
        for (int i = 0; i < arr.length; i++) {
            check=true;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]==0 && arr[j+1]!=0){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    check=false;
                }
            }
        }  
        if(check)   printArray(arr);      
    }

    public static void lexographically(String[] arr) {
        int minidx;
        for (int i = 0; i < arr.length; i++) {
            minidx=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j].compareTo(arr[minidx])<0) {
                    minidx=j;
                }
            }
            String temp=arr[i];
            arr[i]=arr[minidx];
            arr[minidx]=temp;
        }
        for(String ch:arr)  System.out.print(ch+" ");
    }

    public static void merge(int[] arr,int l,int mid,int r) {
        int n1=mid-l+1;
        int n2=r-mid;
        int[]left=new int[n1];
        int[]right=new int[n2];
        for (int i = 0; i < n1; i++) left[i]=arr[l+i];
        for (int i= 0; i < n2; i++) right[i]=arr[mid+i+1];
        int k=l,i=0,j=0;
        while(i<n1 && j<n2){
            if(left[i]<=right[j])arr[k++]=left[i++]; 
            else arr[k++]=right[j++];
        }
        while(i<n1)arr[k++]=left[i++];
        while(j<n2)arr[k++]=right[j++];
    }

    public static void mergeSort(int[] arr,int l,int r) {
        if(l>=r) return;
        int mid=(l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    public static int findPaths(int m,int n, int currCol,int currRow) {
        if(currCol>n||currRow>m)    return 0;
        if(currRow == m-1 && currCol == n-1)  return 1;
        int choice1=findPaths(n, m, currCol+1, currRow);
        int choice2=findPaths(n, m, currCol, currRow+1);
        return choice1+choice2;
    }
    
    public static int[] nextIntArr(int[] arr,int[] arr1,int index) {
        if(index==arr1.length-1){
            arr1[index]=arr[index+1]+arr[index];
            return arr1;
        }
        arr1[index]=arr[index+1]+arr[index];
        nextIntArr(arr, arr1, index+1);
        return arr1;
    }
    
    public static void revSumTriangle(int []arr) {
        if(arr.length==1){
            System.out.print(arr[0]+" ");
            System.out.println();
            return;
        }
        int []arr1=new int[arr.length-1];
        revSumTriangle(nextIntArr(arr, arr1, 0));
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    // 48
    // 20 28
    // 8 12 16
    // 3 5 7 9
    // 1 2 3 4 5

    public static String merge2String(String b,String a,int index) {
       if(index >= a.length() && index >= b.length())   return "";
      if(index<a.length() && index<b.length())
            return ""+(a.charAt(index))+(b.charAt(index))+merge2String(b, a, index+1);
      else if(index>=a.length())
            return ""+(a.charAt(index))+(a.charAt(index))+merge2String(b, a, index+1);
      else  return ""+(b.charAt(index))+(b.charAt(index))+merge2String(b, a, index+1);
    }

    public static String findUpperCase(String str,int index) {
        if(index>str.length()) return "";
        if(Character.isUpperCase(str.charAt(index))) return str.substring(index, str.length());
        return findUpperCase(str, index+1);
    }

    public static int printConsonent(String str,int index) {
        if(index>str.length()-1) return 0;
        int ans=0;
        char ch=Character.toLowerCase(str.charAt(index));
        if(!(ch=='a'|| ch=='e'|| ch=='i'|| ch=='o'|| ch=='u')) ans++;
        return ans+=printConsonent(str, index+1);
    }

    public static int lowerCase(String str,int index) {
        if(index>str.length()-1) return 0;
        int ans=0;
        if(Character.isLowerCase(str.charAt(index))) ans++;
        return ans+=lowerCase(str, index+1);
    }

    public static int atoi(String str,int index) {
        if(index==-1) return 0;
        return atoi(str, index-1)*10+str.charAt(index)-'0';
    } //it converts the number from string into integer.

    public static void sortBybubble(String[] str) {
        for(int i=0;i<str.length-1;i++){
            for(int j=0;j<str.length-i-1;j++){
                if(str[j].compareTo(str[j+1])>0){
                 String temp=str[j];
                 str[j]=str[j+1];
                 str[j+1]=temp;
                }
        } 
    }
    for(String x:str) 
        System.out.print(x+" ");
}

   public static void characterSort(String s) {
    char[] ch=s.toCharArray();
    for(int i=1;i<ch.length;i++){
        for(int j=0;j<ch.length-i;j++){
            if(ch[j]>ch[j+1]){
               char temp=ch[j];
               ch[j]=ch[j+1];
               ch[j+1]=temp;
            } 
        }
    }
    for(char x:ch) System.out.print(x);
   }
// Q.   lkjhgfdsa
// ans.   adfghjkls


   public static void numberGreaterThanHalf(int[] arr) {
    Arrays.sort(arr);
    for(int i=arr.length/2;i<arr.length;i++){
         System.out.print(arr[i]+" ");
    }
   }

   public static void index(Integer[] arr) {
    ArrayList <Integer> list=new ArrayList<>(Arrays.asList(arr));
    Arrays.sort(arr);
    for(int i=0;i<arr.length;i++){
        System.out.print(list.indexOf(arr[i]));
    }
   }

   public static int partition(int[] arr,int start,int end) {
    int count=0;
    int pivot=arr[start];
    for(int i=start+1;i<=end;i++)
        if(arr[i]<=pivot) count++;
    int pI=start+count;
    swap(arr, pI, start);
    int left=start , right=end;
    while(left<pI && end>pI){
        if(arr[left]>arr[pI] && arr[right]<=arr[pI]){
            swap(arr, left, right);
             left++;
             right--;
        }
        else if(arr[left]<=arr[pI]) left++;
        else  right--;
      }
    return pI;
   }

   public static void quick(int[] arr,int start,int end) {
    if(start>=end)  return;
    int part=partition(arr, start, end);
    quick(arr, start, part-1);
    quick(arr, part+1, end);
   }

   public static void countSort(int[] arr) {
    int max=0;
    for(int x:arr){
        if(x>max) max=x;
    }
    int[] freq=new int[max+1];
    for(int x:arr)  freq[x]++;
    max=0;
    for(int i=0;i<freq.length;i++){
        while(freq[i]>0){
            arr[max++]=i;
            freq[i]--;
        }
    }
    printArray(arr);
   }

   public static void optimizedCountSort(int[] arr) {
    int max=0;
    int [] ans=new int[arr.length];
    for(int x:arr){
        if(x>max) max=x;
    }
    int[] freq=new int[max+1];
    for(int x:arr)  freq[x]++;
    max=0;
    //prefix sum 
    for(int i=1;i<freq.length;i++)    freq[i]+=freq[i-1];
    //fill new array
    for(int i=arr.length-1;i>=0;i--){
        int index=freq[arr[i]];
        ans[index-1]=arr[i];
        freq[arr[i]]--;
    } 
    arr=null;
    arr=ans;
    printArray(arr);
   }

   public static int[] countForRadix(int[] arr,int place) {
    int [] ans=new int[arr.length];
    int[] freq=new int[10];
    for(int x:arr) 
     freq[(x/place)%10]++;
    //prefix sum 
    for(int i=1;i<freq.length;i++)  
      freq[i]+=freq[i-1];
    //fill new array
    for(int i=arr.length-1;i>=0;i--){
        int index=freq[(arr[i]/place)%10];
        ans[index-1]=arr[i];
        freq[(arr[i]/place)%10]--;
    } 
    return ans;
   }

   public static void radixSort(int[] arr) {
    int max=Integer.MIN_VALUE;
    for(int x:arr)
        if(x>max) max=x;
    for(int place=1;max/place>0;place*=10)   
        arr=countForRadix(arr,place);
            
    printArray(arr);
   }

   public static void bucketSort(double[] arr) {
    @SuppressWarnings("unchecked")
    ArrayList<Double> buckets[]=new ArrayList[10];
    for(int i=0;i<buckets.length;i++)
        buckets[i]=new ArrayList<>();
    for(Double x:arr){
        int index=(int)(x-Math.floor(x));
        buckets[index%10].add(x);
    }
    for(int i=0;i<buckets.length;i++){
        Collections.sort(buckets[i]);
    }
    int count=0;
    for(int i=0;i<buckets.length;i++){
        ArrayList <Double> currbucket= buckets[i];
        for(int j=0;j<currbucket.size();j++){
            arr[count++]=currbucket.get(j);
        } 
    }
}

    public static void fixDipArray(int[] arr) {
        int x=-1,y=-1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                if(x==-1){ //first encounter
                    x=i-1;
                    y=i;
                }
                else y=i;
            }
        }
        swap(arr, x, y);
        printArray(arr);
    }

    public static void sort012(int[] arr) {
        int lo=0, mid=0, hi=arr.length-1;
        while(mid<=hi){
           if(arr[mid]==0){
            swap(arr, lo, mid);
            mid++;
            lo++;
           }
           else if(arr[mid]==1){
            mid++;
           }
           else{
            swap(arr, mid, hi);
            hi--;
           }
        }
        printArray(arr);
    }

    public static void firtOccuranceBinarySearch(int[] arr,int key) {
        int lo=0, hi=arr.length;
        int mid;
        int fo=-1;
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(arr[mid]==key){
                fo=mid;
                hi=mid-1;
            }
            else if(key<arr[mid]) hi=mid-1;
            else lo=mid+1;
        }
        System.out.println(fo);
    }

    public static void findSqrtOfNumUsingBS(int n) {
       int left=1,right=n/2,mid;
        while(left<=right){
            mid=(left+right)/2;
            if(mid*mid==n){
                System.out.println(mid);
            return;
            }
            else if(mid*mid<n){
                left=mid+1;
            }

        }
    }

    public static int rotatedArrayUsingBS(int[] arr) {
        int n=arr.length;
        int s=0,l=n-1,mid,ans=0;
        while(s<l){
            mid=(s+l)/2;
            if(arr[mid]>arr[n-1]){
                s=mid+1;
            }else if(arr[mid]<arr[n-1]){
                l=mid-1;
                ans=mid;
            } 
        }
        return ans;
    }

    public static int findTargetIndexInRotatedArrayUsingBs(int[] arr,int tar) {
        int n=arr.length;
        int sta=0,las=n-1,mid;
        while(sta<=las){
            mid=(sta+las)/2;
            if(arr[mid]==tar) return mid;
            if(arr[mid]<arr[las]){
                if(tar>arr[mid] && tar<=arr[las]){
                    sta=mid+1;
                }
                else las=mid-1;
            }
            else{
                if(tar>=arr[sta] && tar<arr[mid]){
                    las=mid-1;
                }
                else sta=mid+1;
            }
        }
        return -1;
    }

    public static int findTargetIndexInDuplicatedRotatedArrayUsingBs(int[] arr,int tar) {
        int n=arr.length;
        int sta=0,las=n-1,mid;
        while(sta<=las){
            mid=sta+(las-sta)/2;
            if(arr[mid]==tar) return mid;
            if(arr[sta]==arr[mid] && arr[las]==arr[mid]){
                    ++sta;
                    --las;
            }
            if(arr[mid]<=arr[las]){
                if(tar>arr[mid] && tar<=arr[las]){
                    sta=mid+1;
                }
                else las=mid-1;
            }
            else{
                if(tar>=arr[sta] && tar<arr[mid]){
                    las=mid-1;
                }
                else sta=mid+1;
            }
        }
        return -1;
    }

    public static boolean twoDArrayBS(int[][] arr,int tar) {
        int sr=0,sc=0,er=arr.length-1,ec=arr[0].length-1,mr,mc;
        int[] ans=new int[2];
        while(sr<=er && sc<=ec){
            mr=(sr+er)/2;
            mc=(sc+ec)/2;
            if(tar==arr[mr][mc]){
                // ans[0]=mr;
                // ans[1]=mc;
                return true;
            }
            else if(tar<arr[mr][mc]){
                if(tar<=arr[mr][sc]){
                    ec=mc+1;
                }else{
                    er=mr-1;
                }
            }
            else {
                if(tar<=arr[mr][ec]){
                    sc=mc+1;
                }else{
                    sr=mr+1;
                }
            }
        }
        // printArray(ans);
        return false;
    }

    public static boolean totalDivide(int[] arr,int m,int mid) {
        int sum=0, stu=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>mid) return false;
            if(arr[i]+sum<=mid){
                sum+=arr[i];
            }else{
                 stu++;
                 sum=arr[i];
            }
        }
        return stu<=m;
    }

    public static void chocolateDivideBS(int[] arr,int m) {
        int left=1, right=(int)1e9, mid, ans=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(totalDivide(arr, m, mid)){
                ans=mid;
                right=mid-1;
            }else left=mid+1;
        }
        System.out.println(ans);
    }

    public static boolean isValidDist(int[] arr,int m,int mid) {
        int last=arr[0], kids=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-last>=mid){
                kids++;
                last=arr[i];
            }
        }
        return kids>=m;
    }

    public static void raceTrack(int[] arr,int m) {
        int left=1, right=(int)1e9, mid, ans=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(isValidDist(arr, m, mid)){
                ans=mid;
                left=mid+1;
            }else right=mid-1;
        }
        System.out.println(ans);
    }
        

    public static void main(String[] args) {
        int [] arr={1,2,4,8,9};
        int [][] arr4={{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12}};
        double [] arr2={3.6,8.7,6.9,7.8,4.9,2.2,1.5,5.4};
        String[] str={"abc","uvx","poq","tuv","ghi"};
        String a="coding";
        String b="1234";
        raceTrack(arr, 2);
       
    }
}

