package estruturas_de_dados_baseadas_em_array;
/**
 * Motivação para a existência de um ArrayList: Abstrair o programador de 
 * diversas verificações e operações adicionais para manter a consistência
 * de um array, desses problemas podemos citar o array tendo tamanho fixo
 * o que é um problema quando é necessário dinâmica, também não é possível
 * remover uma posição do array, pois apenas atribuimo null a essa posição
 * deixando um buraco na implementação.
 * 
 * @author Caio Jhonatan Alves Pereira
 *
 * @param <T> Objeto que está sendo guardado no ArrayList.
 */
public class ArrayList<T> {

	/**
	 * Atributo baseado em array do objeto que está sendo guardado.
	 */
	private T[] lista;
	
	/**
	 * Capacidade padrao do ArrayLista, sendo usada quando a capacidade
	 *  não é passada no contrutor.
	 */
	public static final int CAPACIDADE_DEFAULT = 20;
	
	/**
	 * Tamanho do array
	 */
	private int tamanho;
	
	/**
	 * Construtor para quando não é passado nenhum argumento no parâmetro
	 */
	ArrayList(){
		this(CAPACIDADE_DEFAULT);
	}
	
	/**
	 * Construtor para quando é passado um argumento no parâmetro
	 * 
	 * @param capacidade Tamanho inicial desejado.
	 */
	ArrayList(int capacidade){
		lista = (T[]) new Object[capacidade];
		tamanho = 0;
	}
	
	/*Métodos de insersão
	1. bollean add(T t); Adiciona o elemento na próxima posiçao livre do array e retorna true caso tudo ocorra bem.
	2. void add(int index, T t); Adiciona o elemento em uma posição específica do array.
	3. void set(int index, T t); Altera um elemento em unma posição específica do array.
	*/
	
	/**
	 * Adiciona um determinado elemento no final da lista, caso a lista esteja cheia mais espaços serão criados dinamicamente.
	 * 
	 * @param t Elemento a ser inserido.
	 * @return True caso ocorra tudo bem.
	 */
	public boolean add(T t) {
		assegurarCapacidade(this.tamanho + 1);
		this.lista[this.tamanho++] = t;
		return true;
	}
	
	/**
	 * Adiciona um determinado elemento apartir de um index.
	 * 
	 * @param index Index que o novo elemento será inserido.
	 * @param t Elemento que subsituirá o que estava no index.x
	 */
	public void add(int index, T t) {
		if(index < 0 || index >= tamanho) throw new IndexOutOfBoundsException();
		
		assegurarCapacidade(this.tamanho + 1);
		
		shiftParaDireita(index);
		
		this.lista[index] = t;
		this.tamanho++;
	}
	
	/**
	 * Altera um determinado elemento apartir de seu index.
	 * 
	 * @param index Index do elemneto a ser alterado.
	 * @param t Elemento que substituirá o que estava no index.
	 */
	public void set(int index, T t) {
		if(index < 0 || index >= tamanho) throw new IndexOutOfBoundsException();
		this.lista[index] = t;
	}
	
	/**
	 * Método auxiliar, afasta elementos para direita apartir de um index
	 * 
	 * @param index Index que servirá de posição para afastar os demais elementos.
	 */
	private void shiftParaDireita(int index ) {
		if(index == this.lista.length - 1) throw new IndexOutOfBoundsException();
		for(int i = this.tamanho; i > index; i--) {
			this.lista[i] = this.lista[i - 1];
		}
	}
	
	private void assegurarCapacidade(int capacidadePretendiada) {
		if (capacidadePretendiada > this.lista.length) resize(Math.max(this.lista.length * 2, capacidadePretendiada));
	}
	
	/**
	 * Altara o tamanho de lista.
	 * 
	 * @param novaCapacidade Novo tamanho de lista.
	 */
	private void resize(int novaCapacidade) {
		T[] novaLista = (T[]) new Object[novaCapacidade];
		for (int i  = 0;  i < novaLista.length; i++) {
			novaLista[i] = this.lista[i];
		}
		this.lista = novaLista;
	}
	
	/*Remoção
	 * 
	 * T remove(int index);
	 * boolean remove(T t);
	 * 
	 * */
	
	/**
	 * Remove apartir de um index e retorna o elemento removido.
	 * 
	 * @param index Index do elemento a ser removido.
	 * @return Elemento removido.
	 */
	public T remove(int index) {
		if(index < 0 || index >= tamanho) throw	new IndexOutOfBoundsException();
		
		T t = this.get(index);
		
		shiftParaEsquerda(index);
		this.tamanho--;
		return t;
	}
	
	/**
	 * Remove um elemento apartir de um idêntico.
	 * 
	 * @param t Elemento igual ao que vai ser removido.
	 * @return true se o elemento foi removido, false caso não exista no array
	 * ou o objeto identico for nulo.
	 */
	public boolean remove(T t) {
		if(t == null) return false;
		for(int i = 0; i < this.tamanho; i++) {
			if(this.lista[i].equals(t)) {
				this.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Move todos os elemento de lista para a esquerda apartir de um index.
	 * 
	 * @param index Index usado de posição para mover os elementos, ponto inicial.
	 */
	private void shiftParaEsquerda(int index) {
		for (int i = index ;i < tamanho - 1; i--) {
			this.lista[i] = this.lista[i+1];
		}
	}
	
	
	/*
	 * Busca
	 * 
	 * T get(int index);
	 * int indexOf(T t);
	 * boolean contains(T t);
	 */
	
	public T get(int index) {
		if(index < 0 || index >= lista.length) throw new IndexOutOfBoundsException();
		
		return lista[index];
	}

	/**
	 * Procura pelo index de um elemento existente em lista, caso o elemento não
	 * esteja em lista retorna -1.
	 * 
	 * @param t Elemennto a ser procurado
	 * @return Index do elemento.
	 */
	public int indexOf(T t) {
		for(int i = 0 ; i < lista.length; i++) {
			if(lista[i].equals(t)) return i;
		}
		return -1;
	}
	
	public boolean contains(T t) {
		return indexOf(t) != -1;
	}
	
	
	
}
	