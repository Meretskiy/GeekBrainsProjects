package ru.meretskiy.homework05;

public class WorkerDemo {

    public static void main(String[] args) {

        showWorkersOver40(initWorkerArray());

    }

    public static Worker[] initWorkerArray() {

        Worker[] workArray = new Worker[5];

        workArray[0] = new Worker("Boris Marley", "Sound engineer",
                "Boriska1955@yahoo.com", "+7–905-945-06-02", 1100, 65);
        workArray[1] = new Worker("Quentin Titarenko", "Filmmaker",
                "Quentin1963@gmail.com", "+7-901-963-03-27", 2750, 57);
        workArray[2] = new Worker("Anton Musk", "QA Engineer",
                "A.Musk1981@ya.ru", "+7-915-945-06-02", 1550, 39);
        workArray[3] = new Worker("Eugene Fordov", "Auto Mechanic",
                "Jeka999@mail.ru", "+7-977-911-19-91", 400, 21);
        workArray[4] = new Worker("Sergey Brinov", "Seller",
                "Brinov@gmail.com", "+7-916-973-08-21", 700, 46);

        return workArray;
    }

    public static void showWorkersOver40 (Worker[] arr) {

        for (Worker worker : arr) {

            if (worker.getAge() >= 40) {
                worker.getInfo();
            }
        }
    }
}
