import java.util.Objects;

public class Actor extends Person {
    private final int height;

    public Actor(Person person, int height) {
        super(person.name, person.surname, person.gender);
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(this.name, actor.name) && Objects.equals(this.surname, actor.surname) && Objects.equals(this.height, actor.height);
    }

    @Override
    public String toString() {
        return name + " " + surname + "(" + height + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, height);
    }
}
