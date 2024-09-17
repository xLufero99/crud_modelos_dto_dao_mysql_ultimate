package controlador;

import java.sql.SQLException;
import java.util.Scanner;

import modelo.dao.EstudianteDAO;



public class ControladorEstudiante {
	
	
	/* como estaba antes de la implementacion web
	public static void main(String[] args) throws SQLException {

		try (Scanner sc = new Scanner(System.in)) {
			EstudianteDAO estudianteDAO = new EstudianteDAO();

			boolean loop = true;
			while (loop) {

				System.out.println("\n enter your choice");
				System.out.println("1. Insert the record");
				System.out.println("2. Displaying All the records");
				System.out.println("3. Displaying the records by id");
				System.out.println("4. Update All the records of 1 Row");
				System.out.println("5. Delete All the records of 1 Row");
				System.out.println("6. Exit");
				System.out.println("===========================================================");

				int choice = Integer.parseInt(sc.nextLine());

				switch (choice) {
				case 1:
					System.out.println("Enter details of Student");
					estudianteDAO.insertarEstudiante();
					break;
				case 2:
					System.out.println("Records of all student");
					estudianteDAO.obtenerEstudiante();
					break;
				case 3:
					System.out.println("Enter id to find all info of that id");
					int id = Integer.parseInt(sc.nextLine());
					estudianteDAO.obtenerEstudiantePorid(id);
					break;
				case 4:
					System.out.println("Enter id to update");
					estudianteDAO.actualizarEstudiante();

				case 5:
					System.out.println("Enter id to delete");
					int id2 = Integer.parseInt(sc.nextLine());
					estudianteDAO.borrarEstudiante(id2);
					break;
				case 6:
					System.out.println("Thank you. Visit again.");
					loop = false;
					break;
				default:
					System.out.println("you have enter wrong option");
					break;
				}
			}
		}
	}
	*/
}
