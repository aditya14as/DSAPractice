class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            if(i<s.length()-1 && s.charAt(i)=='I' && s.charAt(i+1)=='V'){
                ans = ans + 4;
                i++;
            }
            else if(i<s.length()-1 && s.charAt(i)=='I' && s.charAt(i+1)=='X'){
                ans = ans + 9;
                i++;
            }
            else if(i<s.length()-1 && s.charAt(i)=='X' && s.charAt(i+1)=='L'){
                ans = ans + 40;
                i++;
            }
            else if(i<s.length()-1 && s.charAt(i)=='X' && s.charAt(i+1)=='C'){
                ans = ans + 90;
                i++;
            }
            else if(i<s.length()-1 && s.charAt(i)=='C' && s.charAt(i+1)=='D'){
                ans = ans + 400;
                i++;
            }
            else if(i<s.length()-1 && s.charAt(i)=='C' && s.charAt(i+1)=='M'){
                ans = ans + 900;
                i++;
            }
            else{
                ans = ans + getInt(s.charAt(i)); 
            } 
        }
        return ans;                             
    }
    public int getInt(char c){
        switch(c){
            case 'I':
                return 1;
              
            case 'V':
                return 5;
            
            case 'X':
                return 10;
               
            case 'L':
                return 50;
            
            case 'C':
                return 100;
            
            case 'D':
                return 500;
         
            case 'M':
                return 1000;
        }
        return 0;
    }
}