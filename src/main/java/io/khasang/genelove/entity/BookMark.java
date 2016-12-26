package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Закладки(понравившиеся пользователи)
 */

@Entity
public class BookMark {
    public BookMark() {
    }

    @Id
    private long id;
    private long userId;
    private long markUserId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getMarkUserId() {
        return markUserId;
    }

    public void setMarkUserId(long markUserId) {
        this.markUserId = markUserId;
    }
}
