import course.Course;
import team.Team;
import team.members.Animal;
import team.members.Cat;
import team.members.Hen;
import team.members.Hippo;

/**
 * Class for running Home Work 1 classes and packages
 *
 * @author Slava Bugakov
 * @version 0.0.1 dated 01 Sept 2017
 */

public class Java2HWLesson1{
    public static void main(String[] args){
        Course c = new Course(); // Создаем полосу препятствий
        Team team = new Team("Zoo", new Animal[]{new Cat("Murzik"), new Hippo("Woofy"), new Hen("Twitty")}); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
    }
}
