/*L48. Rotate Image
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Follow up:
Could you do this in-place?
*/

// sol1 rotate layer by layer, element by element
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length; //  nxn square matrix
        for(int layer = 0; layer < n/2; layer++){ // each layer
            // swap each elemnt in each layer
            // in each layer first element col index to last element col index
            int first = layer; //  
            int last = n - first - 1;
            for(int i = first; i < last; i++){
                // top = matrix[first][i];
                // right = matrix[i][last];
                // bottom = matrix[last][n - i - 1];
                // left = matrix[n - i - 1][first];
                //save top
                int temp = matrix[first][i];
                // copy left to top
                matrix[first][i] = matrix[n - i - 1][first];
                // copy bottom to left
                matrix[n - i - 1][first] = matrix[last][n - i - 1];
                // copy right to bottom
                matrix[last][n - i - 1] = matrix[i][last];
                // copy top to right
                matrix[i][last] = temp;
            }
        }
    }
}

/* sol2 smart way
after transpose, it will be swap(matrix[i][j], matrix[j][i])

1  4  7
2  5  8
3  6  9
Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])

7  4  1
8  5  2
9  6  3
Hope this helps.

public class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}
*/
