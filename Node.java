class Node {
  int minne;
  int antPros;
  // Variabler for minne og antall prosessorer

  public Node(int m, int ant) {

    minne = m;
    antPros = ant;
  }

  public int antProsessorer() {

    return antPros;
  }

  public boolean nokMinne(int paakrevdMinne) {

    boolean b1 = false;
    if (minne >= paakrevdMinne) {
      b1 = true;
    }

    return b1;
  }


}
