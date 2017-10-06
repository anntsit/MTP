package lab_2_array;

import java.util.Random;

public class Matrix {
    private int [][] matrix;
    private int dimension;

    public Matrix(int dimension){
        this.dimension = dimension;
        matrix = new int [dimension][dimension];
        Random random = new Random();
        for (int i=0; i < dimension; i++){
            for (int j=0; j < dimension; j++){
                matrix[i][j] = random.nextInt();
                if(i==j) System.out.print((char) 27 + "[31m" + matrix[i][j]  + (char)27 + "[0m  ");
                else System.out.print(matrix[i][j]+ "  ");
            }
            System.out.println();
        }
    }

    public int FindColomn(){
        int colomn = 0;
        int finalSum = 0;
        for(int j=0; j<dimension; j++){
            int sum = 0;
            for(int i=0; i<dimension; i++){
                if(matrix[i][j] <0 ){
                    int tmp = matrix[i][j]*(-1);
                    sum += tmp;
                }
                else sum+=matrix[i][j];
            }

            if(sum > finalSum) sum = finalSum;
            colomn = j;
        }
        return colomn;
    }

    public int FindMinimumElement(int colomn){
    int minimum = matrix[0][colomn];
    for(int i=0; i< dimension; i++){
        if(matrix[i][colomn]<minimum) minimum = matrix[i][colomn];
    }
    return minimum;
    }

    public int[] FindFirstPositiveItem(){
        int[] positive = new int[dimension];
        int count = 0;
        for(int i= 0; i<dimension;i++){
            for (int j=0; j<dimension; j++){
                if(matrix[i][j]>0){
                    positive[count] = matrix[i][j];
                    count++;
                    break;
                }
            }
        }
        return positive;
    }

    public int[] FindMinimumToDiagonal(){
        int[] minimum = new int[dimension];
        for(int i=0; i<dimension;i++){
            minimum[i]=matrix[i][0];
            for (int j=0; j<=i; j++){
                if(matrix[i][j]<minimum[i]) minimum[i]=matrix[i][j];
            }
        }
        return minimum;
    }
}
