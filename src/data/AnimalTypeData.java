package data;

public enum AnimalTypeData {
    CAT("кот"),
    DOG("собака"),
    DUCK("утка");

    private String name;
    AnimalTypeData(String name){
        this.name = name;
    }
    private String getName(){
        return name;
    }
}
