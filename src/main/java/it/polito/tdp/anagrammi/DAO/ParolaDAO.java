package it.polito.tdp.anagrammi.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.Model.Parola;

public class ParolaDAO {

	public Set<String>getTuttiVocaboli()
	{
		final String sql = "SESELCT * "+
							"FROM parola";
		
		Set<String> parola = new HashSet<String>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
			
				int id = rs.getInt("id");
				String nome = rs.getString("codins");

				Parola p = new Parola(id,nome);
				
				// Aggiungi il nuovo oggetto Parola al set di Parole
				
				parola.add(p.getNome());
			}

			conn.close();
			
			return parola;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		 
	}
	
}
