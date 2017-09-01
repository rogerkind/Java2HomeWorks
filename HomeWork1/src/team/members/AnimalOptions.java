package team.members;

/**
 * Enumerator AnimalOption:
 * Contains types and limits
 *
 * @author Slava Bugakov
 * @version 0.0.1 dated 31 Aug 2017
 */

public enum AnimalOptions{
    CAT("meow", 100, 100, 3.8f), HIPPO("uf-uf-uf", 50, 200, 0f), HEN("ko-ko-ko", 100, 0, 10f);
    private String voice;
    private int runlim;
    private int swimlim;
    private float jumplim;

    AnimalOptions(String voice, int runlim, int swimlim, float jumplim){
        this.voice = voice;
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
