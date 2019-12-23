package com.example.dev.RefreshTest;


/**
 * Desc: 列表请求的页码管理类

 */
public class PageIndicator {
    /**
     * 默认每页30个
     */
    public final static int PAGE_PER_SIZE = 30;
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
