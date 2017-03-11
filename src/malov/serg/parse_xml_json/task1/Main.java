package malov.serg.parse_xml_json.task1;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Main {
    public static ListTrains listTrains = new ListTrains();
    public static File file = new File("trains.xml");
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ListTrains.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            listTrains = (ListTrains) unmarshaller.unmarshal(file);
            Train train1 = new Train(listTrains.getTrains().size() + 1,"Kyiv","Odessa","09.03.2017","17:25");
            addTrainToXML(train1);
            printTrains(listTrains);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void printTrains(ListTrains listTrains){

        Date dateAfter = new GregorianCalendar(
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DATE),15,0).getTime();
        Date dateBefore = new GregorianCalendar(
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DATE),19,0).getTime();

        for (Train train: listTrains.getTrains()){
            if (train.getDateInDateFormat().after(dateAfter)&train.getDateInDateFormat().before(dateBefore))
                System.out.println(train);
        }
    }
    public static void addTrainToXML(Train train){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ListTrains.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            listTrains.addTrain(train);
            jaxbMarshaller.marshal(listTrains, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
