package it.polito.tdp.anagrammi.Model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class Model {
	
	private ParolaDAO parolaDao;
	private Set<String> p;
	
	public Model()
	{
		ParolaDAO dao = new ParolaDAO();
	}
	
	public Set<String>getTuttiVocaboli()
	{
		return this.parolaDao.getTuttiVocaboli();
	}
	
	public Set<String> anagramma(String s) {
		p = new HashSet<String>();
		anagramma_ricorsiva("", 0, s);
		return p;
		
	}
	
	private void anagramma_ricorsiva(String parziale, int livello, String rimanenti) {
		if (rimanenti.length() == 0) 
		{ 
			p.add(parziale);
			return;
		} 
		else 
		{
			for (int pos = 0; pos < rimanenti.length(); pos++)
			{
				String nuova_parziale = parziale + rimanenti.charAt(pos);
				String nuova_rimanenti = rimanenti.substring(0, pos) + rimanenti.substring(pos + 1);
				anagramma_ricorsiva(nuova_parziale, livello + 1, nuova_rimanenti);
			}
		}
	}



}
