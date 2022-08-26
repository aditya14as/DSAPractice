class Solution {
    public boolean reorderedPowerOf2(int n) {
       char[] num = String.valueOf(n).toCharArray();
        Arrays.sort(num);
        for(int i=0;i<30;i++){
            int intCur = (int)Math.pow(2,i);
            char[] charCur = String.valueOf(intCur).toCharArray();
            Arrays.sort(charCur);
            if(Arrays.equals(num,charCur))
                return true;
        }
        return false; 
    }
}