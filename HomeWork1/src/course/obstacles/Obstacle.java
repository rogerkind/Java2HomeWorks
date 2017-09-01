package course.obstacles;

import team.members.Animal;
import team.members.Jumpable;
import team.members.Swimable;

/**
 * Class - obstacle "universal" class
 * contains method doIt(Team team) according task requirements
 * experiment: method pass changes behavior according type of obstacle
 * witch received from Enumerator Obstacles
 *
 * @author Slava Bugakov
 * @version 0.0.1 dated 31 Aug 2017
 */

public class Obstacle{

    private final Obstacles obstacle;

    public Obstacle(Obstacles obstacle){
        this.obstacle = obstacle;
    }

    public boolean pass(Animal animal){
        boolean isPassed = false;
        switch(this.obstacle){
            case CROSS:
                isPassed = animal.run(this.obstacle.getSize());
                break;
            case WALL:
                if(animal instanceof Jumpable) isPassed = ((Jumpable) animal).jump((float) this.obstacle.getSize());
                else isPassed = false;
                break;
            case SWIM:
                if(animal instanceof Swimable) isPassed = ((Swimable) animal).swim(this.obstacle.getSize());
                else isPassed = false;
                break;
        }
        return isPassed;
    }

    @Override
    public String toString(){
        return this.obstacle.toString();
    }
}

