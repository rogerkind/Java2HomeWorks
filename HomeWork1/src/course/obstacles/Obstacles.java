package course.obstacles;

/**
 * Enumerator - Obstacles
 * contains All presented obstacles on track + names + sizes
 *
 * @author Slava Bugakov
 * @version 0.0.1 dated 31 Aug 2017
 */

public enum Obstacles{
    CROSS("Road", 50), WALL("Wall", 2), SWIM("Lake", 80);
    private String name;
    private int size;

    Obstacles(String name, int size){
        this.name = name;
        this.size = size;
    }

    public int getSize(){
        return this.size;
    }

    @Override
    public String toString(){
        return " " + name + " " + size + " m";
    }
}


