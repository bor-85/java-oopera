import java.util.ArrayList;

public class Theatre {

    public static void main(String[] args) {

        System.out.println("Поехали!");

        //создаем работников театра
        Actor actor1 = new Actor(new Person("Ромео", "Петров", Person.Gender.MALE), 175);
        Actor actor2 = new Actor(new Person("Джульетта", "Иванова", Person.Gender.FEMALE), 170);
        Actor actor3 = new Actor(new Person("Олег", "Жданов", Person.Gender.MALE), 185);

        Director director1 = new Director(new Person("Федор", "Сумкин", Person.Gender.MALE), 99);
        Director director2 = new Director(new Person("Александр", "Македонов", Person.Gender.MALE), 1);

        Choreographer choreographer = new Choreographer("Олеся", "Потапова", Person.Gender.FEMALE);
        MusicAuthor musicAuthor = new MusicAuthor("Георгий", "Прохоров", Person.Gender.MALE);

        //создаем спектакли:
        //обычный
        Show typicalShow = new Show("Обычный театр",90, director1, new ArrayList<Actor>());
        typicalShow.addActor(actor1);
        typicalShow.addActor(actor2);
        typicalShow.printDirector();
        typicalShow.printListOfActors();

        //балет
        Ballet ballet = new Ballet(new Show("Балет в Иваново",120, director2, new ArrayList<Actor>()), musicAuthor,"Сальце трясется)", choreographer);
        ballet.addActor(actor3);
        //добавил еще вывод директора и хореографа раз уж метод реализован по ТЗ, если лишнее, то уберу
        ballet.printDirector();
        System.out.println(ballet.getChoreographer().toString());
        ballet.printListOfActors();

        //опера
        Opera opera = new Opera(new Show("Мартовские коты",60, director1, new ArrayList<Actor>()), musicAuthor,"Громко и точка!", 100);
        opera.addActor(actor1);
        opera.addActor(actor3);
        //добавил еще вывод директора и автора музыки раз уж метод реализован по ТЗ, если лишнее, то уберу
        opera.printDirector();
        System.out.println(opera.getMusicAuthor().toString());
        opera.printListOfActors();

        //замена актера, который есть в списке
        ballet.swapActor(actor3, actor1);
        ballet.printListOfActors();

        //замена актера, которого нет в списке
        opera.swapActor(actor2, actor1);
        opera.printListOfActors();

        //Текст либретто
        ballet.printLibrettoText();
        opera.printLibrettoText();
    }
}