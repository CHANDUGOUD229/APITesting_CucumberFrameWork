package resources;

//enum is special class in java it contains collects of constants and methods
public enum APIResources {


    AddPlaceApi("/maps/api/place/add/json"),
    GetPlaceApi("/maps/api/place/get/json"),
    DeletePlaceApi("/maps/api/place/delete/json");
    private String resources;

    APIResources(String resources) {
        this.resources = resources;
    }

    public String getResource(){
       return resources;
    }


}
