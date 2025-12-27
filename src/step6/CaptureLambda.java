package step6;

import java.util.function.IntUnaryOperator;

public class CaptureLambda {
    public static void main(String[] args) {
        int facteur = 10;
        IntUnaryOperator multiplicateur = n -> n * facteur;
        
        
        System.out.println("5 * " + facteur + " = " + multiplicateur.applyAsInt(5));
        
        new CaptureLambda().demoThis();
    }
    
    private int valeur = 100;
    
    private void demoThis() {
        Runnable r = () -> {
            System.out.println("Valeur capturée: " + this.valeur);
        };
        r.run();
    }
}