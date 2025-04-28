package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Deadline
{
    @SerializedName("programNazev")
    public String programNazev;
    @SerializedName("oborNazev")
    public String oborNazev;
    @SerializedName("eprDeadlinePrihlaska")
    public EprDeadlinePrihlaska eprDeadlinePrihlaska;

    public class EprDeadlinePrihlaska {

        @SerializedName("value")
        public String value;

        public String getValue() {
            return value;
        }
    }
}
