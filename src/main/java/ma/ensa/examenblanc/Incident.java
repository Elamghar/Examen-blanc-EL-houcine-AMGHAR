package ma.ensa.examenblanc;

import java.util.Date;

public class Incident {
    private String reference,status,idIembre;
    private Date time;


    public Incident(String reference,Date time,String status) {
        this.reference = reference;
        this.time=time;
        this.status=status;
    }

    public String getReference() {
        return reference;
    }

    public String getStatus() {
        return status;
    }

    public String getIdIembre() {
        return idIembre;
    }

    public Date getTime() {
        return time;
    }
}

