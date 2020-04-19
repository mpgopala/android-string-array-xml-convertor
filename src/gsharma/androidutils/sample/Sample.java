package gsharma.androidutils.sample;

import gsharma.androidutils.stringarraytoxml.AndroidStringArrayXmlConvertor;

public class Sample {
    static String[] Sample = {"ONE", "TWO", "THREE"};

    public static void main(String[] args)
    {
        AndroidStringArrayXmlConvertor obj = new AndroidStringArrayXmlConvertor();
        System.out.println(obj.stringToXml(Sample, "Sample"));
    }
}
