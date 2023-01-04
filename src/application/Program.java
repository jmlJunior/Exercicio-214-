package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Item;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		boolean newFolder = new File("D:\\JAVA\\Temp\\csvout").mkdir();
		System.out.println("Directory created successfully: " + newFolder);
		String newPath = "D:\\JAVA\\Temp\\csvout\\summary.csv";
		
		List<Item> list = new ArrayList<>();
		
		String path = "D:\\JAVA\\Temp\\vgsales.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while (line != null) {

				String[] item = line.split(",");
				String p = item[1];
				String pr = item[5];
				String na = item[6];
				String eu = item[7];
				String jp = item[8];
				String ot = item[9];
				String gbl = item[10];
				
				double p1 = Double.parseDouble(na);
				double p2 = Double.parseDouble(eu);
				double p3 = Double.parseDouble(jp);
				double p4 = Double.parseDouble(ot);
				double p5 = Double.parseDouble(gbl);
				double avg = (p1+p2+p3+p4+p5)/5;
				
				list.add(new Item(p, pr, avg));
				line = br.readLine();
			}
			
			for (Item i: list) {
				
				String[] lines = new String[] {i.getName() + "," + i.getPublisher() + "," + String.format("%.2f",i.getAverage())};
				
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
		
		catch (NumberFormatException e) {
			System.out.println("ERRO: " + e.getMessage() + "!");
		}
	}
}
