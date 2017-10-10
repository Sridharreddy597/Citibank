package com.bcj.elimination.applicationui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NotepadApplication {
	static int choice;
	static String DIRECTORY_LOCATION;
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		DIRECTORY_LOCATION=System.getProperty("user.dir");

		do {
			displayMenu();
		} while (choice > 4);

	}

	private static void displayMenu() {

		System.out.println("welcome  to  Notepad Application ");
		System.out.println();
		System.out.println("***********  menu  *********");
		System.out.println("   1) File creation   ");
		System.out.println("   2) Modify a file   ");
		System.out.println("   3) Delete a file   ");
		System.out.println("   4) Read a file     ");
		System.out.println("   5) List files in the directory    ");
		System.out.println("   6) Rename a File     ");
		System.out.println("   7) Enter 0 to exit    ");
		System.out.println("***********  menu  *********");
		System.out.println();
		System.out.println();

		System.out.println("enter your choice ");
		choice = s.nextInt();
		switch (choice) {

		case 1:
			createFile();
			displayChoice();
			break;

		case 2:
			modifyFile();
			displayChoice();
			break;

		case 3:
			deleteFile();
			displayChoice();
			break;

		case 4:
			readAFile();
			displayChoice();
			break;
			
		case 5: 
			listFiles(DIRECTORY_LOCATION);
			displayChoice();
			break;
			
		case 6: 			
			renameAFile();
			displayChoice();
			break;

		case 0:
			System.exit(0);

		default:
			System.out.println();
		}

	}

	private static void renameAFile() {
		listFiles(DIRECTORY_LOCATION);
		
		System.out.println("enter the name of the file to rename ");
		File oldfile =new File(s.next());
		System.out.println("enter the  new name of the file to rename ");
		File newfile =new File(s.next());

		if(oldfile.renameTo(newfile)){
			System.out.println("Rename succesful");
		}else{
			System.out.println("Rename failed");
		}
		
	}

	private static void displayChoice() {
		System.out.println("do you want to continue  Y or N");
		String c = s.next();
		if ("y".equalsIgnoreCase(c))
			displayMenu();		
	}

	private static void readAFile() {
		listFiles(DIRECTORY_LOCATION);
		System.out.println(" enter the name of the file to read ");
		// The name of the file to open.
		String fileName = s.next();

		// This will reference one line at a time
		String line = null;

		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}

	private static void deleteFile() {
		listFiles(DIRECTORY_LOCATION);
		s.nextLine();
		System.out.println(" enter the name of the file to delete ");

		File f = new File(s.nextLine());
		f.delete();
		System.out.println("file deleted sucessfully ");

	}

	private static void modifyFile() {
		listFiles(DIRECTORY_LOCATION);
		System.out.println(" enter the name of file to edit ");
		// String fileName=s.next();

		String fileName=s.next();
		StringBuffer oldFileName = new StringBuffer();
		String newFileName =fileName;
		String line=null;
		String temp=null;
		
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                temp=line;
                oldFileName.append(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
		
		try{
		
		FileWriter writer = new FileWriter(fileName);
		System.out.println(" enter the text into file ");
		String fileContent = s.next();
		fileContent=temp.concat(fileContent);
		writer.write(fileContent);
		writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }

	}

	public static void listFiles(String directoryName) {
		File directory = new File(directoryName);
		// get all the files from a directory
		File[] fList = directory.listFiles();
		int count = 1;
		for (File file : fList) {
			if (file.isFile()) {
				System.out.println(count + ")" + file.getName());
				count++;
			}
		}
	}

	private static void createFile() {
		try {
			System.out.println("enter the name of the file");
			String fileName = s.next();
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			System.out.println(" enter the text into file ");
			String fileContent = s.next();
			writer.println(fileContent);
			writer.close();

			System.out.println(" file create sucessfully ");
		} catch (IOException e) {
			// do something
		}
	}

}
