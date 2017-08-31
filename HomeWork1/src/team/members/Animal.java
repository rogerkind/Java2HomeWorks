package team.members;
/**
 * Abstract class Animal - write a description of the class here
 *
 * @author Slava Bugakov
 * @version 0.0.1 dated 31 Aug 2017
 */
public abstract class Animal{
    protected String name;
    protected int rundist;

    abstract String voice();

    public boolean run(int distance){
        return rundist>=distance;
    }

    @Override
    public String toString(){
        return this.getClass().getName() + " " + name;
    }
}
