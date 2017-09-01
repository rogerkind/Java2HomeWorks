package course;

import course.obstacles.Obstacle;
import course.obstacles.Obstacles;
import team.Team;
import team.members.Animal;

import java.util.Arrays;

/**
 * Class - represents of track(Obstacles[])
 * contains method doIt(Team team) according task requirements
 * experiment: use "universal" class Obstacle an Enumerator Obstacles
 *
 * @author Slava Bugakov
 * @version 0.0.1 dated 01 Sept 2017
 */

public class Course{
    private Obstacle[] course;
    private String results;

    public Course(){
        course = new Obstacle[Obstacles.values().length];
        int i = 0;
        for(Obstacles o : Obstacles.values()){
            course[i] = new Obstacle(o);
            i++;
        }
    }

    public void doIt(Team team){
        results = "";
        results += team;
        results += this;
        results += "Competition begin:\n";
        for(Animal specie : team.getAnimals()){
            results += "\n" + specie + " Says: " + specie.voice() + " and start\n";
            for(Obstacle o : course)
                results += "try to pass: " + o + ", Result: " + o.pass(specie) + "\n";
        }
        results += "Competition end";
        team.setResult(results);
        results = "";
    }

    @Override
    public String toString(){
        return "Course: " + Arrays.toString(this.course) + "\n";
    }
}


