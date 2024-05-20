package mainPkg;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author User
 */
public class AppendableObjectOutputStream extends ObjectOutputStream{
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
        }
     @Override
         protected void writeStreamHeader() throws IOException { 
        
    }
}
