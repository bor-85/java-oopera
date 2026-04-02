import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<FragileParcel> fragileParcels = new ArrayList<>();

    //инициализация коробок
    private static final ParcelBox<StandardParcel> standartBox = new ParcelBox<>(10);
    private static final ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(15);
    private static final ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(20);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportFragileParcelsStatus();
                    break;
                case 5:
                    showBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Трекинг хрупких отправлений");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        String description;
        int weight;
        String deliveryAddress;
        int sendDay;

        // указываем тип посылки
        int typeParcel = getTypeParcel();
        if (typeParcel == 0) {
            System.out.println("Введенного типа посылки не существует");
            return;
        }

        //параметры посылки
        System.out.println("Укажите вес:");
        weight = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Укажите описание:");
        description = scanner.nextLine();

        System.out.println("Укажите адрес доставки:");
        deliveryAddress = scanner.nextLine();

        System.out.println("Укажите день отправления:");
        sendDay = scanner.nextInt();
        scanner.nextLine();

        if (typeParcel == 1 && !standartBox.isOverflowBox(weight)) {
            StandardParcel newStandartParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
            standartBox.addParcel(newStandartParcel);
            allParcels.add(newStandartParcel);
        }
        else if (typeParcel == 2  && !fragileBox.isOverflowBox(weight)) {
            FragileParcel newFragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
            allParcels.add(newFragileParcel);
            fragileParcels.add(newFragileParcel);
            fragileBox.addParcel(newFragileParcel);
        }
        else if (typeParcel == 3  && !perishableBox.isOverflowBox(weight)) {
            System.out.println("Укажите сколько хранится посылка:");
            int timeToLive = scanner.nextInt();
            scanner.nextLine();
            PerishableParcel newPerishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
            allParcels.add(newPerishableParcel);
            perishableBox.addParcel(newPerishableParcel);
        }
        else if ((typeParcel == 1  && standartBox.isOverflowBox(weight)) ||
                 (typeParcel == 2  && fragileBox.isOverflowBox(weight)) ||
                 (typeParcel == 3  && perishableBox.isOverflowBox(weight))) {
            System.out.println("Превышен максимальный вес коробки! Невозможно добавить посылку!");
        }
        else {
            System.out.println("Посылки с типом " + typeParcel + " не предусмотрено");
        }
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
        // Пройти по allParcels, вызвать packageItem() и deliver()
    }

    private static void calculateCosts() {
        int sumDeliver = 0;
        for (Parcel parcel : allParcels) {
            sumDeliver += parcel.calculateDeliveryCost();
        }
        System.out.println("Сумма доставки всех посылок: " + sumDeliver);
        // Посчитать общую стоимость всех доставок и вывести на экран
    }
    private static void reportFragileParcelsStatus() {
        System.out.println("Введите новое местоположение:");
        String newLocation = scanner.nextLine();
        for (FragileParcel fragile : fragileParcels) {
            fragile.reportStatus(newLocation);
        }
        // Пройти по allParcels, вызвать packageItem() и deliver()
    }

    //метод выводит на экран содержимое коробок в зависимости от типа коробки
    private static void showBox() {
        int typeParcel = getTypeParcel();
        if (typeParcel == 1) standartBox.getAllParcels();
        else if (typeParcel == 2) fragileBox.getAllParcels();
        else if (typeParcel == 3) perishableBox.getAllParcels();
        else System.out.println("Введенного типа посылки не существует");
    }

    private static int getTypeParcel() {
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Обычная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");
        String typeParcel = scanner.nextLine();

        if (typeParcel.equals("1") || typeParcel.equals("2") || typeParcel.equals("3")) return Integer.parseInt(typeParcel);
        return 0;
    }

}
