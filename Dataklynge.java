import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Dataklynge {
   private int noderPerRack;
   private ArrayList<Rack> rackList;
/*
   public Dataklynge(int npr) {

     noderPerRack = npr;
     rackList = new ArrayList<Rack>();
     rackList.add(new Rack());

   }
*/

public Dataklynge(String filnavn) {

  File fil = new File(filnavn);
  rackList = new ArrayList<Rack>();
  rackList.add(new Rack());
  Scanner scan;

  try {
    scan = new Scanner(fil);
  }

  catch(FileNotFoundException exception) {

    System.out.println("Fant ikke filen");
    scan = new Scanner("");
  }

  while(scan.hasNextLine()) {

    int antallNoder = 0;
    int minnePerNode = 0;
    int antallProsessorerPerNode = 0;

    String linje = scan.nextLine();
    String[] alleData = linje.split(" ");

    if (alleData.length == 1) {
      noderPerRack = Integer.parseInt(alleData[0]);

    }
    else {
      antallNoder = Integer.parseInt(alleData[0]);
      minnePerNode = Integer.parseInt(alleData[1]);
      antallProsessorerPerNode = Integer.parseInt(alleData[2]);
    }
    for (int i = 0; i < antallNoder; i++) {
      this.settInnNode(new Node(minnePerNode, antallProsessorerPerNode));
    }
  }
}

   public void settInnNode(Node node) {

     for (int i = 0; i < rackList.size(); i++) {
       Rack enkeltRack = rackList.get(i);

       if (enkeltRack.getAntNoder() < noderPerRack) {

         enkeltRack.settInn(node);
         i = rackList.size();
       }

       else if (rackList.get(rackList.size()-1).getAntNoder() == noderPerRack) {

         rackList.add(new Rack());
       }
     }
   }

   public int antProsessorer() {

     int antPros = 0;

     for (int i = 0; i < rackList.size(); i++) {

       Rack enkeltRack = rackList.get(i);
       antPros += enkeltRack.antProsessorer();
     }

     return antPros;
   }

   public int noderMedNokMinne(int paaKrevdMinne) {

     int antallNoderMedNokMinne = 0;

     for (int i = 0; i < rackList.size(); i++) {

       Rack enkeltRack = rackList.get(i);
       antallNoderMedNokMinne += enkeltRack.noderMedNokMinne(paaKrevdMinne);
     }

     return antallNoderMedNokMinne;
   }

   public int antRack() {

     int antallRack = rackList.size();
     return antallRack;
   }

   public void skrivUt() { // Metode for å skrive info om Dataklyngen

     System.out.println("Noder med minst 32 GB: " + this.noderMedNokMinne(32) +
     "\n" + "Noder med minst 64 GB: " + this.noderMedNokMinne(64) + "\n" +
     "Noder med minst 128 GB: " + this.noderMedNokMinne(128));

     System.out.println("Antall prosessorer: " + this.antProsessorer() + "\n" +
     "Antall rack: " + this.antRack());
   }

}
