package team.members;

public class Hippo extends Animal implements Swimable {
    private int swimdist;

    public Hippo(String name) {
        this.name = name;
        this.rundist = TeamMembers.HIPPO.getRunlim();
        swimdist = TeamMembers.HIPPO.getSwimlim();
    }

    @Override
    public String voice() {
        return TeamMembers.HIPPO.getVoice();
    }

    @Override
    public boolean swim(int length) {
        return swimdist >= length;
    }
}
