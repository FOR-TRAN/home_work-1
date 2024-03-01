package ArrayList;

import java.util.Arrays;

/**
 * реализация ArrayList.
 *
 * @param <T> тип элементов, хранящихся в списке.
 */
public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    /**
     * конструктор создает пустой список с начальной емкостью 10
     */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * добавляет элемент в конец списка
     *
     * @param item элемент для добавления
     */
    public void add(T item) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = item;
    }

    /**
     * добавляет элемент по указанному адресу
     *
     * @param index индекс, куда нужно добавить элемент
     * @param item  элемент для добавления
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона
     */
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
        if (size == elements.length) {
            increaseCapacity();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    /**
     * возвращает элемент по указанному адресу
     *
     * @param index индекс элемента
     * @return элемент на указанной позиции
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
        return (T) elements[index];
    }

    /**
     * удаляет элемент по указанному адресу
     *
     * @param index индекс удаляемого элемента
     * @return удаленный элемент
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
        T removedElement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removedElement;
    }

    /**
     * очищает весь список
     */
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    /**
     * cортирует список (алгоритм сортировки пузырьком)
     */
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) elements[j]).compareTo((T) elements[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    /**
     * swap используется методом, который сортирует массив
     * @param index1 индекс 1 элемента
     * @param index2 индекс второго элемента
     */
    private void swap(int index1, int index2) {
        T temp = (T) elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = temp;
    }

    /**
     * метод используется для автоматического увеличения ёмкости списка
     */
    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    /**
     * возвращает количество элементов в списке
     *
     * @return количество элементов в списке
     */
    public int size() {
        return size;
    }
}