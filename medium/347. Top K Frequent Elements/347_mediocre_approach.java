class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> valueMap = new HashMap<>();
        for (int x : nums) {
            if (valueMap.get(x) == null) {
                valueMap.put(x, 1);
            } else {
                valueMap.put(x, valueMap.get(x) + 1);
            }
        }
        HashMap<Integer, Integer> keyMap = new HashMap<>();
        for (int y : valueMap.keySet()) {
            keyMap.put(valueMap.get(y), y);
        }
        ArrayList<Integer> array = new ArrayList<>();
        for (int z : keyMap.keySet()) {
            array.add(z);
        }
        MaxHeap heap = new MaxHeap(array);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = (keyMap.get(heap.remove()));
        }
        return result;
    }
}













// class Solution {
//     public String decodeString(String s) {
//         if(s==null || s.length() ==0){
//             return s;
//         }
//         String curr = "";
//         int num =0;
//         Stack<String> d = new Stack<>();
//         for(int i = 0; i<s.length(); i++){
//             char ch = s.charAt(i);
//             if(Character.isDigit(ch)){
//                 num = num*10 + ch - '0';
//             }
//             else if(ch == '['){
//                 d.push(curr);
//                 d.push(String.valueOf(num));
//                 num =0;
//                 curr = "";
//             }
//             else if(ch == ']'){
//                 int times = Integer.parseInt(d.pop());
//                 StringBuilder sb = new StringBuilder();
//                 for(int j =0; j<times; j++){
//                     sb.append(curr);
//                 }
//                 curr = d.pop() + sb.toString();
//             }
//             else{
//                 curr += ch;
//             }
//         }
//        return curr; 
//     }
// }