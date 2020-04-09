package com.restassured.SerializationDeserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable{
	
	int i=10,j=20;
}

public class SerializationDeserialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Test t1=new Test();
		
		//Serialization
		//Convert file into memory
		FileOutputStream fos=new FileOutputStream("test.txt");
		
		//COnvert object into fileformat
		ObjectOutputStream os=new ObjectOutputStream(fos);
		os.writeObject(t1);
		
		//Deserialization
		FileInputStream fis=new FileInputStream("test.txt");
		ObjectInputStream oss=new ObjectInputStream(fis);
		Test t2=(Test)oss.readObject();
		System.out.println(t2.i+" "+t2.j);
		
	}
}
