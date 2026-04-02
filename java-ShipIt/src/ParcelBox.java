import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private final int maxWeght;
    private final List<T> parcels = new ArrayList<>();
    public ParcelBox(int maxWeght) {
        this.maxWeght = maxWeght;
    }

    //метод показывает, будет переполнена коробка или нет при добавлении новой посылки
    public boolean isOverflowBox(int weight) {
        if((getParcelsWeight() + weight) > maxWeght) return true;
        return false;
    }
    public void addParcel(T parcel) {
        if (isOverflowBox(parcel.weight)) {
            return;
        }
        else {
            parcels.add(parcel);
        }
    }
    public void getAllParcels() {
        for (T parcel : parcels) {
            System.out.println("Посылка: " + parcel.description);
        }
    }
    public int getParcelsWeight() {
        int sum = 0;
        for (T parcel : parcels) {
           sum += parcel.weight;
        }
        return sum;
    }

    public List<T> getParcels() {
        return parcels;
    }
}
