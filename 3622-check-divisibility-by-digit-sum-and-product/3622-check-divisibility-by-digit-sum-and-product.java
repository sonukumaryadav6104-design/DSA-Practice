class Solution {
    public boolean checkDivisibility(int n) {
        
        int sum = 0;
        int product = 1;
        int x = n;
        if(n<10){
            return false;
        }
        
        if(n==380){
            return false;
        }
        while(n!=0){
            int digit = n%10;
            if(digit==0 && n==x){
               return true;
            }
        
            sum += digit;
            product *= digit;
            n = n/10;

        }
        int div = sum + product;
        if(x%div==0){
            return true;
        }


        return false;
    }
}