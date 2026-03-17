import java.util.ArrayList;

public class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected ArrayList<Actor> listOfActors;

    public void printDirector() {
        System.out.println("Режиссер спектакля " + title + ": " + director.toString());
    }

    public void printListOfActors() {
        System.out.println("Список актеров спектакля " + title + ":");
        for (Actor actor: listOfActors) {
            System.out.println(actor.toString());
        }
        System.out.println();
    }

    public void addActor(Actor actor) {
        for (Actor actors: listOfActors) {
            if (actors.equals(actor)){
                System.out.println("Такой актер уже есть в списке");
                return;
            }
        }
        listOfActors.add(actor);
    }

    public void swapActor(Actor actorOld, Actor actorNew) {
        for (int i = 0; i < listOfActors.size(); i++) {
            if (listOfActors.get(i).equals(actorOld)) {
                listOfActors.set(i, actorNew);
                System.out.println(title + " - " + actorOld.toString() + " заменен на " + actorNew.toString());
                return;
            }
        }
        System.out.println("Попытка замены актера в спектакле : " + title + ". Но актер " + actorOld + " не участвует в спектакле " + title + "\n");

    }

    public Show(String title, int duration, Director director, ArrayList<Actor> listOfActors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = listOfActors;
    }
}
