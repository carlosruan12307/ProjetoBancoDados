package entities;

import java.util.ArrayList;

public class Ofbucket {
	ArrayList<Bucket> ubucket;
int FR;
	public Ofbucket(int FR) {
		super();
		this.ubucket = 	new ArrayList();
		this.FR = FR;
	}
	
	public void addB(Bucket bucket) {
		if(ubucket.get(ubucket.size()-1).bucket.size() > FR) {
			Bucket of = new Bucket(this.FR); // overflow
					ubucket.add(of);
		}else {
			ubucket.add(bucket);
		}
	
	}
}
