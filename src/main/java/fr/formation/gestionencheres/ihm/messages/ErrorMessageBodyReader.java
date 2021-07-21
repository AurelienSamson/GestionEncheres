package fr.formation.gestionencheres.ihm.messages;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;


/**
 * 
 * Read message from ErrorMessage.properties file
 *
 */
public abstract class ErrorMessageBodyReader {
	private static Properties properties;
	
    static {
        try {
            InputStream utf8in = ErrorMessageBodyReader.class.getClassLoader().getResourceAsStream("fr/formation/gestionencheres/ihm/messages/ErreurMessage.properties");
            Reader reader = new InputStreamReader(utf8in, StandardCharsets.UTF_8);
            properties = new Properties();
            properties.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * Used to get messages body from codes in ErrorMessage.properties
     * @param code: int The code to get the message from
     * @return return a  message or an Undentify error message if it could not found one in the file.
     */
    public static  String getErrorMessageBodyReader(int code)
    {
        String message;
        try {
            if(properties != null) {
                message = properties.getProperty(String.valueOf(code));
            } else {
                message="Un problème est survenue lors de la lecture du fichier .properties";
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "Erreur non identifiée";
        }
        return message;
    }
	
	
	

}
