import java.util.ArrayList;

public class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected ArrayList<Actor> listOfActors;

    public Show(String title, int duration, Director director, ArrayList<Actor> listOfActors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = listOfActors;
    }
    public void printDirector() {
        System.out.println("Режиссер спектакля " + title + ": " + director);
    }

    public void printListOfActors() {
        System.out.println("Список актеров спектакля " + title + ":");
        if (listOfActors.size() == 0) {
            System.out.println("Список актеров пуст");
        } else {
            for (Actor actor : listOfActors) {
                System.out.println(actor);
            }
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

    public void swapActor(String actorOldSurname, Actor actorNew) {
        int countMatches = 0;//количество сооответствий фамилии актеру
        for (int i = 0; i < listOfActors.size(); i++) {
            if (listOfActors.get(i).getSurname().equals(actorOldSurname)) {
                Actor actorOld = listOfActors.get(i);
                listOfActors.set(i, actorNew);
                System.out.println(title + " - " + actorOld + " заменен на " + actorNew);
                countMatches +=1;
            }
        }
        if (countMatches == 0)
        System.out.println("Попытка замены актера в спектакле : " + title + ". Но актер " + actorOldSurname + " не участвует в спектакле " + title + "\n");

    }
}
