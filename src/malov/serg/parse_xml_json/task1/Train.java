package malov.serg.parse_xml_json.task1;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement
public class Train {

    private long id;
    private String from;
    private String to;
    private String date;
    private String departure;

    public Train() {
    }

    public Train(long id, String from, String to, String date, String departure) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure = departure;
    }

    public long getId() {
        return id;
    }
    @XmlAttribute
    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }
    @XmlElement
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }
    @XmlElement
    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    @XmlElement
    public void setDate(String date) {
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }
    @XmlElement
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public Date getDateInDateFormat(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        try {
            return sdf.parse(date+" "+departure);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Train:{id="+id+" from="+from+" to="+to+" date="+date+" departure="+departure+"}";
    }
}
