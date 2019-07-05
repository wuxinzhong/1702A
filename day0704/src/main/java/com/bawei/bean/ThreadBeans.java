package com.bawei.bean;

/**
 * <p>文件描述：线程的信息<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/4/004<p>
 * <p>更改时间：2019/7/4/004<p>
 */
public class ThreadBeans {
    private int id;
    private String url;
    private int start;
    private int end;
    private int finished;

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

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "ThreadBeans{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", finished=" + finished +
                '}';
    }

    public ThreadBeans() {
    }

    public ThreadBeans(int id, String url, int start, int end, int finished) {
        this.id = id;
        this.url = url;
        this.start = start;
        this.end = end;
        this.finished = finished;
    }
}
