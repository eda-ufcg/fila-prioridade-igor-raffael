import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;

public class RoteiroTest {

  private Heap heap;

  @BeforeEach
  public void setUp() {
    heap = new Heap(5);
  }

  @Test
  public void testHeap() {
    assertTrue(heap.isEmpty());

    Pair p1 = new Pair("a", 10);
    heap.add(p1);
    assertTrue(heap.size() == 1);

    Pair p2 = new Pair("b", 8);
    heap.add(p2);
    assertTrue(heap.size() == 2);
    
    Pair p3 = new Pair("c", 6);
    heap.add(p3);
    assertTrue(heap.size() == 3);

    assertTrue("[<a, 10>, <b, 8>, <c, 6>]".equals(heap.toString()));

    heap.remove();

    assertTrue("[<b, 8>, <c, 6>]".equals(heap.toString()));
  }

  @Test
	public void test() {
		FilaPrioridade heap = new HeapFilaPrioridade(5);
		FilaPrioridade insereFinal = new InsereFinalFilaPrioridade(5);
		FilaPrioridade insertion = new InsereOrdenadoFilaPrioridade(5);
		FilaPrioridade[] estrategias = new FilaPrioridade[3];
		estrategias[0] = heap;
		estrategias[1] = insereFinal;
		estrategias[2] = insertion;


		// 1, 2, 3, 4, 5
		for (FilaPrioridade fila : estrategias) {
			fila.add("a", 1);
			fila.add("b", 2);
			fila.add("c", 3);
			fila.add("d", 4);
			fila.add("e", 5);
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "e");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "d");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "c");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "b");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "a");
		}		

		// 5, 4, 3, 2, 1
		for (FilaPrioridade fila : estrategias) {
			fila.add("a", 5);
			fila.add("b", 4);
			fila.add("c", 3);
			fila.add("d", 2);
			fila.add("e", 1);
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "a");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "b");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "c");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "d");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "e");
		}

		// 7, 2, 1, 9, -1 (valores de prioridade iguais segue fifo)
		for (FilaPrioridade fila : estrategias) {
			fila.add("a", 7);
			fila.add("b", 2);
			fila.add("c", 1);
			fila.add("d", 9);
			fila.add("e", -1);
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "d");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "a");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "b");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "c");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "e");
		}
	}
}
