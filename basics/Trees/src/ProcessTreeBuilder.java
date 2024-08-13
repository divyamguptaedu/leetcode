//Let's say you're writing an application that deals with processes on an operating system.
//Each process is identified by a unique positive integer identifier (called the pid).
//Processes can spawn arbitrarily many child processes. Each process has a unique parent process that spawned it,
//except for the special root process, which has no parent.
//With each process we also associate a ppid, or parent process identifier;
// for regular processes, this is the pid of the parent process, and for the root process, this is (arbitrarily) -1.
//
//Given the above description, it's natural to think of the processes on the operating system as forming a tree,
// rooted at the root process. You'd like to work with processes this way in your application.
// However, the API that the operating system exposes to you doesn't provide you with a tree,
// but with a flat list of objects -- each of which equipped with (among other metadata that we'll ignore)
// pid and ppid fields.
//
//For example, you might get something like this:
//
//var processes = [
//  {pid: 1, ppid: -1},
//  {pid: 219, ppid: 214},
//  {pid: 214, ppid: 1},
//  {pid: 124, ppid: 1}
//]
//This represents a set of four processes; process 1 (the root process),
// its two children processes 124 and 214, and 214's child process 219.
//
//Your task is to take this flat list representation and create a proper tree out of it,
// with a node for each process and edges between parents and their children.
// Processes will be represented by a class Process:
//
//function Process(pid, children) {
//  this.pid = pid;
//  this.children = children;
//}
//where pid is the integer pid and children is an array of children processes.
// Using this representation, the above set of processes might be represented as:
//
//new Process(1, [
//  new Process(124, []),
//  new Process(214, [
//    new Process(219, []),
//  ]),
//])
//Note that you may not assume anything about the order of the processes in the list;
// you can't assume that the root process comes first, or that in general parents appear before their children.
// (If it helps, you may assume that any given process's pid is greater than its ppid.)

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
class Process {
    int pid;
    List<Process> children;

    public Process(int pid, List<Process> children) {
        this.pid = pid;
        this.children = children;
    }
}
class ProcessTreeBuilder {

    public static Process buildProcessTree(List<int[]> processes) {
        // Maps to store Process objects and parent-child relationships
        Map<Integer, Process> processMap = new HashMap<>();
        Map<Integer, List<Integer>> childrenMap = new HashMap<>();
        int rootPid = -1;

        // Create Process objects and map their ids
        for (int[] process : processes) {
            int pid = process[0];
            int ppid = process[1];

            // Ensure each Process is created
            processMap.putIfAbsent(pid, new Process(pid, new ArrayList<>()));

            if (ppid == -1) {
                rootPid = pid;
            } else {
                processMap.putIfAbsent(ppid, new Process(ppid, new ArrayList<>()));
                childrenMap.computeIfAbsent(ppid, k -> new ArrayList<>()).add(pid);
            }
        }

        // Build the tree structure
        for (Map.Entry<Integer, List<Integer>> entry : childrenMap.entrySet()) {
            int parentPid = entry.getKey();
            List<Integer> childPids = entry.getValue();

            Process parentProcess = processMap.get(parentPid);
            for (int childPid : childPids) {
                parentProcess.children.add(processMap.get(childPid));
            }
        }

        return processMap.get(rootPid);
    }
}

class ProcessTreeBuilderTest {

    @Test
    public void testBasicCase() {
        List<int[]> processes = Arrays.asList(
                new int[]{1, -1},
                new int[]{219, 214},
                new int[]{214, 1},
                new int[]{124, 1}
        );

        Process root = ProcessTreeBuilder.buildProcessTree(processes);
    }

    @Test
    public void testSingleNode() {
        List<int[]> processes = Arrays.asList(new int[]{1, -1});

        Process root = ProcessTreeBuilder.buildProcessTree(processes);
        assertEquals(1, root.pid);
        assertEquals(0, root.children.size());
    }

    @Test
    public void testMultipleChildren() {
        List<int[]> processes = Arrays.asList(
                new int[]{1, -1},
                new int[]{2, 1},
                new int[]{3, 1},
                new int[]{4, 1}
        );

        Process root = ProcessTreeBuilder.buildProcessTree(processes);
        assertEquals(1, root.pid);
        assertEquals(3, root.children.size());
    }

    @Test
    public void testMultipleLevels() {
        List<int[]> processes = Arrays.asList(
                new int[]{1, -1},
                new int[]{2, 1},
                new int[]{3, 2},
                new int[]{4, 2},
                new int[]{5, 3}
        );

        Process root = ProcessTreeBuilder.buildProcessTree(processes);
    }

    @Test
    public void testEmptyInput() {
        List<int[]> processes = Arrays.asList();
        Process root = ProcessTreeBuilder.buildProcessTree(processes);
        assertEquals(null, root);
    }
}