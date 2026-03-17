public class MusicalShow extends Show{
    private final MusicAuthor musicAuthor;
    private final String librettoText;

    public void printLibrettoText() {
        System.out.println("Текст либретто для спектакля - " + title + ": " + librettoText);
    }

    public MusicalShow(Show show, MusicAuthor musicAuthor, String librettoText) {
        super(show.title, show.duration, show.director, show.listOfActors);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public MusicAuthor getMusicAuthor() {
        return musicAuthor;
    }
}
