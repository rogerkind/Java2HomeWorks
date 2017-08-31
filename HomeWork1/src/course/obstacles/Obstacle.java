package course.obstacles;
import team.members.*;

public class Obstacle{

    private Obstacles obstacle;

    Obstacle(Obstacles obstacle){
        this.obstacle =obstacle;
    }

    public boolean pass(Animal animal){
        boolean isPassed = false;
        switch(obstacle){
            case CROSS:
                isPassed = animal.run(obstacle.getSize());
                break;
            case WALL:
                if (animal instanceof Jumpable)
                    isPassed = ((Jumpable) animal).jump((float)obstacle.getSize());
                else isPassed = false;
                break;
            case SWIM:
                if (animal instanceof  Swimable)
                    isPassed = ((Swimable) animal).swim(obstacle.getSize());
                else isPassed = false;
                break;
        }
        return isPassed;
     }
}
