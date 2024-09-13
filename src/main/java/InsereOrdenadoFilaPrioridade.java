public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;

  public boolean isEmpty() {
    return this.head == -1 && this.last == -1;
  }
 
  public boolean isFull() {
    return this.head == (this.last + 1) % fila.length;
  }

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}

  // criar um Pair e inserir de forma ordenada decrescente no array.
  public void add(String elemento, int prioridade) {
    if (this.isFull()) {
      Pair[] newFila = new Pair[fila.length * 2];
      for (int i = 0; i < fila.length; i++)
        newFila[i] = fila[i];
      this.fila = newFila;
    }

    if (isEmpty())
      this.head++;

    this.last = (this.last + 1) % fila.length;

    Pair pair = new Pair(elemento, prioridade);
    fila[this.last] = pair;

    int i = this.last;
    while (i > 0 && this.fila[i - 1].getPrioridade() < this.fila[i].getPrioridade()) {
      Pair aux = this.fila[i];
      this.fila[i] = this.fila[i - 1];
      this.fila[i - 1] = aux;
      i--;
    }
  }


	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		if (this.isEmpty()) throw new RuntimeException();

    String out = fila[this.head].getElemento();

    if (this.head == this.last) {
      this.head = -1;
      this.last = -1;
    } else {
      this.head = (this.head + 1) % fila.length; 
    }

    return out;
	}

}
