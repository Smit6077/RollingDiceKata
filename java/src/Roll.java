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
    private boolean isPositive = true ;
    private Dice dice;
    public int result;
    public int x =0;

    public Roll(String formula) {

        if (Integer.valueOf(formula.charAt(0)) >= 97) {
            // 1 seul dé à lancer

            this.nbRoll = 1;
            this.diceValue = Integer.valueOf(formula.charAt(1)) - 48;
            this.modifier = 0;

            if(formula.length() >2) {

                if (Integer.valueOf(formula.charAt(2)) == 43) {
                    isPositive = true;
                    this.modifier = Integer.valueOf(formula.charAt(3)) - 48;
                } else if (Integer.valueOf(formula.charAt(2)) == 45) {
                    isPositive = false;
                    this.modifier = Integer.valueOf(formula.charAt(3)) - 48;
                }
            }

        } else {
            // 2 dés à lancer

            this.nbRoll = Integer.valueOf(formula.charAt(0)) - 48;
            this.diceValue = Integer.valueOf(formula.charAt(2)) - 48;
            this.modifier = 0;

            if(formula.length() >3) {

                if (Integer.valueOf(formula.charAt(3)) == 43) {
                    isPositive = true;
                    this.modifier = Integer.valueOf(formula.charAt(4)) - 48;
                } else if (Integer.valueOf(formula.charAt(3)) == 45) {
                    isPositive = false;
                    this.modifier = Integer.valueOf(formula.charAt(4)) - 48;
                }
            }

        }

    }


    public Roll(int diceValue, int nbRoll, int modifier) {

        this.diceValue = diceValue;
        this.nbRoll = nbRoll;
        this.modifier = modifier;
        x = 1;

    }

    public int makeRoll(RollType rollType) {

        this.dice = new Dice(diceValue);

        if(x!=1) {

            if (isPositive == true) {
                result = nbRoll * this.dice.rollDice() + modifier;
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA");

            } else {
                result = nbRoll * this.dice.rollDice() - modifier;
                System.out.println(result);

            }


        }else {

            result = nbRoll * this.dice.rollDice() + modifier;

        }


        System.out.println(nbRoll);
        System.out.println(modifier);
        System.out.println(this.dice.rollDice());

        System.out.println(result);

        if (result < 0) {
            result = 0;
        }

        if (nbRoll <= 0 || diceValue <= 0) {
            result = -1;
        }

        return result;


    }

}



