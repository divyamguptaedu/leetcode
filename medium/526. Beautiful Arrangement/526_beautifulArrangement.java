class Solution {
    
    int noOfBeautifulArrangement= 0;//Stores the number of Beautiful Arrangement possible 
    
    public int countArrangement(int n) { //Branch And Bound Recursive Approach 
        
        boolean []visited= new boolean[n+1];//To ensure that we dont visit the same index in permutation again 
        
        permutationGenerator(n, visited, 1, "");
        
        return noOfBeautifulArrangement;
    }
    public void permutationGenerator(int n, boolean []visited, int c, String sequenceSoFar){
        
        if( c > n) {//Base Case // Beautiful Sequence found of n length 
            
            noOfBeautifulArrangement+= 1;
            
            System.out.println(sequenceSoFar.substring(1)+".\n\n");//Just to see the sequence // Not Mandetory 
            
            return;
        }
        
        for ( int i= 1; i <= n; i++){
            
            if ( !visited[i] && ( i % c == 0 || c % i == 0 )){//Condition for branching further i.e, explore next permutations 
                
                visited[i]= true;//Marking the current index as  visited 
                
                permutationGenerator( n, visited, c+1, sequenceSoFar+","+i);
                
                visited[i]= false;//Marking the current index as unvisited, in order to explore other permuutation sequences  
                
            }
        }
    }
}