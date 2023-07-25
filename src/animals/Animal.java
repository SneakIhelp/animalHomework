package animals;

public abstract class Animal {
    private String name = "";
    private int age = 0;
    private int weight = 0;
    private String color = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Привет! меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s",
                getName(), getAge(), getYearCase(), getWeight(), getColor());
    }

    private String getYearCase() {
        int lastDigit = getAge() % 10;
        String yearCase = "года";
        
        if (lastDigit == 1) {
            yearCase = "год";
        } else if (lastDigit >= 5) {
            yearCase = "лет";
        }

        if (getAge() % 100 >= 11 && getAge() % 100 <= 14) {
            yearCase = "лет";
        }

        return yearCase;
    }

    public void say(){
        System.out.println("Я говорю");
    }

    public void go(){
        System.out.println("Я иду");
    }

    public void drink(){
        System.out.println("Я пью");
    }

    public void eat(){
        System.out.println("Я ем");
    }
}
