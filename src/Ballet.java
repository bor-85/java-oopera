

public class Ballet extends MusicalShow{
    private final Choreographer choreographer;

    public Ballet(Show show, MusicAuthor musicAuthor, String librettoText, Choreographer choreographer) {
        super(show, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }

    public Choreographer getChoreographer() {
        return choreographer;
    }
}
