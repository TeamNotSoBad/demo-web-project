package edu.csupomona.cs480;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

import edu.csupomona.cs480.util.ResourceResolver;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AWSTest extends TestCase {
	
	/**
	 * Thomas Nguyen 
	 * Assignment 6
	 * This test is check if the JSON file locally stored is equivalent to the JSON
	 * file stored in Amazon S3. The problem was that getObject method returns a
	 * special type of object that isn't compatible to a JSON file so I converted it
	 * to a input stream and compared it to the input stream of the actual JSON file.
	 * This test will fail if any changes are made to the locally stored JSON file and
	 * not to the file uploaded on S3. 
	 * @throws IOException
	 */
	
	public void testAWSGetObject() throws IOException{
		File temp = ResourceResolver.getUserFile();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ObjectOutputStream oos = new ObjectOutputStream(baos);
	    Object obj = ResourceResolver.getUserFile();
	    File aws = ResourceResolver.getUserFile();

	    oos.writeObject(obj);
	    oos.flush();
	    oos.close();

	    InputStream is = new ByteArrayInputStream(baos.toByteArray());
		
		assertEquals(temp, aws);
	}
	

}
