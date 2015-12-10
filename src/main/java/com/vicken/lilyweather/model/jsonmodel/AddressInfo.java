package com.vicken.lilyweather.model.jsonmodel;

/**
 * Created by ccit on 2015/12/10.
 */
public class AddressInfo {

    private String id;
    private String name;
    private String FullName;
    private String ParentId;
    private String zip;

    @Override
    public String toString() {
        return "AddressInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", FullName='" + FullName + '\'' +
                ", ParentId='" + ParentId + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getParentId() {
        return ParentId;
    }

    public void setParentId(String parentId) {
        ParentId = parentId;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
