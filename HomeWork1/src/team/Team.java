package team;

import team.members.Animal;

import java.util.Arrays;

/**
 * Class - represents of team(Animal[])
 * contains method showResults() according task requirements
 *
 * @author Slava Bugakov
 * @version 0.0.1 dated 01 Sept 2017
 */
public class Team{
    private Animal[] animals;
    private String name;
    private String result;

    public Team(String name, Animal[] animals){
        this.animals = new Animal[animals.length];
        this.animals = animals;
        this.name = name;
    }

    public Animal[] getAnimals(){
        return this.animals;
    }

    public void setResult(String result){
        this.result = result;
    }

    public void showResults(){
        System.out.println(result);
    }

    @Override
    public String toString(){
        return "Team: " + name + "\nMembers: " + Arrays.toString(animals) + "\n";
    }
}
