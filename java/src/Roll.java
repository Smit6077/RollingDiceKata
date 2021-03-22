package src;


public class Roll {

    public enum RollType {
        NORMAL,
        ADVANTAGE,
        DISADVANTAGE
    }

    // Attributes
    private int diceValue;
    private int nbRoll;
    private int modifier;
    private boolean isPositive;
    private boolean wrongMod = false;
    private Dice dice;
    

    public Roll(String formula) {

        

        if (Integer.valueOf(formula.charAt(0)) >= 97) {
            this.nbRoll = 1;
            this.diceValue = Integer.valueOf(formula.charAt(1)) - 48;
            this.modifier = Integer.valueOf(formula.charAt(3)) - 48;

            if(Integer.valueOf(formula.charAt(2)) == 43) {
                isPositive = true;
            }else if(Integer.valueOf(formula.charAt(3)) == 45){
                isPositive = false;
            }else{
                wrongMod = true;
            }


        }else {


            this.nbRoll = Integer.valueOf(formula.charAt(0)) - 48;
            this.diceValue = Integer.valueOf(formula.charAt(2)) - 48;
            this.modifier = Integer.valueOf(formula.charAt(4)) - 48;

            if(Integer.valueOf(formula.charAt(3)) == 43){
                isPositive = true;
                System.out.println("Bonjour");

            }else if(Integer.valueOf(formula.charAt(3)) == 45){
                isPositive = false;
                System.out.println("Non");

            }else{
                wrongMod = true;
            }

        }


    }


    public Roll(int diceValue, int nbRoll, int modifier) {

        this.diceValue = diceValue;
        this.nbRoll = nbRoll;
        this.modifier = modifier;



    }

    public int makeRoll(RollType rollType) {

        this.dice = new Dice(diceValue);
        int result;

        if(wrongMod== true){
            return result = -1;

        } else {

            if (isPositive == true) {
                result = nbRoll * this.dice.rollDice() + modifier;
            } else {
                result = nbRoll * this.dice.rollDice() - modifier;
            }
        }
        

        if (result <0){
            result = 0;
        }

        if (nbRoll <=0 || diceValue <= 0 ){
            result = -1;
        }

        return result;
        

    }

}
