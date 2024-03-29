package com.bawei.bean;

import java.io.Serializable;

/**
 * <p>文件描述：文件信息<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/4/004<p>
 * <p>更改时间：2019/7/4/004<p>
 */
public class Beans implements Serializable {
    private int id;
    private String url;
    private String fileName;
    private int length;
    private int finished;

    public Beans() {
        super();
    }

    public Beans(int id, String url, String fileName, int length, int finished) {
        this.id = id;
        this.url = url;
        this.fileName = fileName;
        this.length = length;
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Beans{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", fileName='" + fileName + '\'' +
                ", length=" + length +
                ", finished=" + finished +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }
}
