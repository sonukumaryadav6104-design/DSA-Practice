class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n = asteroids.length;
        Arrays.sort(asteroids);
        long currentmass = mass;

        for(int i = 0 ;i < n ; i++){
            if(currentmass<asteroids[i]){
                return false;
            }
            currentmass += asteroids[i]; 
        }
        return true;
    }
}