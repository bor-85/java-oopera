public class PerishableParcel extends Parcel {
    private static final int DEFAULT_BASIC_COST = 3;
    int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay, DEFAULT_BASIC_COST);
        this.timeToLive = timeToLive;
    }


    public boolean isExpired(int currentDay) {
        if ((sendDay + timeToLive) >= currentDay) return true;
        return false;
    }
}
