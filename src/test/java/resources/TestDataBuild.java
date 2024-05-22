package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public  AddPlace addPlacePayLoad(String name, String language, String address)
    {
        AddPlace ap = new AddPlace();
        ap.setAccuracy(68);
        ap.setAddress(address);
        ap.setLanguage(language);
        ap.setName(name);
        ap.setPhone_number("9584254754");
        ap.setWebsite("chandrashekhar.com");
        List<String> types = new ArrayList<>();
        types.add("house");
        types.add("airth");
        ap.setTypes(types);

        Location l = new Location();
        l.setLat(-10.55874);
        l.setLng(25744.787);
        ap.setLocation(l);
        return ap;
    }

    public String deletePlacePayload(String place_id){
        return "{\n\"place_id\": \""+place_id+"\"\n}";
    }

}
