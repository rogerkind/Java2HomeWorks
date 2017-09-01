package team.members;

/**
 * class Cat:
 * Extends Animal implements Jumpable,Swimable
 * Uses AnimalOptions for getting constants
 *
 * @author Slava Bugakov
 * @version 0.0.1 dated 31 Aug 2017
 */

public class Cat extends Animal implements Jumpable, Swimable{
    private int swimdist;
    private float jumpdist;

    public Cat(String name){
        this.name = name;
        this.rundist = AnimalOptions.CAT.getRunlim();
        swimdist = AnimalOptions.CAT.getSwimlim();
        jumpdist = AnimalOptions.CAT.getJumplim();
    }

    @Override
    public String voice(){
        return AnimalOptions.CAT.getVoice();
    }

    @Override
    public boolean swim(int length){
        return swimdist >= length;
    }

    @Override
    public boolean jump(float height){
        return jumpdist >= height;
    }
}
