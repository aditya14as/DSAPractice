// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static HashMap<String, Integer> map;
    static int countWays(int n, String s){
        // code here
        map = new HashMap<String, Integer>();
        return helper(s,0,n-1,true)%1003;
    }
    
    static int helper(String s, int i, int j,boolean isTrue){
        String temp = new String(i+"_"+j+"_"+isTrue);
        if(map.containsKey(temp)){
            return map.get(temp);
        }
        if(i>j){
            map.put(temp,0);
            return 0;
        }
        
        if(i==j){
            char sign = s.charAt(i);
            if(isTrue && sign == 'T'){
                map.put(temp,1);
                return 1;
            }
            if(!isTrue && sign == 'F'){
                map.put(temp,1);
                return 1;
            }
            
            map.put(temp,0);
            return 0;
        }
        
        int ans =0;
        for(int k=i+1; k<j; k+=2){
            int lf , lt, rf, rt;
            String l1 = new String(i + "_" + (k-1) + "_true");
            String l2 = new String(i + "_" + (k-1) + "_false");
            String r1 = new String( (k+1) + "_"+j + "_true" );
            String r2 = new String( (k+1) + "_"+j + "_false" );
            
            if(map.containsKey(l1)) {
                lt = map.get(l1);
            }else{
                lt = helper(s,i,k-1,true) % 1003;
                map.put(l1,lt);
            }
            
            if(map.containsKey(l2)) {
                lf = map.get(l2);
            }else{
                lf = helper(s,i,k-1,false) % 1003;
                map.put(l2,lf);
            }
            
            if(map.containsKey(r1)) {
                rt = map.get(r1);
            }else{
                rt = helper(s,k+1,j,true) % 1003;
                map.put(r1,rt);
            }
            
            if(map.containsKey(r2)) {
                rf = map.get(r2);
            }else{
                rf = helper(s,k+1,j,false) % 1003;
                map.put(r2,rf);
            }
            
            char op = s.charAt(k);
            if(op == '&'){
                if(isTrue){
                    ans = ans + (lt * rt);
                }else{
                    ans = ans + (lf*rt + lt*rf + lf*rf);
                }
            }
            
            if(op == '|'){
                if(isTrue){
                    ans = ans + (lt*rt + lt*rf + lf*rt);
                }else{
                    ans = ans + (lf * rf);
                }
            }
            
            if(op == '^'){
                if(isTrue){
                    ans = ans + (lf*rt + lt*rf);
                }else{
                    ans = ans + (rt*lt + lf*rf);
                }
            }
        }
        
        map.put(temp,ans%1003);
        return ans;
    }
}



// class Solution{
//     static HashMap<String, Integer> map;
//     static int numOfWaysForTrueBUDPMap(String str, int i, int j, boolean isTrue) {
// 		String temp = new String(i + "_" + j + "_" + isTrue);
// 		if(map.containsKey(temp)) {
// 			return map.get(temp);
// 		}
// 		if(i > j) {
// 			map.put(temp, 0);
// 			return 0;
// 		}
// 		if(i == j) {
// 			char sign = str.charAt(i);
// 			if(isTrue && sign == 'T') {
// 				map.put(temp, 1);
// 				return 1;
// 			}
// 			if(!isTrue && sign == 'F') {
// 				map.put(temp, 1);
// 				return 1;
// 			}
// 			map.put(temp, 0);
// 			return 0;
// 		}

// 		int ans = 0;
// 		for(int k = i + 1; k < j; k += 2) {
// 			int leftFalse, leftTrue, rightFalse, rightTrue;
// 			String left1 = new String(i + "_" + (k - 1) + "_true"), left2 = new String(i + "_" + (k - 1) + "_false");
// 			String right1 = new String((k + 1) + "_" + j + "_true"), right2 = new String((k + 1) + "_" + j + "_false");
// 			if(map.containsKey(left1)) {
// 				leftTrue = map.get(left1);
// 			} else {
// 				leftTrue = numOfWaysForTrueBUDPMap(str, i, k - 1, true) % 1003;
// 				map.put(left1, leftTrue);
// 			}
// 			if(map.containsKey(left2)) {
// 				leftFalse = map.get(left2);
// 			} else {
// 				leftFalse = numOfWaysForTrueBUDPMap(str, i, k - 1, false) % 1003;
// 				map.put(left2, leftFalse);
// 			}
// 			if(map.containsKey(right1)) {
// 				rightTrue = map.get(right1);
// 			} else {
// 				rightTrue = numOfWaysForTrueBUDPMap(str, k + 1, j, true) % 1003;
// 				map.put(right1, rightTrue);
// 			}
// 			if(map.containsKey(right2)) {
// 				rightFalse = map.get(right2);
// 			} else {
// 				rightFalse = numOfWaysForTrueBUDPMap(str, k + 1, j, false) % 1003;
// 				map.put(right2, rightFalse);
// 			}
//             char operation = str.charAt(k);
// 			if(operation == '&') {
// 				if(isTrue) {
// 					ans += (leftTrue * rightTrue);
// 				} else {
// 					ans += (leftFalse * rightTrue + leftTrue * rightFalse + leftFalse * rightFalse);
// 				}
// 			} else if(operation == '|') {
// 				if(isTrue) {
// 					ans += (leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue);
// 				} else {
// 					ans += (leftFalse * rightFalse);
// 				}
// 			} else if(operation == '^') {
// 				if(isTrue) {
// 					ans += (leftFalse * rightTrue + leftTrue * rightFalse); 
// 				} else {
// 					ans += (leftTrue * rightTrue + leftFalse * rightFalse);
// 				}
// 			}
// 		}

// 		map.put(temp, ans % 1003);
// 		return ans;
// 	}
	
//     static int countWays(int N, String S){
//         // code here
//         map = new HashMap<String, Integer>();
//         return numOfWaysForTrueBUDPMap(S, 0, S.length() - 1, true) % 1003;
//     }
// }