class Solution {

    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<isConnected.length; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[0].length; j++){
                if(isConnected[i][j]==1 && i!=j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == false) {
                count++;
                getConnected(list,i,visited);
            }
        }
        return count;
    }

    public void getConnected(ArrayList<ArrayList<Integer>> arr, int i, boolean[] visited) {
        visited[i]=true;
        for(int j=0; j<arr.get(i).size(); j++){
            if(visited[arr.get(i).get(j)]==false){
                getConnected(arr,arr.get(i).get(j),visited);
            }
        }
    }
}
