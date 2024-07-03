/*
Given a list of Box, {box1, box2, box3, ..., boxN}. Each's weight is unknown. There is a method bool heavierThan(Box b1, Box b2); returns true when b1 is heavier than b2;

find second heaviest box in the list;
*/

class Box {
    Box() {}
}

class Solution {
    public Box findKthHeaviest(List<Box> boxes, int k) {
        if (boxes == null || boxes.size() < k || k <= 0) {
            return null;
        }
        return quickSort(boxes, 0, boxes.size() - 1, k);
    }

    private Box quickSort(List<Box> boxes, int left, int right, int k) {
        if (left == right) {
            return boxes.get(left);
        }

        int pivotIndex = partition(boxes, left, right); //parititon helper method
        int count = pivotIndex - left + 1;

        if (count == k) {
            return boxes.get(pivotIndex);
        } else if (k < count) {
            return quickSort(boxes, left, pivotIndex - 1, k);
        } else {
            return quickSort(boxes, pivotIndex + 1, right, k - count);
        }
    }

    private int parition(List<Box> boxes, int left, int right) {
        Box pivot = boxes.get(right);
        int i = left;
        for (int j = left; j < right; j++) {
            if (heavierThan(boxes.get(j), pivot)) {
                swap(boxes, i, j); //swap helper
                i++;
            }
        }

        swap(boxes, i, right);
        return i;
    }

    private void swap(List<Box> boxes, int i, int j) {
        Box temp = boxes.get(i);
        boxes.set(i, boxes.get(j));
        boxes.set(j, temp); 
    }
}

class Solution {
    public Box findKthHeaviest(List<Box> boxes, int k) {
        if (boxes == null || boxes.size() < k || k <= 0) {
            return null;
        }

        PriorityQueue<Box> minHeap = new PriorityQueue<>(k, new Comparator<Box>() {
            @Override
            public int compare(Box b1, Box b2) {
                if (heavierThan(b1, b2)) {
                    return 1;
                } else if (heavierThan(b2, b1)) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < k; i++) {
            minHeap.add(boxes.get(i));
        }

        for (int i = k; i < boxes.size(); i++) {
            Box currentBox = boxes.get(i);
            if (heavierThan(currentBox, minHeap.peek())) {
                minHeap.poll();
                minHeap.add(currentBox);
            }
        }

        return minHeap.peek();
    }
}