// this is question no 32 from ds sheet ,
//its is medium type question of array
// in this question we finding the space between fwo aaray by comparing the left and right side

public class trappingWater {
    public static int trappedRainWater(int height[]){
        int n = height.length;
 //calculate leftmax boundary = in form of array 
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i =1;i<n;i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
//calculate rightmax boundary = in form of array 
        int rightMAx[] = new int[n];
        rightMAx[n-1] = height[n-1];
        for(int i =n-2;i>=0;i--){
            rightMAx[i] = Math.max(height[i], rightMAx[i+1]);
        }
//loop
        int trappedWater = 0;
        for(int i = 0;i<n;i++){
//waterlevel = min(leftmax ,rightmax)
            int waterlevel =Math.min(leftMax[i], rightMAx[i]);

 //trapped water = waterlevel -height[i]
            trappedWater += waterlevel -height[i];
        }
        return trappedWater;

        
       
    }

    public static void main(String[] args) {
        int height[]={4,2,0,6,1,2,3};
        System.out.println(trappedRainWater(height));

    }
}