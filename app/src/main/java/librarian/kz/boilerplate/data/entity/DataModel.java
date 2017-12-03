package librarian.kz.boilerplate.data.entity;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class DataModel extends RealmObject
{
    @PrimaryKey
    private int id;
    private String name;
    private String imageUrl;
    private String lastUpdated;

    public DataModel(){}

    public DataModel(int id, String name, String imageUrl, String lastUpdated)
    {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}