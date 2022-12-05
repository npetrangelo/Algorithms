import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HeapTest {
    static Heap heap;

    @BeforeEach
    void init() {
        heap = new Heap(10);
    }

    @Test
    void testMinimalHeap() throws Heap.EmptyHeapException {
        heap.add(10);
        assertEquals(10, heap.extractMin());
    }

    @Test
    void testFullHeap() throws Heap.EmptyHeapException {
        for (int i = 0; i < 10; i++) {
            heap.add(i);
        }
        assertEquals(0, heap.extractMin());
        assertEquals(1, heap.extractMin());
        assertEquals(2, heap.extractMin());
        assertEquals(3, heap.extractMin());

    }

    @Test
    void testChangeValue() throws Heap.EmptyHeapException {
        for (int i = 0; i < 10; i++) {
            heap.add(i);
        }
        heap.changeKeyValue(1, 11);
        assertEquals(1, heap.extractMin());
    }

    @Test
    void testEmptyHeap() {
        assertThrows(Exception.class, () -> heap.extractMin());
    }
}
