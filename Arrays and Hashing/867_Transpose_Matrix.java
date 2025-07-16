class Solution {
    public int[][] transpose(int[][] matrix) {
        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;
        int[][] answer = new int[numberOfColumns][numberOfRows];
        
        for(int i = 0; i < numberOfRows; i++){
            for(int j = 0; j < numberOfColumns; j++){
                answer[j][i] = matrix[i][j];
            }
        }
        return answer;
    }
}
