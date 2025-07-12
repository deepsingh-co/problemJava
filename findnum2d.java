public class findnum2d {
    public static void main(String[] args) {
        int arr[][] ={{1,7,5},
                       {9,7,7},
                    {8,5,6}};
        findNum(arr, 9);
        addArr(arr);

    }

    public static int findNum(int arr [][] , int key){
        int find =0;
        for(int i = 0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if (arr[i][j]==key) {
                    find = find+1;
                    
                }
            }
        }
        System.out.println("you have total key is:" + find);
        return find;
    }

    // question no 2

    // addition of array

public static int addArr(int arr[][]){
    int sum =0;
    for(int j =0;j<arr[0].length;j++){
        sum +=  arr[1][j];
        

        }
        System.out.println("total sum of arr is :" + sum);
        return sum;
    }
}
