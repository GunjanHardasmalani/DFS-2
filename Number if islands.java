//TC O(n)
//SC O(n)

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    grid[i][j] = '2';
                    q.add(new int[]{i,j});

                    while(!q.isEmpty()){
                        int [] curr = q.poll();

                        for(int[] dir: dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];

                            if(nr >= 0 && nr <m && nc >=0 && nc <n){
                                if(grid[nr][nc] == '1'){
                                    grid[nr][nc] = '2';
                                    q.add(new int[]{nr,nc});
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
        
    }
}