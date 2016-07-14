package edu.csupomona.cs480.data;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Work in Progress file uploading class.
 * Library: Commons FileUpload.
 * 
 * @author HH
 * Currently: I am viewing the documentation for the library.
 * Note: I have a major problem understanding how a file will be uploaded,
 * where the file will be uploaded into our Amazon cloud. How does the file
 * get stored on the cloud? And where?
 */
public class BetaFileUpload {
		
	/**
	 * This method is temporary, for testing, and a work in progress.
	 * Some Code will be taken from the Commons FileUpload documentation.
	 */
	public void pendingMethod() {
	/*	
		//The Directory where exceeding size files are to be stored.
		File temporaryDirectory = new File("tempDir");
		
		// Create a factory for disk-based file items. 
		// Below 3MB, retained in memory. Else store on the hard disk.		
		DiskFileItemFactory factory = new DiskFileItemFactory(3000000, temporaryDirectory);
		
		FileUpload fileUploader = new FileUpload(factory);
		
		processedItem newItem = processFileUpload(null);
		
		factory.createItem(newItem.getFieldName(), newItem.getContentType(),
							true, newItem.getFileName());
		
		
		
		
		
		
		
		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		List<FileItem> items = upload.parseRequest(request);
	}
	
	
	
	public void processUploadedItems() {
		// Process the uploaded items
		Iterator<FileItem> iter = items.iterator();
		while (iter.hasNext()) {
		    FileItem item = iter.next();

		    if (item.isFormField()) {
		        processFormField(item);
		    } else {
		        processUploadedFile(item);
		    }
		}
	}
	
	public processedItem processFileUpload(Object item) {		
		if (!item.isFormField()) {
		    String fieldName = item.getFieldName();
		    String fileName = item.getName();
		    String contentType = item.getContentType();
		    boolean isInMemory = item.isInMemory();
		    long sizeInBytes = item.getSize();
		    
		    return new processedItem(fieldName, fileName, contentType, isInMemory, sizeInBytes);
		} else {
			return null;
		}
	}
	
	/*
		// Process a file upload
		if (writeToFile) {
		    File uploadedFile = new File(...);
		    item.write(uploadedFile);
		} else {
		    InputStream uploadedStream = item.getInputStream();
		    ...
		    uploadedStream.close();
		}*/
	}
	
	private class processedItem {
	    private String fieldName;
	    private String fileName;
	    private String contentType;
	    private boolean isInMemory;
	    private long sizeInBytes;
	    
	    private processedItem(String fieldName, String fileName, String contentType,
	    						boolean isInMemory, long sizeInBytes) {
		    this.fieldName = fieldName;
		    this.fileName = fileName;
		    this.contentType = contentType;
		    this.isInMemory = isInMemory;
		    this.sizeInBytes = sizeInBytes;
	    }

		public String getFieldName() {
			return fieldName;
		}
		
		public String getFileName() {
			return fileName;
		}

		public String getContentType() {
			return contentType;
		}

		public boolean getIsInMemory() {
			return isInMemory;
		}

		public long getSizeInBytes() {
			return sizeInBytes;
		}
	}
}