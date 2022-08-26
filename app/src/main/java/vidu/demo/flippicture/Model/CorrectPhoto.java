package vidu.demo.flippicture.Model;

import java.util.List;

public class CorrectPhoto {
    private int idPhoto;
    private int imagePhotoNeedToFind ;
    private List<PhotoAnswer> list;

    public CorrectPhoto() {
    }

    public CorrectPhoto(int idPhoto, int imagePhotoNeedToFind, List<PhotoAnswer> list) {
        this.idPhoto = idPhoto;
        this.imagePhotoNeedToFind = imagePhotoNeedToFind;
        this.list = list;
    }

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public int getImagePhotoNeedToFind() {
        return imagePhotoNeedToFind;
    }

    public void setImagePhotoNeedToFind(int imagePhotoNeedToFind) {
        this.imagePhotoNeedToFind = imagePhotoNeedToFind;
    }

    public List<PhotoAnswer> getList() {
        return list;
    }

    public void setList(List<PhotoAnswer> list) {
        this.list = list;
    }
}
