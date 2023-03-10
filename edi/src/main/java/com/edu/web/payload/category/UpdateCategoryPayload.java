package com.edu.web.payload.category;

import com.edu.domain.application.commands.category.UpdateCategoryCommand;
import com.edu.domain.model.user.UserId;

public class UpdateCategoryPayload {
  private Long id;
  private String newName;

  public UpdateCategoryCommand toCommand(UserId userId) {
    return new UpdateCategoryCommand(userId, id, newName);
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setNewName(String newName) {
    this.newName = newName;
  }


}
