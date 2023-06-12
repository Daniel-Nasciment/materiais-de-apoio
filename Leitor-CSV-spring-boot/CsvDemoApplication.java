package br.com.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CsvDemoApplication {

	public static void main(String[] args) throws IOException, CsvException {
		
		
		
		CSVReader reader = new CSVReader(new FileReader(new File("c:/teste-csv/teste.csv")));
		
		List<Map<String,String>> conteudo = new ArrayList<>();
		
		String[] header = reader.readNext();
		String[] content = null;
		
		while ((content = reader.readNext()) != null) {
			
			Map<String, String> mapa = new HashMap<>();
			
			for(int i = 0; i < content.length; i++) {
				
				mapa.put(header[i], content[i]);
				
			}

			conteudo.add(mapa);
			
		} 
		
		
		conteudo.forEach(c -> {
			System.out.println("==========================");
			
			System.out.println("Nome:" + c.get("nome"));
			System.out.println("idade:" + c.get("idade"));
			System.out.println("email:" + c.get("email"));
			
			System.out.println("==========================");
		});
			
	}

}
