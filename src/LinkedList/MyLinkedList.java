package LinkedList;

import java.util.Comparator;

/**
 * реализация связного списка.
 *
 * @param <T> тип элементов списка
 */
public class MyLinkedList<T> {
    private Node<T> head; // первый элемент списка
    private int size; // размер списка

    /**
     * создает пустой список.
     */
    public MyLinkedList() {
        head = null; // вначале список пустой, поэтому первый элемент = null
        size = 0; // вначале размер списка равен 0
    }

    /**
     * добавляет элемент в конец списка.
     *
     * @param item элемент, который нужно добавить
     */
    public void add(T item) {
        Node<T> newNode = new Node<>(item); // создаем новый узел с заданным элементом
        if (head == null) {
            head = newNode; // если список пустой, новый узел становится первым элементом
        } else {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next; // двигаемся по списку до последнего элемента
            }
            currentNode.next = newNode; // последний элемент указывает на новый узел
        }
        size++; // увеличиваем размер списка
    }

    /**
     * добавляет элемент по заданному индексу.
     *
     * @param index индекс, по которому нужно добавить элемент
     * @param item  элемент, который нужно добавить
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона
     */
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс: " + index); // проверка допустимости диапазона
        }
        if (index == 0) {
            Node<T> newNode = new Node<>(item);
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next; // двигаемся по списку до элемента перед заданным индексом
            }
            Node<T> newNode = new Node<>(item);
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        size++; // увеличиваем размер списка
    }
    /**
     * возвращает элемент по заданному индексу.
     *
     * @param index индекс элемента, который нужно вернуть
     * @return элемент списка по заданному индексу
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс: " + index); // проверка допустимости диапазона
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next; // двигаемся по списку до нужного элемента
        }
        return currentNode.data; // возвращаем элемент списка по заданному индексу
    }

    /**
     * сортирует список с использованием заданного компаратора.
     *
     * @param c компаратор для сравнения элементов списка
     */
    public void sort(Comparator<? super T> c) {
        if (size <= 1) {
            return; // список уже отсортирован или пуст
        }

        boolean swapped;
        do {
            swapped = false;
            Node<T> current = head;
            Node<T> previous = null;

            while (current.next != null) {
                Node<T> next = current.next;

                if (c.compare(current.data, next.data) > 0) {
                    swapped = true;
                    if (previous != null) {
                        previous.next = next;
                    } else {
                        head = next;
                    }

                    current.next = next.next;
                    next.next = current;

                    previous = next;
                    next = current.next; // continue with the next iteration
                } else {
                    previous = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (swapped);
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс: " + index); // проверка допустимости диапазона
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next; // двигаемся по списку до элемента перед удаляемым элементом
            }
            currentNode.next = currentNode.next.next;
        }
        size--; // уменьшаем размер списка
    }

    /**
     * очищает список, удаляя все элементы.
     */
    public void clear() {
        head = null; // просто устанавливаем первый элемент в null, чтобы список был пустым
        size = 0; // устанавливаем размер списка в 0
    }

    /**
     * возвращает размер списка.
     *
     * @return размер списка
     */
    public int size() {
        return size;
    }

    /**
     * проверяет, является ли список пустым.
     *
     * @return true, если список пустой, иначе false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * вспомогательный класс, представляющий узел списка.
     *
     * @param <T> тип элементов списка
     */
    private static class Node<T> {
        private T data; // данные узла списка
        private Node<T> next; // указатель на следующий узел списка

        /**
         * создает новый узел с заданными данными.
         *
         * @param data данные узла
         */
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}