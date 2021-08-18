class FileSystem {
    private Node root;

    private class Node {
        Map<String, Node> next;
        String content;
        public Node() {
            this.next = new HashMap<>();
            content = null;
        }
        public Node(String content) {
            next = null;
            this.content = content;
        }
    }

    public FileSystem() {
        this.root = new Node();
    }
    
    public List<String> ls(String path) {
        Node node = this.root;
        String nextPath = null;
        Queue<String> paths = getPath(path);
        
        while (!paths.isEmpty()) {
            nextPath = paths.poll();
            node = node.next.get(nextPath);
        }
        
        List<String> output;
        if (node.next == null) {
            output = Arrays.asList(nextPath);
        } else {
            output = new ArrayList<String>(node.next.keySet());
            Collections.sort(output);
        }
        return output;
    }
    
    public void mkdir(String path) {
        Node node = this.root;
        Queue<String> paths = getPath(path);
        while (!paths.isEmpty()) {
            String nextPath = paths.poll();
            if (!node.next.containsKey(nextPath)) node.next.put(nextPath, new Node());
            node = node.next.get(nextPath);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Node node = this.root;
        Queue<String> paths = getPath(filePath);
        while (paths.size() > 1) {
            String nextPath = paths.poll();
            if (!node.next.containsKey(nextPath)) node.next.put(nextPath, new Node());
            node = node.next.get(nextPath);
        }
        String fileName = paths.poll();
        if (!node.next.containsKey(fileName)) node.next.put(fileName, new Node(content));
        else node.next.get(fileName).content += content;
    }
    
    public String readContentFromFile(String filePath) {
        Node node = this.root;
        Queue<String> paths = getPath(filePath);
        while (!paths.isEmpty()) {
            String nextPath = paths.poll();
            node = node.next.get(nextPath);
        }
        return node.content;
    }

    private Queue<String> getPath(String path) {
        char[] chars = path.toCharArray();
        if (chars.length == 0 || chars[0] != '/') return null;
        Queue<String> queue = new LinkedList<>();
        int L = 1;
        for (int R = 2; R <= chars.length; R++) {
            if (R == chars.length || chars[R] == '/') {
                queue.add(path.substring(L, R));
                L = ++R;
            }
        }
        return queue;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */