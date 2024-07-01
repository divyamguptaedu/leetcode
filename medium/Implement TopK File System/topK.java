/*
 Implement "du -a input_dir | sort -n -r | head -n K".
*/

abstract class Container {
    protected String name;
    protected long size;

    public Container(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    protected abstract void computeSize(Map<Directory, Long> memo);
}

class File extends Container {
    public File(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    protected void computeSize(Map<Directory, Long> memo) {
        // File size is already known, no need to compute
    }
}

class Directory extends Container {
    private List<Container> children;

    public Directory(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    public void addEntry(Container entry) {
        children.add(entry);
    }

    public List<Container> getChildren() {
        return children;
    }

    @Override
    protected void computeSize(Map<Directory, Long> memo) {
        if (memo.containsKey(this)) {
            // Retrieve the precomputed size from the memo map
            this.size = memo.get(this);
        } else {
            // Compute the size of the directory by summing the sizes of its children
            long totalSize = 0;
            for (Container child : children) {
                child.computeSize(memo);
                totalSize += child.getSize();
            }
            this.size = totalSize;
            // Store the computed size in the memo map
            memo.put(this, totalSize);
        }
    }
}

public class TopKInDirectory {
    // Static memoization map to persist across multiple calls
    private static Map<Directory, Long> memo = new HashMap<>();

    public static List<Container> topK(Directory root, int K) {
        PriorityQueue<Container> minHeap = new PriorityQueue<>(Comparator.comparingLong(Container::getSize));
        
        // Traverse and compute sizes
        traverse(root);

        // Populate the priority queue with the top K entries
        for (Container entry : root.getChildren()) {
            if (minHeap.size() < K) {
                minHeap.offer(entry);
            } else if (entry.getSize() > minHeap.peek().getSize()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        List<Container> result = new ArrayList<>(minHeap);
        result.sort((e1, e2) -> Long.compare(e2.getSize(), e1.getSize())); // Sort descending
        return result;
    }

    private static void traverse(Directory dir) {
        dir.computeSize(memo);
        for (Container entry : dir.getChildren()) {
            if (entry instanceof Directory) {
                traverse((Directory) entry);
            }
        }
    }
}

public class ContainerTest {

    private Directory root;
    private Directory subDir1;
    private Directory subDir2;
    private File file1;
    private File file2;
    private File file3;
    private File file4;
    private File file5;

    @Before
    public void setUp() {
        root = new Directory("root");
        subDir1 = new Directory("subDir1");
        subDir2 = new Directory("subDir2");

        file1 = new File("file1.txt", 100);
        file2 = new File("file2.txt", 200);
        file3 = new File("file3.txt", 50);
        file4 = new File("file4.txt", 300);
        file5 = new File("file5.txt", 150);

        root.addEntry(file1);
        root.addEntry(subDir1);
        root.addEntry(subDir2);

        subDir1.addEntry(file2);
        subDir1.addEntry(file3);

        subDir2.addEntry(file4);
        subDir2.addEntry(file5);
    }

    @Test
    public void testFileSize() {
        assertEquals(100, file1.getSize());
        assertEquals(200, file2.getSize());
        assertEquals(50, file3.getSize());
        assertEquals(300, file4.getSize());
        assertEquals(150, file5.getSize());
    }

    @Test
    public void testDirectorySize() {
        Map<Directory, Long> memo = new HashMap<>();
        root.computeSize(memo);
        assertEquals(800, root.getSize());
        assertEquals(250, subDir1.getSize());
        assertEquals(450, subDir2.getSize());
    }

    @Test
    public void testAddEntry() {
        Directory newDir = new Directory("newDir");
        root.addEntry(newDir);
        assertTrue(root.getChildren().contains(newDir));
    }

    @Test
    public void testTopK() {
        List<Container> topKEntries = TopKInDirectory.topK(root, 3);
        assertEquals(3, topKEntries.size());
        assertEquals("file4.txt", topKEntries.get(0).getName());
        assertEquals("subDir2", topKEntries.get(1).getName());
        assertEquals("file2.txt", topKEntries.get(2).getName());
    }
}