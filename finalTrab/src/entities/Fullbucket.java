package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Fullbucket {
Bucket[] b;
double ofg = 0;
int FR;
int NR;
public Fullbucket(int NR,int FR) {
	super();
	this.b = new Bucket[NR/FR];
	this.FR = FR;
}

public Bucket[] getB() {
	return b;
}

public void setB(Bucket[] b) {
	this.b = b;
}



public double getOfg() {
	return ofg;
}

public void setOfg(double ofg) {
	this.ofg = ofg;
}

public int getFR() {
	return FR;
}

public void setFR(int fR) {
	FR = fR;
}

public int getNR() {
	return NR;
}

public void setNR(int nR) {
	NR = nR;
}

public void addB(int hashR,Struct struct) {

	if(b[hashR] == null) {
		Bucket bucket = new Bucket(FR);
		bucket.addStruct(struct);
		b[hashR] = bucket;
		
	}else {
		b[hashR].addStruct(struct);
	}
	ofg = ofg + b[hashR].quantidadeOF;
}

}
