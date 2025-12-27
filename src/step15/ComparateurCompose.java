package step15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Personne {
    private String nom;
    private String prenom;
    private int age;
    
    public Personne(String prenom, String nom, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }
    
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public int getAge() { return age; }
    
    @Override
    public String toString() {
        return prenom + " " + nom + " (" + age + ")";
    }
}

public class ComparateurCompose {
    public static void main(String[] args) {
        List<Personne> personnes = Arrays.asList(
            new Personne("Jean", "Dupont", 30),
            new Personne("Marie", "Martin", 25),
            new Personne("Pierre", "Dupont", 40),
            new Personne("Sophie", "Martin", 35),
            new Personne("Paul", "Dupont", 20)
        );
        
        Comparator<Personne> comparateur = Comparator
            .comparing(Personne::getNom)
            .thenComparing(Personne::getPrenom)
            .thenComparingInt(Personne::getAge);
        
        System.out.println("Liste triée:");
        personnes.stream()
            .sorted(comparateur)
            .forEach(System.out::println);
        
        Comparator<Personne> comparateurVariante = Comparator
            .comparing(Personne::getNom)
            .thenComparing(Personne::getAge, Comparator.reverseOrder());
        
        System.out.println("\nListe triée (variante):");
        personnes.stream()
            .sorted(comparateurVariante)
            .forEach(System.out::println);
    }
}