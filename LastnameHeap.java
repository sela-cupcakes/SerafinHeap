public class LastnameHeap {

    private int[] heap;
    private int size;
    private int capacity;

    public LastnameHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity + 1]; // 0 index is not used
        this.size = 0;
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        size++;
        heap[size] = value;
        heapifyUp(size);
    }

    private void heapifyUp(int index) {
        while (index > 1 && heap[index] < heap[index / 2]) {
            swap(index, index / 2);
            index /= 2;
        }
    }

    public int deleteMin() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1; // Or throw an exception
        }
        int min = heap[1];
        heap[1] = heap[size];
        size--;
        heapifyDown(1);
        return min;
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int leftChild = 2 * index;
        int rightChild = 2 * index + 1;

        if (leftChild <= size && heap[leftChild] < heap[smallest]) {
            smallest = leftChild;
        }
        if (rightChild <= size && heap[rightChild] < heap[smallest]) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


    public static void main(String[] args) {
        LastnameHeap heap = new LastnameHeap(10);
        heap.insert(10);
        heap.insert(5);
        heap.insert(15);
        heap.insert(2);
        heap.insert(8);

        System.out.println("Min element: " + heap.deleteMin());
        System.out.println("Min element: " + heap.deleteMin());

    }
}