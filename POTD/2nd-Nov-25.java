class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int matrix[][] = new int[m][n];
        for(int guard[]: guards){
            matrix[guard[0]][guard[1]] = 2;
        }

        for(int wall[]:walls){
            matrix[wall[0]][wall[1]] = 3;
        }

        for(int g[]:guards){
            int row = g[0];
            int col = g[1];

            // down
            for(int i=row+1; i<m; i++){
                if(matrix[i][col] == 3 || matrix[i][col] == 2) break;
                matrix[i][col] = 1;
            }

            // up
            for(int i=row-1; i>=0; i--){
                if(matrix[i][col] == 3 || matrix[i][col] == 2) break;
                matrix[i][col] = 1;
            }

            // left
            for(int j=col-1; j>=0; j--){
                if(matrix[row][j] == 3 || matrix[row][j] == 2) break;
                matrix[row][j] = 1;
            }

            // right
            for(int j=col+1; j<n; j++){
                if(matrix[row][j] == 3 || matrix[row][j] == 2) break;
                matrix[row][j] = 1;
            }
        }

        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }

}
