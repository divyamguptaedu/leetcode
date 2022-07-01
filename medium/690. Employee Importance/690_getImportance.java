"
Performance:
Runtime: 4 ms, faster than 100.00% of Java online submissions for Employee Importance.
Memory Usage: 43.2 MB, less than 85.07% of Java online submissions for Employee Importance.
"

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map = new HashMap<>(); 
        for (Employee employee: employees) {
            map.put(employee.id, employee);
        }
        return getImportanceUtil(id, map);
        
    }
    
    public int getImportanceUtil(int id, Map<Integer,Employee> map) {
        Employee employee = map.get(id);
        int importance = employee.importance;
        for (Integer eId: employee.subordinates) {
            importance += getImportanceUtil(eId, map);
        }
        
        return importance;
        
    }
    
}