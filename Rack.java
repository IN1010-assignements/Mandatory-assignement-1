import java.util.ArrayList;  // Importerer Arraylist klassen

class Rack {
  ArrayList<Node> nodeList;

  public Rack() {

    nodeList = new ArrayList<Node>();
  }

  public void settInn(Node node) {

    nodeList.add(node);  // Legger til aktuell node i listen.
  }

  public int getAntNoder() {

    int antNoder = nodeList.size();   // Finner hvor mange noder det er i listen.
    return antNoder;
  }

  public int antProsessorer() {

    int antPros = 0;
    for (int i = 0; i < nodeList.size(); i++) {
      Node noden = nodeList.get(i);
      antPros += noden.antProsessorer();
      // For-loop som henter hver node i listen og summerer antall antProsessorer
      // i antPros.
    }

    return antPros;  // Returnerer det totale antall prosessorer
  }

  public int noderMedNokMinne(int paakrevdMinne) {

    int noderMedNokMinne = 0;
    for (int i = 0; i < nodeList.size(); i++) {
      Node noden = nodeList.get(i);
      // for-loop som henter hver enkelt node i listen
      if (noden.nokMinne(paakrevdMinne) == true) {
        noderMedNokMinne += 1;
        // if-sjekk som sjekker om noden har tilstrekkelig minne, og summerer
        // antall noder med tilstrekkelig minne
      }
    }

    return noderMedNokMinne;
  }
}
