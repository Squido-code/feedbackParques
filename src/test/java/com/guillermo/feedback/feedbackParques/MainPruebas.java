package com.guillermo.feedback.feedbackParques;

import java.util.ArrayList;
import java.util.List;

import com.guillermo.feedback.DAO.CiudadDAO;
import com.guillermo.feedback.DAO.ParqueDAO;
import com.guillermo.feedback.model.Ciudad;
import com.guillermo.feedback.model.Parque;
import com.guillermo.feedback.utiles.Herramientas;
import com.guillermo.feedback.utiles.Menu;

public class MainPruebas {
		private static Menu menu = new Menu();
		private static int opcion = 0;
		private static ParqueDAO tablaParque = new ParqueDAO();
		private static CiudadDAO tablaCiudad = new CiudadDAO();
		private static Herramientas tool= new Herramientas();
		private static List<Parque> listaParques = new ArrayList<Parque>();
		private static String userOption;

		public static void main(String[] args) {
			List<Parque> listaParques = new ArrayList<Parque>();
			listaParques=tablaParque.findAll();
			tool.mostrarListaParques(listaParques);
					
					
					


}
}
