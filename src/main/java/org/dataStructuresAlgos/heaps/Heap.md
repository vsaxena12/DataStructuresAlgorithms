# Heap

1. Complete Binary tree (Ideal for array implementation)
2. Heap Property
   - Min heap
   - Max heap
       
                          5
                  10              20
              30       40     50      60
          70     80

Need for heaps
1. Search min and max numbers among a set of numbers in O(log n) time
2. Insert new element in O(log n) time

Types of Binary heap
1. Min heap - root is the min node
2. Max heap - root is the max node

Operations
1. Creating
2. peek
3. Extract
4. Traversal 
5. Size
6. Insertion
7. Deletion

Implementation
- Arrays Implementation
  - start with index 1
  - Left Child: cell[2x]
  - Right Child: cell[2x+1]

- Reference Implementation

## Time and Space Complexity

                            Time Complexity             Space Complexity
Create Binary Heap              O(1)                        O(N)
Peek of heap                    O(1)                        O(1)
Size of heap                    O(1)                        O(1)
Traversal of Heap               O(n)                        O(n)
Insert a node                   O(log n)                    O(log n)
Extract a node                  O(log n)                    O(log n)
Delete entire tree              O(1)                        O(1)

## Heapify
- Reorder the tree based on the heap property
  - Complete binary tree
  - Parent is max(or min) then the children

### Heapify-Up and Heapify-Down 

Are processes used to restore the heap property (either min-heap or max-heap) after an insertion or deletion operation in a heap. These operations are essential for maintaining the heap structure.

1. Heapify-Up (Percolate-Up)

Heapify-Up is used when a new element is added to the heap. Since new elements are initially added to the end of the heap (to maintain the complete binary tree property), the heap property may be violated. Heapify-Up ensures the heap property is restored by comparing the newly added element with its parent and swapping them if necessary.

Steps:

	1.	Insert the new element at the end of the heap.
	2.	Compare the inserted element with its parent:
	•	For a min-heap: Swap if the child is smaller than the parent.
	•	For a max-heap: Swap if the child is larger than the parent.
	3.	Repeat until the element is at the root or the heap property is satisfied.

Example (Min-Heap):

Given a min-heap:

    [2, 4, 3, 8]

	•	Insert 1:

    [2, 4, 3, 8, 1]

	•	Compare 1 with its parent (4). Swap:

    [2, 1, 3, 8, 4]

	•	Compare 1 with its new parent (2). Swap:

    [1, 2, 3, 8, 4]

The heap property is now restored.

Code for Heapify-Up:

    private void heapifyUp(int index) {
      int parentIndex = (index - 1) / 2;
      while (index > 0 && array[index] < array[parentIndex]) { // Min-heap condition
        // Swap the current element with its parent
        int temp = array[index];
        array[index] = array[parentIndex];
        array[parentIndex] = temp;

        // Move up the tree
        index = parentIndex;
        parentIndex = (index - 1) / 2;
      }
    }

2. Heapify-Down (Percolate-Down)

Heapify-Down is used when the root element of the heap is removed (e.g., during deletion). After removing the root, the last element in the heap is moved to the root position. Heapify-Down ensures the heap property is restored by comparing the new root with its children and swapping it with the appropriate child if necessary.

Steps:

	1.	Replace the root with the last element in the heap.
	2.	Compare the new root with its children:
	•	For a min-heap: Swap with the smaller child if the root is larger than either child.
	•	For a max-heap: Swap with the larger child if the root is smaller than either child.
	3.	Repeat until the element is at a leaf or the heap property is satisfied.

Example (Min-Heap):

Given a min-heap:

    [1, 2, 3, 8, 4]

	•	Remove 1 (the root). Replace with the last element (4):

    [4, 2, 3, 8]

	•	Compare 4 with its children (2 and 3). Swap with 2 (the smallest):

    [2, 4, 3, 8]

	•	The heap property is restored.

Code for Heapify-Down:

private void heapifyDown(int index) {
int smallest = index;
int leftChild = 2 * index + 1;
int rightChild = 2 * index + 2;

    // Compare with left child
    if (leftChild < count && array[leftChild] < array[smallest]) {
        smallest = leftChild;
    }

    // Compare with right child
    if (rightChild < count && array[rightChild] < array[smallest]) {
        smallest = rightChild;
    }

    // Swap if necessary and continue heapifying down
    if (smallest != index) {
        int temp = array[index];
        array[index] = array[smallest];
        array[smallest] = temp;
        heapifyDown(smallest); // Recursive call
    }
}

Key Differences Between Heapify-Up and Heapify-Down:

Aspect	Heapify-Up	Heapify-Down
When Used	After inserting a new element	After removing the root element
Direction	Moves up the tree	Moves down the tree
Starts At	The last (newly added) element	The root
Purpose	Ensures new element finds its correct spot	Ensures the root satisfies the heap property
Use Case	Used in insert operation	Used in delete operation
Time Complexity	￼	￼

Summary:

	•	Heapify-Up: Ensures the heap property after insertion by moving the element upward.
	•	Heapify-Down: Ensures the heap property after deletion by moving the element downward.
	•	Both operations are critical for maintaining the heap property and have a time complexity of.

    public int parent(int index){
        if(index<=0 || index>this.count){
          return -1;
        }
        return (index-1)/2;
    }

    public int leftChild(int i){
        int left = 2*i+1;

        if(left>=this.count){
            return -1;
        }
        return left;
    }

    public int rightChild(int i){
        int right = 2*i+2;

        if(right>=this.count){
            return -1;
        }
        return right;
    }

    /**
     * Get Max/Min element
     * @return root
     */
    public int getRoot() {
        if (this.count == 0)
            return -1;
        return this.array[0];
    }


    /**
     * 	Insert the new element at the end.
     * 	Heapify by comparing with the parent and swapping if necessary, until the heap property is restored.
     * 	This process is efficient, with a time complexity of O(\log n), as you only move up the height of the tree.
     */
    public void insert(int data) {
        //Cannot insert anymore elements
        if (this.count == this.capacity) { 
            System.out.println("Heap is full!");
            return;
        }
        this.count++;
        int index = this.count - 1;
        this.array[index] = data;
        heapifyUp(index); // Maintain the heap property
    }

    /**
     *  Remove the root element (min or max, depending on heap type).
     * 	Replace the root with the last element in the heap.
     * 	Heapify to restore the heap property, swapping with children as necessary until the heap property is satisfied.
     * @return root
     */
    public int deleteRoot() {
        if (this.count == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }
        int root = this.array[0];
        this.array[0] = this.array[this.count - 1];
        this.count--;
        heapifyDown(0); // Maintain the heap property
        return root;
    }

    private boolean compare(int child, int parent) {
        // Comparison based on heap type (min-heap or max-heap)
        if (heap_type == 0) {
            return child < parent; // Min-heap condition
        } else {
            return child > parent; // Max-heap condition
        }
    }

## Heap Sort

- Insert element into a heap
- Heapify-up to maintain heap property
- Remove the root
- Heapify-down to maintain heap property
- Repeat the process. 

Everytime we get the root element, it is either min or max element.
This is how we get elements sorted. 