import queue

# Find median in a stream of integers


class MedianFinder:
    max_heap = queue.PriorityQueue()
    min_heap = queue.PriorityQueue()

    def add(self, val: int):
        self.max_heap.put_nowait((-1 * val, val))
        self.min_heap.put_nowait(self.max_heap.get()[1])
        if self.max_heap.qsize() < self.min_heap.qsize():
            min_val = self.min_heap.get_nowait()
            self.max_heap.put_nowait((-1 * min_val, min_val))

    def find_median(self):
        if self.max_heap.qsize() == 0:
            return None
        elif self.max_heap.qsize() == self.min_heap.qsize():
            return (self.max_heap.queue[0][1] + self.min_heap.queue[0]) / 2
        else:
            return self.max_heap.queue[0][1]


def test_find_median():
    mf = MedianFinder()
    assert mf.find_median() is None, "Median should be None for empty stream"

    mf.add(1)
    assert mf.find_median() == 1

    mf.add(2)
    assert mf.find_median() == 1.5

    mf.add(100)
    assert mf.find_median() == 2
