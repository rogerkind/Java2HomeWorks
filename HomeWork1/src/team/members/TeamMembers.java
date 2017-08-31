package team.members;

public enum TeamMembers {
    CAT("meow",100,100,3.8f),
    HIPPO("uf-uf-uf",50,200,0f),
    HEN("ko-ko-ko",100,0,10f);
    private String voice;
    private int runlim;
    private int swimlim;
    private float jumplim;

    TeamMembers(String voice,int runlim,int swimlim,float jumplim){
        this.voice=voice;
        this.runlim = runlim;
        this.swimlim = swimlim;
        this.jumplim = jumplim;
    }
    public int getRunlim(){
        return runlim;
    }

    public int getSwimlim(){
        return swimlim;
    }

    public float getJumplim(){
        return this.jumplim;
    }

    public String getVoice(){
        return this.voice;
    }
}
