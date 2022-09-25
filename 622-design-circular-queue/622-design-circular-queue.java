class MyCircularQueue {
    int[] data;
    int start =0;
    int end = -1;
    int size = 0;
    public MyCircularQueue(int k) {
        data = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        else{
            end++;
            end = end%data.length;
            data[end]=value;
            size++;
            return true;
        }
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        else{
            start++;
            start = start%data.length;
            size--;
            return true;
        }
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return data[start];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return data[end];
    }
    
    public boolean isEmpty() {
        if(size==0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isFull() {
        if(size==data.length){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */