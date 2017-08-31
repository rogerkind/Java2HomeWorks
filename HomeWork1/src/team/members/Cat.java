package team.members;

public class Cat extends Animal implements Jumpable,Swimable{
    private int swimdist;
    private float jumpdist;

    public Cat(String name) {
        this.name = name;
        this.rundist = TeamMembers.CAT.getRunlim();
        swimdist = TeamMembers.CAT.getSwimlim();
        jumpdist = TeamMembers.CAT.getJumplim();
    }

    @Override
    public String voice() {
        return TeamMembers.CAT.getVoice();
    }

    @Override
    public boolean swim(int length) {
        return swimdist >= length;
    }

    @Override
    public boolean jump(float height) {
        return jumpdist >= height;
    }
}
