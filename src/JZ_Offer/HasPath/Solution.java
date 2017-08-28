package JZ_Offer.HasPath;

/**
 * Created by tzy on 2017/8/19.
 */
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if (matrix==null||rows<=0||cols<=0||matrix.length<str.length)
            return false;
        boolean[] visited =new boolean[rows*cols];
        int index=0;

        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (hasPathCore(matrix,rows,cols,str,i,j,visited,index))
                    return true;
            }
        }
        return false;
    }
    public boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, int row, int col, boolean[] visited, int index) {
        boolean flag = false ;
        if(row>=0 && row<rows && col>=0 && col<cols && !visited[row*cols+col] && matrix[row*cols+col]==str[index]) {
            index++;
            visited[row*cols+col] = true ;
            if (index==str.length)
                return true;
            flag=hasPathCore(matrix,rows,cols,str,row,col+1,visited,index)||
                    hasPathCore(matrix,rows,cols,str,row,col-1,visited,index)||
                    hasPathCore(matrix,rows,cols,str,row+1,col,visited,index)||
                    hasPathCore(matrix,rows,cols,str,row-1,col,visited,index);

            if (!flag){
                index--;
                visited[row*cols+col] = false ;
            }

        }
        return flag;
    }
}
