package designpatternComposite ;
import java.util.ArrayList;
import java.util.List;

abstract class Repertoire {
  public abstract float getTaille();
}

class Fichier extends Repertoire {
  private String repertoireNom;
  private float repertoireTaille;

  public Fichier (String repertoireNom, float repertoireTaille) {
    super();
    this.repertoireNom = repertoireNom;
    this.repertoireTaille = repertoireTaille;
  }

  public float getTaille() {
    return repertoireTaille;
  }

}

class SavingRepertoire extends Repertoire {
  private String repertoireNom;
  private float repertoireTaille;

  public SavingRepertoire(String repertoireNom, float repertoireTaille) {
    super();
    this.repertoireNom = repertoireNom;
    this.repertoireTaille = repertoireTaille;
  }

  public float getTaille() {
    return repertoireTaille;
  }
}

class CompositeRepertoire extends Repertoire {
  private float espaceUtiliser;
  private List<Repertoire> repertoireList = new ArrayList<Repertoire>();

  public float getTaille() {
    espaceUtiliser = 0;
    for (Repertoire f : repertoireList) {
      espaceUtiliser = espaceUtiliser + f.getTaille();
    }
    return espaceUtiliser;
  }

  public void addRepertoire(Repertoire fichier) {
    repertoireList.add(fichier);
  }

  public void removeRepertoire(Repertoire fichier) {
    repertoireList.add(fichier);
  }
}

public class Disque {

  public static void main(String[] args) {
    CompositeRepertoire component = new CompositeRepertoire();

    component.addRepertoire(new Fichier("fichierTEC", 100));
    component.addRepertoire(new Fichier("fichierAnglais", 150));
    component.addRepertoire(new SavingRepertoire("fichierDesign", 200));

    float espaceUtiliser = component.getTaille();
    System.out.println("Nom: fichierTEC , Taille: 100 octets");
    System.out.println("Nom: fichierAnglais , Taille: 150 octets");
    System.out.println("Nom: fichierDesign , Taille: 200 octets");
    System.out.println("Total espace Repertoire : " + espaceUtiliser + "Octets");


  }
 
}