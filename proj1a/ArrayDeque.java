public class ArrayDeque<T> implements Deque<T>{

    private int size;
    private T[] list;
    /*
    head指向头，tail指向尾部即将加入的位置
    这样保证始终都能有一个位置插入数据
     */
    private int head, tail;


    public ArrayDeque() {
        list = (T[]) new Object[8];
        size = 0;
    }

    private void DoubleSize() {
        T[] newList = (T[]) new Object[list.length * 2];
        System.arraycopy(list, head, newList, 0, (list.length - head));
        System.arraycopy(list, 0, newList, (list.length - head), tail);
        head = 0;
        tail = size;
        list = newList;
    }

    public void addFirst(T item) {
        // 先插入，再判断
        head = (head - 1 + list.length) % list.length;
        list[head] = item;
        if (tail == head) {
            DoubleSize();
        }
        size++;
    }

    public void addLast(T item) {
        list[tail] = item;
        tail = (tail + 1) % list.length;
        if (tail == head) {
            DoubleSize();
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int p = head;
        while (p != tail) {
            System.out.print(list[p] + " ");
            p = (p + 1) % list.length;
        }
    }

    public T removeLast() {
        if (head == tail) {
            return null;
        } else {
            tail = (tail - 1 + list.length) % list.length;
            T item = list[tail];
            list[tail] = null;
            size--;
            if (1.0 * size / list.length <= 0.25 && list.length > 8) {
                HalfSize();
            }
            return item;
        }
    }

    public T removeFirst() {
        if(head == tail){
            return null;
        } else {
            T item = list[head];
            list[head] = null;
            head = (head + 1) % list.length;
            size --;
            if (1.0 * size / list.length <= 0.25 && list.length > 8) {
                HalfSize();
            }
            return item;
        }
    }

    private void HalfSize() {
        T[] newList = (T[]) new Object[list.length / 2];
        if(head < tail) {
            System.arraycopy(list, head, newList, 0, size);
            head = 0;
            tail = size;
        }else {
            System.arraycopy(list,head,newList,0,(list.length - head));
            System.arraycopy(list,0,newList,(list.length - head),tail);
            head = 0;
            tail = size;
        }
        list = newList;
    }

    public T get(int index) {
        int realIndex = (head + index) % list.length;
        if (realIndex < tail) {
            return list[realIndex];
        } else {
            return null;
        }
    }
}
