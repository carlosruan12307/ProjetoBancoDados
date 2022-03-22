package entities;

import java.util.ArrayList;

public class Bucket {
	int FR;
double quantidadeOF = 0;
int quantidadeC = 0;
	ArrayList<Struct> bucket;
	ArrayList<Bucket> ofbuckets;
public Bucket(int FR) {
	super();
	this.bucket = new ArrayList(FR);
	this.ofbuckets = new ArrayList();
	this.FR = FR;
}

public void addStruct(Struct struct) {

if(bucket.size() >= FR) {
	

	if(!ofbuckets.isEmpty() && ofbuckets.get(ofbuckets.size() - 1).bucket.size() <  FR) {
		this.ofbuckets.get(ofbuckets.size() - 1).bucket.add(struct);
	
		this.ofbuckets = ofbuckets;

		return;

	}
	if(ofbuckets.size() == 0 || ofbuckets.get(ofbuckets.size() - 1).bucket.size() == FR) {
		Bucket of = new Bucket(this.FR);
		of.addStruct(struct);
		this.ofbuckets.add(of);
		quantidadeOF++;
		return;
	}
	
}else {
	this.bucket.add(struct);
	return;
}
}



public double getQuantidadeOF() {
	return quantidadeOF;
}

public void setQuantidadeOF(double quantidadeOF) {
	this.quantidadeOF = quantidadeOF;
}

public int getQuantidadeC() {
	return quantidadeC;
}

public void setQuantidadeC(int quantidadeC) {
	this.quantidadeC = quantidadeC;
}

public int getFR() {
	return FR;
}

public void setFR(int fR) {
	FR = fR;
}

public ArrayList<Struct> getBucket() {
	return bucket;
}

public void setBucket(ArrayList<Struct> bucket) {
	this.bucket = bucket;
}

public ArrayList<Bucket> getOfbuckets() {
	return ofbuckets;
}

public void setOfbuckets(ArrayList<Bucket> ofbuckets) {
	this.ofbuckets = ofbuckets;
}



}
