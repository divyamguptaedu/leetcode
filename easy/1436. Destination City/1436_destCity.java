//To solve the problem of finding the destination city in a list of paths, 
//I used a set to track cities with outgoing paths. 
//I first added all cities with outgoing paths to this set. 
//Then, I iterated through the destination cities and checked which one wasn't 
//in the set of cities with outgoing paths. 
//This city is the destination city, as it has no outgoing paths.

//Time: n
//Space: n
class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> hasOutgoing = new HashSet();
        for (int i = 0; i < paths.size(); i++) {
            hasOutgoing.add(paths.get(i).get(0));
        }
        
        for (int i = 0; i < paths.size(); i++) {
            String candidate = paths.get(i).get(1);
            if (!hasOutgoing.contains(candidate)) {
                return candidate;
            }
        }
        
        return "";
    }
}