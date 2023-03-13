package dragon;

public class DragonCave implements Check {
    private long numberOfTreasures; //Значение поля должно быть больше 0
    public DragonCave(int number_Of_Treasures){
        this.numberOfTreasures = number_Of_Treasures;
    }
    public boolean check(){
        return this.numberOfTreasures > 0;
    }

    @Override
    public String toString() {
        return String.valueOf(this.numberOfTreasures);
    }
}
