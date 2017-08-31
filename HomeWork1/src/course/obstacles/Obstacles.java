package course.obstacles;
public enum Obstacles{
    CROSS("Cross",50),
    WALL("Wall",5),
    SWIM("Swim",100);
    private String name;
    private int size;

    Obstacles(String name,int size){
        this.name = name;
        this.size = size;
    }

    public String getName(){
        return this.name;
    }

    public int getSize(){
        return this.size;
    }

    @Override
    public String toString(){
        return this.getClass().getName()+" "+name+" "+size+"m";
    }
}
