package io.khasang.genelove.model;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.ui.Model;

public class Utils {
    public static PagedListHolder paginateList(PagedListHolder myList, String page, int pageSize, Model model){
        myList.setPageSize(pageSize);

        if (page != null) {
            if ("previous".equals(page)) {
                myList.previousPage();
            } else if ("next".equals(page)) {
                myList.nextPage();
            } else{
                myList.setPage(Integer.parseInt(page));
            }
        }

        model.addAttribute("myList", myList);

        return myList;
    }
}
