public class swapp2D {
    public static void main(String[] args) {
        int row = 2 , colum = 3;
        int matrix[][] ={{10,11,12},
                      {20,21,22}};
        // print original matrix 

        printmatrix(matrix);

        //transpose the matrix
        int transpose [][] = new int[colum][row];
        for(int i =0;i<row;i++){
            for(int j = 0;j<colum;j++){
                transpose[j][i] = matrix[i][j];
            }
        }
        printmatrix(transpose);

                
    }

    public static void printmatrix(int matrix[][]){
        System.out.println("the matrix is: ");
        for(int i=0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println(" ");
        }
        

        
    
}
}
