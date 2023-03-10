package com.edu.domain.model.user.events;

import com.edu.domain.common.event.DomainEvent;
import com.edu.domain.model.user.User;
import org.springframework.util.Assert;

public class UserRegisteredEvent extends DomainEvent {

  private static final long serialVersionUID = 2580061707540917880L;

  private User user;

  public UserRegisteredEvent(Object source, User user) {
    super(source);
    Assert.notNull(user, "Parameter `user` must not be null");
    this.user = user;
  }

  public User getUser() {
    return this.user;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserRegisteredEvent that = (UserRegisteredEvent) o;
    return that.user.equals(this.user);
  }

  public int hashCode() {
    return this.user.hashCode();
  }

  public String toString() {
    return "UserRegisteredEvent{" +
      "user='" + user + '\'' +
      "timestamp='" + getTimestamp() + '\'' +
      '}';
  }
}
