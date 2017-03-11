package malov.serg.parse_xml_json.task3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name = "results")
public class Results {

    private Rate[] rate;

    public Results() {
    }

    public Rate[] getRate() {
        return rate;
    }
    @XmlElement(name = "rate")
    public void setRate(Rate[] rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Results{" +
                "rate=" + Arrays.toString(rate) +
                '}';
    }
}
