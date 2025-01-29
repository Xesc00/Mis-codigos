package productorconsumidor;

import java.util.Deque;
import java.util.LinkedList;

class PCMonitor {
    int size, count = 0, in = 0, out = 0;
    Deque<Integer> buffer = new LinkedList<Integer>();

    public PCMonitor(int size) {
        this.size = size;
    }

    synchronized public int take() {
        Integer data;

        while (buffer.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        data = buffer.remove();
        notifyAll();
        return data;
    }

    synchronized public void append(Integer data) {
        while (buffer.size() == size) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        buffer.add(data);
        notifyAll();
    }
}
