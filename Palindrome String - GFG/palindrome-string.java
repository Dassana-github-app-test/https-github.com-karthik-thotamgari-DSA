// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String str) {
    return isPalindrome(str,0,str.length()-1,1);
    }
    int isPalindrome(String str,int start,int end,int ispalin) {
        if(ispalin==0||start>end){
            return ispalin;
        }
    if(str.charAt(start)==str.charAt(end)){
        ispalin = 1;
    }
    else{
        ispalin = 0;
    }
    return isPalindrome(str,start+1,end-1,ispalin);

    }
}