package com.meretskiy.stream.api;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainClass {
    private static class Person {
        enum Position {
            ENGINEER, DIRECTOR, MANAGER;
        }

        private String name;
        private int age;
        private Position position;

        public Person(String name, int age, Position position) {
            this.name = name;
            this.age = age;
            this.position = position;
        }
    }

    public static void main(String[] args) {
        flatMapEx();
    }

    //посчитать список уникальных слов
    private static void flatMapEx() {
        try {
            Files.lines(Paths.get("text.txt")) //открываем файл, вычитываем все строки
                    .map(line -> line.split("\\s")) //каждую строку преобразуем к массиву строк путем разделения по пробелу
                    .distinct() //находим уникальные слова
                    .forEach(arr -> System.out.println(Arrays.toString(arr))); //печатаем в консоль
            //не получилось, мапинг создал массив уникальных строк
            System.out.println("----------------------");
            Files.lines(Paths.get("text.txt"))
                    .map(line -> line.split("\\s")) // arr[0] arr[1] arr[2] arr[3]
                    .map(Arrays::stream)
                    .distinct()
                    .forEach(System.out::println);
            //тоже не получилось. Получили стрим стримов
            System.out.println("----------------------");
            System.out.println(Files.lines(Paths.get("text.txt")) //получаем стрим строк из файла
                    .map(line -> line.split("\\s")) // arr[0] arr[1] arr[2] arr[3] //каждую строку разбиваем по проьелу и получаем стрим массивов
                    .flatMap(Arrays::stream) //каждый массив преобразуем к потоку и получаем поток потоков и делаеи ФлатМап - объединение потока потоков в один длинный поток
                    .distinct() //находим уникальные слова внутри этого длинного потока
                    .collect(Collectors.joining(", ", "Уникальные слова: ", "."))); //склеиваем по правилу, в качестве разделителя добавляем запятую в качестве префикса напишем уникальные слова а в кчестве суффикса точку и выведем в консоль
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFileToString() throws IOException {
        return Files.lines(Paths.get("text.txt")).collect(Collectors.joining("\n")); //сборка всех строк в одну длинную с указанием разделителя
    }

    private static void parallelStreamEx() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        list.parallelStream().filter(i -> {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            return true;
        }).collect(Collectors.toSet());
    }

    private static void simpleStringEx() {
        //посчитать список уникальных элементов
        //есть одна длинная строка, ее разбиваем по пробелам, полученный массив строк завернуть в поток и у этого потока ищем только уникальные слова и посчитать сколько элементов в этом потоке
        System.out.println(Arrays.stream("A B CC B C AA A A B CC C".split("\\s")).distinct().count());
    }

    private static void streamFromFilesEx() {
        try {
            //Files.lines - возвращает поток строк из файла
            //Берем файл из него получаем стрим строк, каждую строку преобразуем к длинне и выводим в консоль длины каждой из строк данного файла
            Files.lines(Paths.get("123.txt")).map(String::length).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void streamCreationEx() {
        Arrays.asList("A", "B", "C").stream().forEach(System.out::println); //создание стрима из коллекции
        Stream.of(1, 2, 3, 4).forEach(System.out::println); //закинуть даннные в стрим
        Arrays.stream(new int[]{4, 3, 2, 1}).forEach(System.out::println); //закинуть массив в стрим
    }

    private static void intStreamsEx() {
        IntStream myIntStream = IntStream.of(10, 20, 30, 40, 50); //стрим целых чисел

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().mapToInt(v -> v).sum(); //преобразуем данные к инту по определенному правилу

        //получить все числа от 2 до 10 включительно и потом из них оставить только четные
        IntStream.rangeClosed(2, 10).filter(n -> n % 2 == 0).forEach(System.out::println);
    }

    private static void reduceEx() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int sum = 0;
        for (Integer o : list) {
            sum += o;
        }

        int streamSum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum + " " + streamSum);
    }

    private static void mappingEx() {
        Function<String, Integer> _strToLen = String::length;
        Function<String, Integer> strToLen = s -> s.length();
        Predicate<Integer> evenNumberFilter = n -> n % 2 == 0;
        Function<Integer, Integer> cube = n -> n * n * n;

        Stream.of(1, 2, 3).map(n -> Math.pow(n, 3));
        Stream.of(1, 2, 3).map(cube);

        List<String> list = Arrays.asList("A", "BB", "C", "DDD", "EE", "FFFF");
//        List<Integer> wordsLength = list.stream().map(str -> str.length()).collect(Collectors.toList());
        List<Integer> wordsLength = list.stream().map(String::length).collect(Collectors.toList());
//        List<Integer> wordsLength = list.stream().map(strToLen).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(wordsLength);

        list.stream().map(strToLen).forEach(n -> System.out.println(n));
        list.stream().map(strToLen).forEach(System.out::println);
    }

    private static void findAnyEx() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list.stream().filter(n -> n > 10).findAny().ifPresent(System.out::println);
        Optional<Integer> opt = list.stream().filter(n -> n > 10).findAny();
        if (opt.isPresent()) {
            System.out.println(opt.get());
        }
    }

    public static String returnOrThrow() {
        Optional<String> opt = Optional.of("Java");
        return opt.orElseThrow(() -> new RuntimeException());
    }

    public static void countExample() {
        Map<Integer, Long> map = Stream.of("A", "BB", "AA", "B", "C", "EE", "NNN", "X", "QQ").
                collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(map);
    }

    private static void matchEx() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(list.stream().allMatch(n -> n < 10)); //проверка всех чисел на то, что они меньше 10
        System.out.println(list.stream().anyMatch(n -> n == 4)); //проврка на вхождение хотябы одного элемента
        System.out.println(list.stream().noneMatch(n -> n == 2)); //ни одного элемента не должно быть
    }

    private static void thirdEx() {
        // получаем поток данных из набора целых чисел, находим среди них только уникальные, и каждое
        // найденное значение выводим в консоль
        System.out.println("Первый вариант: ");
        Arrays.asList(1, 2, 3, 4, 4, 3, 2, 3, 2, 1).stream().distinct().forEach(n -> System.out.println(n));
        // делаем то же самое, что и в первом случае, только используем более короткую запись System.out::println
        System.out.println("Второй вариант: ");
        Arrays.asList(1, 2, 3, 4, 4, 3, 2, 3, 2, 1).stream().distinct().forEach(System.out::println);
    }

    private static void secondEx() {
        // Создаем список целых чисел
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> out = numbers.stream()                        // преобразуем список целых чисел в поток данных и начинаем обработку
                .filter(n -> n % 2 == 0)                            // фильтруем поток, оставляем в нем только четные числа
                .map(n -> n * n)                                    // преобразуем каждый элемент потока int -> int, умножая на 2
                .limit(2)                                           // оставляем в потоке только 2 первых элемента
                .collect(Collectors.toList());                      // собираем элементы потока в лист

        System.out.println(numbers);
        System.out.println(out);
    }

    private static void filterEx() {
        //альтернативный способ создания стрима
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8).filter(new Predicate<Integer>() {  //фильтер ожидает от нас предикат(функциональный интерфейс) его задача вернуть либо да либо нет(подходит не подходит)
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        }).forEach(new Consumer<Integer>() { //в форыч отдается консьюмер, который принимает на вход объект но ничего не возвращает. Просто печатает , удаляет и т.д.
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        //лямбдой
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8) //поток из 8 чисел
                .filter(n -> n % 2 == 0) //фильтруем поткок
                .forEach(n -> System.out.println(n)); //выводим в консоль
    }

    //создаем сотрудников
    private static void firstEx() {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Bob1", 35, Person.Position.MANAGER),
                new Person("Bob2", 44, Person.Position.DIRECTOR),
                new Person("Bob3", 25, Person.Position.ENGINEER),
                new Person("Bob4", 42, Person.Position.ENGINEER),
                new Person("Bob5", 55, Person.Position.MANAGER),
                new Person("Bob6", 19, Person.Position.MANAGER),
                new Person("Bob7", 33, Person.Position.ENGINEER),
                new Person("Bob8", 37, Person.Position.MANAGER)
        ));

        //хотим достать только инженеров
        List<Person> engineers = new ArrayList<>();
        for (Person o : persons) {
            if (o.position == Person.Position.ENGINEER) {
                engineers.add(o);
            }
        }
        //упорядочиваем этих инженеров по возрасту
        engineers.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });
        //по отсортированным инженерам получаем имена
        List<String> engineersNames = new ArrayList<>();
        for (Person o : engineers) {
            engineersNames.add(o.name);
        }
        System.out.println(engineersNames);

        //лямбдой тоже самое:
        List<String> engineersNamesShortPath = persons.stream()      //берем исходный список сотрудников и преобразуем его к потоку
                .filter(p -> p.position == Person.Position.ENGINEER) //на пути ставим фильт и пропускаем дальше только инженеров
                .sorted((o1, o2) -> o1.age - o2.age)                 //потм сортируем поток указав правила сортировки
                .map(person -> person.name)                          //затем преобразуем инженеров к их именам(из сотрудников достаем имена)
                .collect(Collectors.toList());                       //имена собираем в лист
        System.out.println(engineersNamesShortPath);
    }

    public static void myOwnFilterEx() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(myOwnFilter(ints, i -> i % 2 == 0));
        System.out.println(myOwnFilter(ints, i -> i % 2 != 0));
    }

    public static <T> List<T> myOwnFilter(List<T> list, Predicate<T> predicate) {
        List<T> copy = new ArrayList<>(list);
        Iterator<T> iter = copy.iterator();
        while (iter.hasNext()) {
            T o = iter.next();
            if (!predicate.test(o)) {
                iter.remove();
            }
        }
        return copy;
    }
}
