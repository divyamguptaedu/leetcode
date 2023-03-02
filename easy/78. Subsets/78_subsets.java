class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsequence(0, nums, new ArrayList<>(), result);
        return result;
    }

    static void subsequence(int i, int[] arr, List<Integer> list, List<List<Integer>> result) {
        if (result.contains(list)) {
            return;
        }
        if (i == arr.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[i]);
        subsequence(i + 1, arr, list, result);
        list.remove(list.size() - 1);
        subsequence(i + 1, arr, list, result);
    }
}