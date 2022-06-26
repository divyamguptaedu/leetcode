"""
Performance:
Runtime: 57 ms, faster than 35.83% of Java online submissions for Find Duplicate File in System.
Memory Usage: 72.3 MB, less than 19.64% of Java online submissions for Find Duplicate File in System.
"""

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> hashMap = new HashMap();
        for (String path : paths) {
            String[] files = path.split(" ");
            String folder = files[0];
            for (String file : files) {
                int index = file.indexOf("(");
                if (index == -1) {
                    continue;
                }
                String fileName = file.substring(0, index);
                String fileContent = file.substring(index + 1, file.length() - 1);
                hashMap.putIfAbsent(fileContent, new ArrayList<String>());
                hashMap.get(fileContent).add(folder + "/" + fileName);
            }
        }
        List<List<String>> results = new ArrayList();
        for (List<String> files : hashMap.values()) {
            if (files.size() > 1) {
                results.add(files);
            }
        }
        return results;
    }
}