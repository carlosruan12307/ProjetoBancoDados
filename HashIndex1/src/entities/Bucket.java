package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Bucket {

 Map<Integer,IndicePaginaC> map ;

	public Bucket() {
		super();
		this.map = new HashMap<Integer,IndicePaginaC>();
	}
	
	public void addB(int indiceBucket,IndicePaginaC indicePaginaC) {
		map.put(indiceBucket, indicePaginaC);
	}
}
