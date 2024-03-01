package LinkedList;

import java.util.Collections;

public class LinkedListRunner {
    public static void main(String[] args) {
        // создание объекта MyLinkedList и добавление элементов в конец списка
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Элемент 1");
        list.add("Элемент 2");
        list.add("Элемент 3");
        System.out.println("Выводим добавленные элементы");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Индекс " + i + ": " + list.get(i));
        }
        System.out.println("Конец списка");

        //добавление элемента на определенный индекс
        list.add(1, "Элемент 4");
        System.out.println("По индексу 1 находится: "+ list.get(1));

        //удаление элемента по индексу:
        list.remove(2);

        //получение элемента по индексу:
        String element = list.get(0);

        //проверка размера списка
        int size = list.size();
        System.out.println("вывести содержимое списка и его размер:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Индекс " + i + ": " + list.get(i));
        }
        System.out.println("Размер списка: " + list.size());

        //очистка списка
        System.out.println("Проверка метода очистки списка");
        list.clear();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Индекс " + i + ": " + list.get(i));
        }



        System.out.println("проверка метода сортировки");
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list2.add(5);
        list2.add(2);
        list2.add(8);
        list2.add(3);
        list2.sort(Collections.reverseOrder());
        for (int i = 0; i < list2.size(); i++) {
            System.out.println("Индекс " + i + ": " + list2.get(i));
        }

    }
}