package ArrayList;

public class ArrayListRunner {

        public static void main(String[] args) {
            // создаем новый экземпляр MyArrayList
            MyArrayList<String> list = new MyArrayList<>();

            // добавляем элементы в список
            list.add("элемент 1");
            list.add("элемент 2");
            list.add("элемент 3");

            // выводим элементы списка
            System.out.println("Элементы списка:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

            // добавляем элемент по адресу
            list.add(1, "элемент вставленный по адресу 1");

            // выводим элементы списка после вставки
            System.out.println("Элементы списка после вставки:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

            // удаляем элемент из списка
            list.remove(2);

            // выводим элементы списка после удаления
            System.out.println("Элементы списка после удаления:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

            // очищаем список
            list.clear();

            // выводим элементы списка после очистки
            System.out.println("Элементы списка после очистки:");
            for (int i = 0; i < list.size(); i++) {

                System.out.println(list.get(i));
            }

            // добавляем еще элементы в список
            list.add("новый элемент 2");
            System.out.println("Добавили новый элемент 2");
            list.add("новый элемент 1");
            System.out.println("Добавили новый элемент 1");

            // сортируем список
            list.sort();

            // выводим элементы списка после сортировки
            System.out.println("Элементы списка после сортировки:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }


        }
    }

