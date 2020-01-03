package com.example.basemodule.base.list;


/**
 * Desc: 列表请求的页码管理类

 */
public class PageIndicator {

    private int curPage;
    public static final int START = 0;

    PageIndicator() {
        firstPage();
    }

    void nextPage() {
        curPage++;
    }

    int getCurPage() {
        return curPage;
    }

    void firstPage() {
        curPage = START;
    }
}
