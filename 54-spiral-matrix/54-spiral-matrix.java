class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        int cs=0;
        int ce= arr[0].length-1;
        int rs = 1;
        int re = arr.length-1;
        int cs1= arr[0].length-2;
        int ce1= 0;
        int rs1 = arr.length-2;
        int re1 = 1;
        List<Integer> ans = new ArrayList<>();
        int n=arr.length*arr[0].length;
        
        while(ans.size()<n){
            
            if(cs<=ce && ans.size()<n){
               for(int i=cs ; i<=ce; i++){
                    ans.add(arr[rs-1][i]);
                  
                }
            }
            
            if(rs<=re && ans.size()<n){
               for(int i=rs ; i<=re; i++){
                    ans.add(arr[i][ce]);
                   
                }
            }
            
            if(cs1>=ce1 && ans.size()<n){
                for(int i=cs1; i>=ce1;i--){
                    ans.add(arr[re][i]);
                    
                }
            }
            
            if(rs1>=re1 && ans.size()<n){
                for(int i=rs1; i>=re1; i--){
                    ans.add(arr[i][ce1]);
                }
            }
            
            cs++;
            ce--;
            rs++;
            re--;
            cs1--;
            ce1++;
            rs1--;
            re1++;
            
        }
        return ans;
    }
}