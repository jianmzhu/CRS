package cn.crs.reserve.entity;

import java.util.Date;

public class CarTimesDtl extends CarTimesDtlKey {
    private Integer bookId;

    private Date bookTimestamp;

    private String bookUserJobno;

    private String bookSumm;

    private String bookFrom;

    private String bookTo;

    private String bookTimes;

    private String checkUserJobno;

    private Integer checkFlag;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getBookTimestamp() {
        return bookTimestamp;
    }

    public void setBookTimestamp(Date bookTimestamp) {
        this.bookTimestamp = bookTimestamp;
    }

    public String getBookUserJobno() {
        return bookUserJobno;
    }

    public void setBookUserJobno(String bookUserJobno) {
        this.bookUserJobno = bookUserJobno == null ? null : bookUserJobno.trim();
    }

    public String getBookSumm() {
        return bookSumm;
    }

    public void setBookSumm(String bookSumm) {
        this.bookSumm = bookSumm == null ? null : bookSumm.trim();
    }

    public String getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(String bookFrom) {
        this.bookFrom = bookFrom == null ? null : bookFrom.trim();
    }

    public String getBookTo() {
        return bookTo;
    }

    public void setBookTo(String bookTo) {
        this.bookTo = bookTo == null ? null : bookTo.trim();
    }

    public String getBookTimes() {
        return bookTimes;
    }

    public void setBookTimes(String bookTimes) {
        this.bookTimes = bookTimes == null ? null : bookTimes.trim();
    }

    public String getCheckUserJobno() {
        return checkUserJobno;
    }

    public void setCheckUserJobno(String checkUserJobno) {
        this.checkUserJobno = checkUserJobno == null ? null : checkUserJobno.trim();
    }

    public Integer getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Integer checkFlag) {
        this.checkFlag = checkFlag;
    }
}