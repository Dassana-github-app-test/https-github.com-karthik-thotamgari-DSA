    class NumberContainers { 
    TreeMap<Integer,Integer> hmap = new TreeMap();
    public NumberContainers() {
    }
    
    public void change(int index, int number) {
        hmap.put(index,number);
    }
    
    public int find(int number) {
        for(int i:hmap.keySet()){
            if(hmap.get(i)==number){
                return i;
            }
        }
        return -1;
    }
}