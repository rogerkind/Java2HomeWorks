package team.members;

/**
 * Abstract class Animal:
 * Contains abstract method voice()
 * realize method run
 *
 * @author Slava Bugakov
 * @version 0.0.1 dated 31 Aug 2017
 */

public abstract class Animal{
    protected String name;
    protected int rundist;

    public abstract String voice();

    public boolean run(int distance){
        return rundist >= distance;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " " + name;
    }
}
