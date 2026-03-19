public class Choreographer extends Person {
    public Choreographer(String name, String surname, Gender gender) {
        super(name, surname, gender);
    }

    @Override
    public String toString() {
        return "Хореограф - " + super.toString();
    }
}
