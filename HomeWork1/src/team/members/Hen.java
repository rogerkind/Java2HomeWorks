package team.members;

/**
 * class Hen:
 * Extends Animal implements Jumbable
 * Uses AnimalOptions for getting constants
 *
 * @author Slava Bugakov
 * @version 0.0.1 dated 31 Aug 2017
 */
public class Hen extends Animal implements Jumpable{
    private float jumpdist;

    public Hen(String name){
        this.name = name;
        this.rundist = AnimalOptions.HEN.getRunlim();
        jumpdist = AnimalOptions.HEN.getJumplim();
    }

    @Override
    public String voice(){
        return AnimalOptions.HEN.getVoice();
    }

    @Override
    public boolean jump(float height){
        return jumpdist >= height;
    }
}
