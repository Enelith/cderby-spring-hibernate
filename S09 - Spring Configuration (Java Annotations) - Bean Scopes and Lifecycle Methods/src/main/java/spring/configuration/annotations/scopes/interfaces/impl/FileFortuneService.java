/*
 * 
 */
package spring.configuration.annotations.scopes.interfaces.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import spring.configuration.annotations.scopes.interfaces.FortuneService;
import spring.configuration.annotations.scopes.utils.FileResourcesUtils;

@Component
public class FileFortuneService implements FortuneService {
    private String fileName = "fortune-data.txt";
    private List<String> theFortunes;

    // Create a random number generator
    private Random myRandom = new Random();

    public FileFortuneService() {
	System.out.println(" >> FileFortuneService: inside default constructor");
    }

    @PostConstruct
    private void loadTheFortunesFile() {
	System.out.println(" >> FileFortuneService: inside method loadTheFortunesFile");

	File theFile = null;
	try {
	    theFile = FileResourcesUtils.getFileFromResource(this.getClass(), fileName);

	    System.out.println("Reading fortunes from file: " + theFile);
	    System.out.println("File exists: " + theFile.exists());
	    
	    System.out.println("File content : ");
	    System.out.println();
	    FileResourcesUtils.printFile(theFile);
	    System.out.println();

	    // initialize array list
	    theFortunes = new ArrayList<String>();

	    // read fortunes from file
	    try (BufferedReader br = new BufferedReader(
			new FileReader(theFile))) {

		String tempLine;

		while ((tempLine = br.readLine()) != null) {
		    theFortunes.add(tempLine);
		}

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Override
    public String getFortune() {
	// pick a random string from the array
	int index = myRandom.nextInt(theFortunes.size());

	String tempFortune = theFortunes.get(index);

	return tempFortune;
    }

}
