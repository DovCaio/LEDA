package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bt.BTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer resultado = null;
		
		
		if(array != null) {
			this.insert((int) numero);
			
			
			for(Integer valres : array) {
				this.insert(valres);
				if(valres == numero) resultado = (int) numero;
				break;
			}
			
			
			if(this.root.getLeft() != null) resultado = this.root.getData();
			else resultado = floor(this.root.getLeft());
			
			
		}
		
		
		return resultado;
	}
	
	private Integer floor(BTNode node) {
		Integer resultado = null;
		
		
		if(node.getRight() != null) {
			resultado = floor(node.getRight());
		}else {
			resultado = (Integer) node.getData();
		}
		
		
		
		return resultado;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer resultado = null;
		
		if(array != null) {
			
			this.insert((int) numero);
			
			for(Integer valores : array) {
				
				this.insert(valores);
				
			}
			
			if(this.root.getRight() == null) resultado = this.root.getData();
			else ceil(this.root.getRight());
		}
		
		return resultado;
	}
	
	private Integer ceil(BTNode node) {
		Integer resultado = null;
		
		
		if(node.getRight() == null) resultado = (Integer) node.getData();
		else resultado = ceil(node.getRight());
		
		return resultado;
	}
	


}
