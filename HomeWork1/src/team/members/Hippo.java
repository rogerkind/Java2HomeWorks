package team.members;

/**
 * class Hippo:
 * Extends Animal implements Swimable
 * Uses AnimalOptions for getting constants
 *
 * @author Slava Bugakov
 * @version 0.0.1 dated 31 Aug 2017
 */
public class Hippo extends Animal implements Swimable{
    private int swimdist;

    public Hippo(String name){
        this.name = name;
        this.rundist = AnimalOptions.HIPPO.getRunlim();
        swimdist = AnimalOptions.HIPPO.getSwimlim();
    }

    @Override
    public String voice(){
        return AnimalOptions.HIPPO.getVoice();
    }

    @Override
    public boolean swim(int length){
        return swimdist >= length;
    }
}
