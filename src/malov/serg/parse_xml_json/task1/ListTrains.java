package malov.serg.parse_xml_json.task1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "trains")
public class ListTrains {
    @XmlElement(name = "train")
    private List<Train> trains = new ArrayList<>();

    public void addTrain(Train train){
        trains.add(train);
    }

    public List<Train> getTrains() {
        return trains;
    }
}
