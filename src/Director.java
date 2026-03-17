public class Director extends Person{
    private final int numberOfShows;

    public Director(Person person, int numberOfShows) {
        super(person.name, person.surname, person.gender);
        this.numberOfShows = numberOfShows;
    }

    @Override
    public String toString() {
        return name + " " + surname + "(" + numberOfShows + ")";
    }
}
