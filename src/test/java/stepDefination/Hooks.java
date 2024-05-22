package stepDefination;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@deletePlace")
    public void beforeScenario() throws IOException {

        StepDefination sd = new StepDefination();
        if (StepDefination.placeId == null) {
            sd.add_place_payload_with("chandra", "english", "Hyd");
            sd.user_calls_with_http_request("AddPlaceApi", "POST");
            sd.verify_place_id_created_maps_to_using("chandra", "GetPlaceApi");
        }

    }
}
