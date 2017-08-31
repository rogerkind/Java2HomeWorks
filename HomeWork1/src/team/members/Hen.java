package team.members;

public class Hen extends Animal implements Jumpable{
    private float jumpdist;

    public Hen(String name) {
        this.name = name;
        this.rundist = TeamMembers.HEN.getRunlim();
        jumpdist = TeamMembers.HEN.getJumplim();
    }

    @Override
    public String voice() {
        return TeamMembers.HEN.getVoice();
    }

    @Override
    public boolean jump(float height) {
        return jumpdist >= height;
    }
}
