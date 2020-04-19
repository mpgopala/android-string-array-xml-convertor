package gsharma.androidutils.stringarraytoxml;

import java.io.FileWriter;
import java.io.IOException;


/**
 * Helper class to convert a <code>String[]</code> into a separate Android resource. Create an object of this class
 * and call the method <code>stringToXml</code>. That would create a resource with string-array's name as <code>name</code>
 * and writes this in a file with name {name_in_lower_case}_values.xml. One would need to copy this file to Android's
 * res/values folder and use the same as String resources.
 */
public class AndroidStringArrayXmlConvertor
{
    private void writeToFile(String fileName, String content)
    {
        try {
            FileWriter writer = new FileWriter(fileName, false);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param array The String[] that needs to be converted to string-array resource.
     * @param name The name of the string-array. This is also used as the name of the resource file created.
     *             The name of hte resource file would be {lower_case_name}_values.xml.
     * @return The contents of the file written is returned as a return value.
     */
    public String stringToXml(String[] array, String name)
    {
            StringBuilder builder = new StringBuilder();
            builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<resources>\n" +
                    "   <string-array\n" +
                    "       name=\"");
            builder.append(name);
            builder.append("\">\n");
            for(String s : array)
            {
                builder.append("            <item>").append(s).append("</item>\n");
            }
            builder.append("    </string-array>\n" +
                    "</resources>");
            String str = builder.toString();

            String fileName = name.toLowerCase() + "_values.xml";
            writeToFile(fileName, str);
            return str;
    }
}