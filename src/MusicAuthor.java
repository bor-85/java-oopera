public class MusicAuthor extends Person {
    public MusicAuthor(String name, String surname, Gender gender) {
        super(name, surname, gender);
    }


    @Override
    public String toString() {
        return "Автор музыки - " + name + " " + surname;
    }
}
