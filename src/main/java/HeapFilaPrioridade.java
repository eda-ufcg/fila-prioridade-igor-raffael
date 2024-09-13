public class HeapFilaPrioridade implements FilaPrioridade {

	private Heap heap;

	public HeapFilaPrioridade(int capacidade) {
		this.heap = new Heap(capacidade);
	}

	// adicionar o pair no heap
	public void add(String elemento, int prioridade) {
    Pair pair = new Pair(elemento, prioridade);
    heap.add(pair);
  }

	// recuperar a raiz
	public String removeNext() {
		Pair pair = this.heap.remove();
    return pair.getElemento();
	}
}
