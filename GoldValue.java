import java.util.Scanner;

class Gold{
    Scanner sc;
    private final int metalValuePerGram;
    private final int mcPerGram;
    private final double newWeight;
    private final double oldWeight;
    private final int hallCharge;
    private double actualOldWeight;

    Gold(int metalValuePerGram, int mcPerGram, double newWeight, double oldWeight,int hallCharge){
        this.metalValuePerGram = metalValuePerGram;
        this.mcPerGram = mcPerGram;
        this.newWeight = newWeight;
        this.oldWeight = oldWeight;
        this.hallCharge = hallCharge;
        sc = new Scanner(System.in);
    }

    private double getPriceWithoutold(){
        return (newWeight * (metalValuePerGram + mcPerGram)) + hallCharge;
    }
    private double getPriceWithOld(){
        System.out.println("what will be redundant percentage? ");
        int extractPercent = sc.nextInt();
        this.actualOldWeight = (oldWeight * extractPercent)/100;
        System.out.println("what will be purchase value of gold? ");
        int purchaseValue = sc.nextInt();

        double newPrice = (newWeight*(metalValuePerGram + mcPerGram)) + hallCharge;
        double oldPrice = actualOldWeight*(purchaseValue);

        System.out.println("the new ones price: " + newPrice);
        System.out.println("the old ones Price: " + oldPrice);
        return newPrice - oldPrice;
    }

    void getPrice(){
        if (oldWeight == 0){
            System.out.println("so the price will: " + getPriceWithoutold());
        }
        else{
            System.out.println("so the price will: "+getPriceWithOld());
        }
    }
    void oldValue(){
        System.out.println("the old value customer gets: " + actualOldWeight);
    }
}


class GoldValue{
    public static void main(String[] args) {
        Gold g = new Gold(8100,1000,12.25,5.12,200);
        g.getPrice();
    }
}