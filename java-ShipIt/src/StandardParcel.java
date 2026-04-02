public class StandardParcel extends Parcel {
    private static final int DEFAULT_BASIC_COST = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay, DEFAULT_BASIC_COST);
    }
}
