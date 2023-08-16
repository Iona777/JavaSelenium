package utilities;
import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;

import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigHelper
{

    Properties configFile;
    //Constructor - not required, use default. Should I include Lombok @NoArgsConstructor?

    public String getProperty(String key)
    {
        try {
            Path target = Paths.get("src/test/java/resources");
            String absPath = target.toAbsolutePath().toString();
            String fileName = absPath+"/config.properties";

            FileReader reader = new FileReader(fileName);
            Properties prop = new Properties();
            prop.load(reader);

            return prop.getProperty(key);
    }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "Exception encounered";

    }


}
