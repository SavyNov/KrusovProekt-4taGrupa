package sit.tuvarna.bg;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class XMLOperations {

    String name;
    Scanner scanner = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeXMLFile(ArrayList<Student> studentList ){
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = docFactory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("StudentInfo");
            doc.appendChild(root);

            for (Student stu : studentList){
                Element students = doc.createElement("Student");
                root.appendChild(students);

                Element name = doc.createElement("Name");
                name.appendChild(doc.createTextNode(String.valueOf(stu.getName())));
                students.appendChild(name);

                Element fn = doc.createElement("FacultyNumber");
                fn.appendChild(doc.createTextNode(String.valueOf(stu.getFacultyNumber())));
                students.appendChild(fn);

                Element major = doc.createElement("Major");
                major.appendChild(doc.createTextNode(String.valueOf(stu.getMajor())));
                students.appendChild(major);

                Element year = doc.createElement("Year");
                year.appendChild(doc.createTextNode(String.valueOf(stu.getYear())));
                students.appendChild(year);

                Element group = doc.createElement("Group");
                group.appendChild(doc.createTextNode(String.valueOf(stu.getGroup())));
                students.appendChild(group);

                Element status = doc.createElement("Status");
                status.appendChild(doc.createTextNode(String.valueOf(stu.getStatus())));
                students.appendChild(status);
            }

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer trans = tFactory.newTransformer();

            trans.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
            trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);

            try{
                FileWriter fileWriter = new FileWriter("./file.xml");
                StreamResult result = new StreamResult(fileWriter);
                trans.transform(source,result);
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
        catch(TransformerException ex) {
            System.out.println("Error outputting document");

        }
        catch (ParserConfigurationException ex){
            System.out.println("Error writing file");
        }
    }

    public void writeXMLFileAs(ArrayList<Student> studentList){
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = docFactory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("StudentInfo");
            doc.appendChild(root);

            for (Student stu : studentList){
                Element students = doc.createElement("Student");
                root.appendChild(students);

                Element name = doc.createElement("Name");
                name.appendChild(doc.createTextNode(String.valueOf(stu.getName())));
                students.appendChild(name);

                Element fn = doc.createElement("FacultyNumber");
                fn.appendChild(doc.createTextNode(String.valueOf(stu.getFacultyNumber())));
                students.appendChild(fn);

                Element major = doc.createElement("Major");
                major.appendChild(doc.createTextNode(String.valueOf(stu.getMajor())));
                students.appendChild(major);

                Element year = doc.createElement("Year");
                year.appendChild(doc.createTextNode(String.valueOf(stu.getYear())));
                students.appendChild(year);

                Element group = doc.createElement("Group");
                group.appendChild(doc.createTextNode(String.valueOf(stu.getGroup())));
                students.appendChild(group);

                Element status = doc.createElement("Status");
                status.appendChild(doc.createTextNode(String.valueOf(stu.getStatus())));
                students.appendChild(status);
            }

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer trans = tFactory.newTransformer();

            trans.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
            trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);

            try{
                FileWriter fileWriter = new FileWriter(this.name);
                StreamResult result = new StreamResult(fileWriter);
                trans.transform(source,result);
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
        catch(TransformerException ex) {
            System.out.println("Error outputting document");

        }
        catch (ParserConfigurationException ex){
            System.out.println("Error writing file");
        }
    }

    public void openXMLFile() {
        File file = new File(this.name + ".xml");
        if (file.exists()) {
            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = docFactory.newDocumentBuilder();
                Document doc = builder.parse(file);
            } catch (IOException | SAXException | ParserConfigurationException e) {
                e.printStackTrace();
            }
        } else {
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = dbf.newDocumentBuilder();
                Document doc = builder.newDocument();
                TransformerFactory tFactory = TransformerFactory.newInstance();
                Transformer trans = tFactory.newTransformer();

                Element root = doc.createElement("StudentInfo");
                doc.appendChild(root);

                trans.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
                trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                trans.setOutputProperty(OutputKeys.INDENT, "yes");

                DOMSource source = new DOMSource(doc);

                try{
                    FileWriter fileWriter = new FileWriter("./file.xml");
                    StreamResult result = new StreamResult(fileWriter);
                    trans.transform(source,result);
                }
                catch (IOException | TransformerException e) {
                    e.printStackTrace();
                }
            } catch (ParserConfigurationException | TransformerConfigurationException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void closeXMLFile(){
        try {
            File file = new File(this.name + ".xml");
            BufferedReader bf = new BufferedReader(new FileReader(file));
            bf.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }


}
