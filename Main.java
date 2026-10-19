package tp;

public class Main {
    public static void main(String[] args) {

        // Creation des employes
        Ingenieur i1 = new Ingenieur("I01", "Ferdaouss", 500, 4);
        Ingenieur i2 = new Ingenieur("I02", "Yassmin", 350, 2);

        Commercial c1 = new Commercial("C01", "Badr", 300, 0.10);
        Commercial c2 = new Commercial("C02", "Hamza", 400, 0.15);

        // Tableau des employes
        Employe[] employes = {i1, i2, c1, c2};

        // Creation des projets
        Projet p1 = new Projet("P01", "Application Java");
        Projet p2 = new Projet("P02", "Systeme de gestion");

        // Hierarchie des employes il faut creer setters sur Employe
        i2.setSuperieur(i1);
        c1.setSuperieur(i1);
        c2.setSuperieur(c1);

        // Affichage des employes
        System.out.println("===== LISTE DES EMPLOYES =====");

        for (int i = 0; i < employes.length; i++) {
            employes[i].afficherDetails();

            if (employes[i].getSuperieur() != null) {
                System.out.println("Superieur : "
                        + employes[i].getSuperieur().getNom());
            } else {
                System.out.println("Superieur : no one");
            }

            System.out.println("------------------------");
        }

        // Creation des missions
        Mission[] missions = {
            new Mission(i1, p1, 3),
            new Mission(i2, p1, 2),
            new Mission(c1, p2, 4),
            new Mission(c2, p2, 2)
        };

        // Affichage des missions et calcul du total
        System.out.println("\n===== LISTE DES MISSIONS =====");

        double montantTotal = 0;

        for (int i = 0; i < missions.length; i++) {
            missions[i].afficherRecapitulatif();
            montantTotal += missions[i].calculerMontant();
        }

        System.out.println("\nMontant total des missions : "
                + montantTotal + " DH");

    }
}