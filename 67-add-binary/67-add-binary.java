class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
    int i = a.length() - 1; 
    int j = b.length() -1;
    int carry = 0;
    while (i >= 0 || j >= 0) {
        int sum = carry;
        if(i>=0){
            // Adding last character of a 
            sum = sum + a.charAt(i) - '0';
            i--;
        }
        if(j>= 0){
            // Adding last character of b
            sum = sum + b.charAt(j) - '0' ;
            j--;
        }
        // sum will either be 0 or 1 or 2 or 3
        // if sum is greater than 1 then carry is initialised to 1 else o
        carry = sum>1 ? 1 : 0; 
        // if sum is 0 then sum % 2 is 0 
        // if sum is 1 then sum % 2 is 1
        // if sum is 2 then sum % 2 is 0
        // if sum is 3 then sum % 2 is 1
        sb.append(sum % 2);
    }
    // carry will either be 1 or 0
    // if not zero then we should add it
    if (carry != 0) { 
        sb.append(carry); 
    }
    
    return sb.reverse().toString();
    }
}