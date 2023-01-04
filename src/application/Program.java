package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Item;

public class Program {

	public static void main(String[] args) throws ParseException{
		
		Locale.setDefault(Locale.US);

		boolean newFolder = new File("D:\\JAVA\\Temp\\ws-eclipse\\Exercício-214\\csvout").mkdir();
		System.out.println("Directory created successfully: " + newFolder);
		String newPath = "D:\\JAVA\\Temp\\ws-eclipse\\Exercício-214\\CSVOut\\summary.csv";
		System.out.println("File created successfully! ");
		
		List<Item> list = new ArrayList<>();
		
		String path = "D:\\JAVA\\Temp\\ws-eclipse\\Exercício-214\\csvin\\vgsales.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while (line != null) {

				String[] item = line.split(",");
				String p = item[1];
				String pr = item[5];
				double na = Double.parseDouble(item[6]);
				double eu = Double.parseDouble(item[7]);
				double jp = Double.parseDouble(item[8]);
				double ot = Double.parseDouble(item[9]);
				double gbl = Double.parseDouble(item[10]);
				double avg = (na+eu+jp+ot+gbl)/5;
				
				list.add(new Item(p, pr, avg));
				line = br.readLine();
			}
			
			for (Item i: list) {
				String[] lines = new String[] {i.getName() + "," 
				                                           + i.getPublisher() 
				                                           + "," 
				                                           + String.format("%.2f",i.getAverage())};
				
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(newPath, true))){
					for (String newLines : lines) {
						bw.write(newLines);
						bw.newLine();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		catch (IOException e) {
			System.out.println("ERRO: " + e.getMessage() + "!");
		}
	}
}