public class FragileParcel extends Parcel implements Trackable{
    private static final int DEFAULT_BASIC_COST = 4;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay, DEFAULT_BASIC_COST);
    }


    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + deliveryAddress + ">> изменила местоположение на " + newLocation);
    }
}
