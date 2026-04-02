import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeliveryAppTest {

    String description = "Test Parcel";
    int weight = 5;
    String deliveryAddress = "Street";
    int sendDay = 1;
    int timeToLive = 1;

    StandardParcel newStandartParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
    FragileParcel newFragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
    PerishableParcel newPerishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);


    //Проверка расчета стоимости доставки для Стандартной посылки
    @Test
    public void should_Calculate_Cost_For_Standart() {

        int expectedCost = 10;

        int resultCost = newStandartParcel.calculateDeliveryCost();

        Assertions.assertEquals(expectedCost, resultCost);
    }

    //Проверка расчета стоимости доставки для Хрупкой посылки
    @Test
    public void should_Calculate_Cost_For_Fragile() {

        int expectedCost = 20;

        int resultCost = newFragileParcel.calculateDeliveryCost();

        Assertions.assertEquals(expectedCost, resultCost);
    }

    //Проверка расчета стоимости доставки для Скоропортящейся посылки
    @Test
    public void should_Calculate_Cost_For_Perishable() {
        // Подготовка
        int expectedCost = 15;

        // Исполнение
        int resultCost = newPerishableParcel.calculateDeliveryCost();

        // Проверка
        Assertions.assertEquals(expectedCost, resultCost);
    }

    //Проверка возврата true для скоропортящейся посылки
    @Test
    public void should_Perishable_Parcel_IsExpired_Be_True() {
        int trueCurrentDay = 1;

        boolean value = newPerishableParcel.isExpired(trueCurrentDay);

        Assertions.assertTrue(value);
    }

    //Проверка возврата false для скоропортящейся посылки
    @Test
    public void should_Perishable_Parcel_IsExpired_Be_False() {
        int trueCurrentDay = 3;

        boolean value = newPerishableParcel.isExpired(trueCurrentDay);

        Assertions.assertFalse(value);
    }

    //Проверка добавления посылки в коробку на примере стандартной когда вес посылки в пределах веса коробки
    @Test
    public void should_Add_Standart_Parcel_To_Box() {

        ParcelBox<StandardParcel> standartBox = new ParcelBox<>(10);
        int expectedSize = 1;

        standartBox.addParcel(newStandartParcel);
        int resultSize = standartBox.getParcels().size();

        Assertions.assertEquals(expectedSize, resultSize);
    }

    //Проверка добавления посылки в коробку на примере стандартной, когда вес посылки больше допустимого веса коробки
    @Test
    public void should_Not_Add_Standart_Parcel_To_Box() {

        ParcelBox<StandardParcel> standartBox = new ParcelBox<>(4);
        int expectedSize = 0;

        standartBox.addParcel(newStandartParcel);
        int resultSize = standartBox.getParcels().size();

        Assertions.assertEquals(expectedSize, resultSize);
    }

    //Проверка добавления посылки в коробку на примере стандартной, когда вес посылки равен допустимому весу коробки
    @Test
    public void should_Add_Standart_Parcel_To_Box_Border() {

        ParcelBox<StandardParcel> standartBox = new ParcelBox<>(5);
        int expectedSize = 1;

        standartBox.addParcel(newStandartParcel);
        int resultSize = standartBox.getParcels().size();

        Assertions.assertEquals(expectedSize, resultSize);
    }

    //Проверка добавления 2 посылок в коробку на примере стандартной, когда вес 2 посылок равен допустимому весу коробки
    @Test
    public void should_Add_Standart_Parcel_To_Box_For_2Parcels() {

        ParcelBox<StandardParcel> standartBox = new ParcelBox<>(10);
        int expectedSize = 2;

        standartBox.addParcel(newStandartParcel);
        standartBox.addParcel(newStandartParcel);
        int resultSize = standartBox.getParcels().size();

        Assertions.assertEquals(expectedSize, resultSize);
    }

    //Проверка добавления 2 посылок в коробку на примере стандартной, когда вес 2 посылок превышает допустимый вес коробки
    @Test
    public void should_Not_Add_Standart_Parcel_To_Box_For_2Parcels() {

        ParcelBox<StandardParcel> standartBox = new ParcelBox<>(9);
        int expectedSize = 1;

        standartBox.addParcel(newStandartParcel);
        standartBox.addParcel(newStandartParcel);
        int resultSize = standartBox.getParcels().size();

        Assertions.assertEquals(expectedSize, resultSize);
    }

}