package trabajofinal; 
import java.util.*;
import java.io.*;
public class ListaPersona {
    public static ArrayList leerArchivo() {
	File file = new File("C:\\Users\\Juliana\\Downloads\\prueba.txt");
	ArrayList listaPersonas= new ArrayList<>();	
	Scanner scanner;
	try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
		String linea = scanner.nextLine();
		Scanner delimitar = new Scanner(linea);				
		delimitar.useDelimiter("\\s*,\\s*");
		Persona e= new Persona();
		e.setCedula(delimitar.next());
		e.setNombre(delimitar.next());
		e.setApellido(delimitar.next());
		listaPersonas.add(e);
            }
            scanner.close();
	} catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	return listaPersonas;     
    }
    
    
    public static void añadirArchivo(ArrayList lista) {
	FileWriter flwriter = null;
        try {
            flwriter = new FileWriter("C:\\Users\\Juliana\\Downloads\\prueba.txt", true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            Persona persona;
            for (int i=0; i<lista.size();i++) {
                persona=(Persona) lista.get(i);
                bfwriter.write(persona.getCedula() + "," + persona.getNombre() + "," + persona.getApellido() + "\n");
            }
            bfwriter.close();
            }
            catch (IOException e) {
            e.printStackTrace();
            } 
            finally {
                if (flwriter != null) {
                    try {
                        flwriter.close();
                    } 
                    catch (IOException e) {
                    e.printStackTrace();
		}
            }
	}
    }
    
    public static void EliminarPersona(String linea) {
        try {
            File file = new File("C:\\Users\\Juliana\\Downloads\\prueba.txt");
            if (!file.isFile()) {
                return;
            }
            File tempFile = new File(file.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (!line.trim().equals(linea)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();
            if (!file.delete()) {
                return;
            }
            if (!tempFile.renameTo(file)){
            }
            }
            catch (FileNotFoundException ex) {
                    ex.printStackTrace();
            }
            catch (IOException ex) {
            ex.printStackTrace();
            }
        }
}
