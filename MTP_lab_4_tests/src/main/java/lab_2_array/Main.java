package lab_2_array;
import java.util.Scanner;

public class Main {
     public static int getNumber(String message){
         try{
          System.out.println(message);
          int number =   new Scanner (System.in).nextInt();
          return number;
         }
         catch (Exception ex){
             System.out.println("Это вообще не число");
             return getNumber(message);
         }
     }

    public static void main(String[] args) {
        System.out.print("Добро пожаловать!");
        Scanner myScanner = new Scanner (System.in);
        int choice ;
        while (true)
        {
            System.out.println("К какому заданию приступим? (Введите 1 или 2)");
            String line = myScanner.nextLine();
            try
            {
                choice = Integer.parseInt(line);
                if(!(choice ==1 || choice==2)) System.out.println("Проверьте ввод");
                else break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Это вообще не число");
            }
        }
        switch (choice) {
            case (1): {
                int size = getNumber("Введите размерность масива :");
                int[] user_array = new int[size];
                int i = 0;
                while (i < size) {
                    user_array[i] = getNumber("Введите " + (i+1) + "й елемент :");
                    i++;
                }
                    Array calculated_array = new Array(user_array);
                    System.out.println("Колическво позитивных елементов : " + calculated_array.FindNumerOfPositive());
                    int largeThanThree = calculated_array.SumOfElementsLargeThanThree();
                    String message = (largeThanThree > 0) ? ("Сума елементов, которые больше 3 : " + largeThanThree)  : "Нет елементов, которые больше 3";
                    System.out.println(message);
                    System.out.println("Максимальный елемент : " + calculated_array.FindMaximumElement());
                    System.out.println("Количество отрицательных елементов : " + calculated_array.FindNumberOfNegative());
                    if(calculated_array.FindNumberOfNegative() > 0){
                        System.out.println("Сума отрицательных елементов : " + calculated_array.FindSumOfNegative());
                    }
                    int divisibleByFive = calculated_array.FindMinimumNumberDivisibleByFive();
                    message = (divisibleByFive==0) ? "Нет елементов, кратных 5" : ("Минимальный елемент, кратный 5 : " + divisibleByFive);
                    System.out.println(message);
                    break;
                }

            case (2): {
                    int dimension = getNumber("Введите порядок матрицы : ");
                     Matrix matrix = new Matrix(dimension);
                     int colomn = matrix.FindColomn();
                    System.out.println();
                    System.out.println("Колонка, сума модулей елементов которой наибольшая : " + (colomn+1));
                    System.out.println("Наименьший елемент этой колонки : " + matrix.FindMinimumElement(colomn));

                    int [] minimumToDiagonal = matrix.FindMinimumToDiagonal();
                    for(int i =0; i < dimension; i++){
                        System.out.println("Наименьший элемент, который находиться вначале " + (i+1) + "-го рядка матрицы до диагонали включительно : " + minimumToDiagonal[i]);
                    }

                    int [] firstPositive = matrix.FindFirstPositiveItem();
                    for(int i =0; i < dimension; i++){
                        System.out.println("Первый позитивный елемент " + (i+1) + "-го рядка : " + firstPositive[i]);
                    }

            }
        }

    }
}
