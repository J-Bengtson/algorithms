class CombinationSum{
    
    
    ArrayList<List<Integer>> lista = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        back(new ArrayList<>() , candidates , target);
        
        return lista;
    }
    
    public void back(ArrayList<Integer> arr , int[] candidates , int target ){
        if( target == 0){
            
            System.out.println(arr);
            
            lista.add(arr);
            
            return;
        }
        else if(target < 0){
            return;
        }
        // System.out.println(arr);
        
        for(int x = 0 ; x < candidates.length ; x++){
            
                
            arr.add(candidates[x]);
            
            back(arr , candidates , target - candidates[x] );
            
            arr.remove(arr.size()-1);
            
        }
        
    }
    
}
