package question1;

import java.util.*;

public class Ensemble<T> extends AbstractSet<T> {

	protected java.util.Vector<T> table = new java.util.Vector<T>();

	public int size() {
		return table.size();
	}

	public Iterator<T> iterator() {
		return table.iterator();
	}

	public boolean add(T e) {
		if(!table.contains(e)){
		    table.add(e);
		    return true;
		  }
                
		return false;
	}

	public Ensemble<T> union(Ensemble<? extends T> e) {
		Ensemble E = new Ensemble();
		if(
			E.addAll(this) 
			&&
		     E.addAll(e)
		)return E;

		return null;
	}

	
	public Ensemble<T> inter(Ensemble<? extends T> e) {
		Ensemble E = new Ensemble();
                if(E.addAll(this) && E.retainAll(e))return E;
		return null;
	}

	public Ensemble<T> diff(Ensemble<? extends T> e) {
		Ensemble E = new Ensemble();
                if(E.addAll(this) && E.removeAll(e))return E;
		return null;
	}

	public Ensemble<T> diffSym(Ensemble<? extends T> e) {Ensemble E = new Ensemble();
		return (this.union(e)).diff(this.inter(e));
	}
	
}
