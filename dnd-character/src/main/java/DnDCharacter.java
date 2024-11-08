import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;


class DnDCharacter {
    private final int strenght;
    private final int dexterity;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;
    private final int constitution;

    public DnDCharacter (){
        this.strenght = diceMethod();
        this.dexterity = diceMethod();
        this.intelligence = diceMethod();
        this.wisdom = diceMethod();
        this.charisma = diceMethod();
        this.constitution = diceMethod();
    }

    int ability(List<Integer> scores) {
        List<Integer> copy = new ArrayList<>(scores);

        int sum = 0;
        int lowest = 7;
        int index = -1;
        for(int i = 0; i < copy.size(); i++){
            if(copy.get(i) < lowest){
                lowest = copy.get(i);
                index = i;
            }
        }
        copy.remove(index);
        for (Integer integer : copy) {
            sum += integer;
        }
        return sum;
    }
    public int diceMethod(){
        return ability(rollDice());
    }
    List<Integer> rollDice() {
        List<Integer> diceThrows = new ArrayList<>();
        Random randomGenerator=new Random();
        for (int i = 0; i < 4; i++) {
            diceThrows.add(randomGenerator.nextInt(6) + 1);
        }
        return diceThrows;
    }

    int modifier(int input) {
        double num =  ((input - 10) /2.0);
        if(num < 0){
            num = -1 * num;
            return  - 1 * (int)Math.ceil(num);
        }else{
            return (int)num;
        }
    }

    int getStrength() {
        return strenght;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution ;
    }

    int getIntelligence() {
        return intelligence ;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {

        return 10 + modifier(constitution);
    }
}
