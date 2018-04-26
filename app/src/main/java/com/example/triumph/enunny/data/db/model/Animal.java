
package com.example.triumph.enunny.data.db.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "animals")
public class Animal {

    @Expose
    @SerializedName("name")
    @Property(nameInDb = "name")
    private String name;

    @Expose
    @Property(nameInDb = "imgUrl")
    @SerializedName("imgUrl")
    private String imgUrl;

    @Expose
    @Property(nameInDb = "soundUrl")
    @SerializedName("soundUrl")
    private String soundUrl;

    @Expose
    @Property(nameInDb = "makesSound")
    @SerializedName("makesSound")
    private String makesSound;

    @Generated(hash = 1728312985)
    public Animal(String name, String imgUrl, String soundUrl, String makesSound) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.soundUrl = soundUrl;
        this.makesSound = makesSound;
    }

    @Generated(hash = 308569294)
    public Animal() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSoundUrl() {
        return this.soundUrl;
    }

    public void setSoundUrl(String soundUrl) {
        this.soundUrl = soundUrl;
    }

    public String getMakesSound() {
        return this.makesSound;
    }

    public void setMakesSound(String makesSound) {
        this.makesSound = makesSound;
    }
}
