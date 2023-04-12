// 表示每个模块都会用到的公共信息
package common;


// 表示一个文档对象（HTML对象）
public class DocInfo {
    // docId 文档的唯一身份标识（不能重复）
    private int docId;
    // 该文档的标题，可以简单粗暴地使用文件名来表示
    private String title;
    // 该文档对应的线上url
    private String url;
    // 该文档的正文，去掉HTML中的标签
    private String content;

    @Override
    public String toString() {
        return "DocInfo{" +
                "docId=" + docId +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
// 需要加上getter, setter 和 toString 方法
}