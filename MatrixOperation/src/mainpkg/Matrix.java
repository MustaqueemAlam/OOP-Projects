package mainpkg;


public class Matrix {
    
    private int[][] arr;
    
    public Matrix(int nRows, int nCols) {
        this.arr = new int[nRows][nCols];
        int i,j;
        for(i=0; i<arr.length; i++) {
            for(j=0; j<arr[i].length; j++) {
                this.arr[i][j] = 0;
            }
        }
    }
    
    public int[] getMatrixDimension() {
        int[] matSize = {arr.length, arr[0].length}; 
        return matSize;
        }
    
    public void setMatrixValues(int rInd, int cInd, int elem) {
        this.arr[rInd][cInd] = elem;
    }
    
    public String getStringEquivalent(){
        String str="";
        int i,j;
        for(i=0;i<this.arr.length;i++){
            for(j=0; j<this.arr[0].length;j++){
                    str += this.arr[i][j]+" ";
            }
            str += "\n";
        }
        return str;
    }
    
    public Matrix addMatrix(Matrix m2) {
        Matrix temp = new Matrix(this.arr.length, this.arr[0].length);
        
        int i, j;
        for(i=0; i<this.arr.length; i++) {
            for(j=0; j<this.arr[i].length; j++) {
                temp.arr[i][j] = this.arr[i][j] + m2.arr[i][j];
            }
        }
        return temp;
    }
    
    public Matrix subtractMatrix(Matrix m2) {
        Matrix temp = new Matrix(this.arr.length, this.arr[0].length);
        
        int i, j;
        for(i=0; i<this.arr.length; i++) {
            for(j=0; j<this.arr[i].length; j++) {
                temp.arr[i][j] = this.arr[i][j] - m2.arr[i][j];
            }
        }
        return temp;
    }    
    
    
   
}
