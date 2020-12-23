import java.util.Arrays;

public class MyList <E> {
   private int size = 0;
   static final int DEFAULT_CAPACITY = 10;
   private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    MyList (int size){
        size = size;
        elements = new Object[size];
    }
    private void ensureCapa(){
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements,newSize);
    }
    void add(int index, E element){
        if(size== elements.length){
            ensureCapa();
        }
        elements[size] = element;
        size++;
    }
    public void add( E element){
        if(size == elements.length){
            ensureCapa();
        }
        elements[size] = element;
        size++;
    }
    public E remove(int index){
        E valueOf = (E) elements[index];
        for (int i = 0; i < elements.length-1; i++) {
            elements[i] = elements[i+1];
        }
        if(size>0) size--;
        return valueOf;
    }
    public E[] clone(){
        E clone = (E) this.elements;
        return (E[]) clone;
    }
    public boolean constant(E e){
        boolean constant = false;
        for (Object element : elements) {
            if(e==element) constant = true;
            break;
        }
        return constant;
    }
    public int indexOf(E o){
        int index = -1;
        for (int i = 0; i < this.elements.length; i++) {
            if(this.elements[i] == o){
                index = i;
            }
        }
        return index;
    }
    public E get(int i){
        return (E)this.elements[i];
    }
    public void clear(){
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < this.size; i++) {
            if(i<this.size-1){
                result += this.elements[i] + ";";
            } else {
                result += this.elements[i];
            }
        }
        result += "]";
        return result;
    }
}
