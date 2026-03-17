public class Opera extends MusicalShow{
    private final int choirSize;

    public Opera(Show show, MusicAuthor musicAuthor, String librettoText, int choirSize) {
        super(show, musicAuthor, librettoText);
        this.choirSize = choirSize;
    }

    public int getChoirSize() {
        return choirSize;
    }
}
