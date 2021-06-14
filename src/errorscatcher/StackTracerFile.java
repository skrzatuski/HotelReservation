package errorscatcher;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class StackTracerFile {
    public void saveExceptionToFile(Exception e) throws FileNotFoundException {
        try {
            Date date = new Date();
            String d1 = date.toString();
            FileWriter fstream = new FileWriter("c:/stacktracefile/exception.txt", true);
            BufferedWriter out = new BufferedWriter(fstream);
            PrintWriter pWriter = new PrintWriter(out, true);
            pWriter.print(d1+":");
            pWriter.print("\n");
            e.printStackTrace(pWriter);
        }
        catch (Exception ie) {
            throw new RuntimeException("Could not write Exception to file", ie);
        }
    }
}
