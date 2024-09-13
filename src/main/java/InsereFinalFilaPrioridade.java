import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
    Pair pair = new Pair(elemento, prioridade);
    this.fila.add(pair);
  }


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		Pair maxPair = fila.get(0);
    int index = 0;

    for (int i = 0; i < fila.size(); i++) {
      if (maxPair.getPrioridade() < fila.get(i).getPrioridade()) {
        maxPair = fila.get(i);
        index = i;
      }
    }

    fila.remove(index);
    return maxPair.getElemento();
	}
}
