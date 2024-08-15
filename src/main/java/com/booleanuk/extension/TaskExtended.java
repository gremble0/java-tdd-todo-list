package com.booleanuk.extension;

import java.time.LocalDateTime;
import com.booleanuk.core.Task;

public class TaskExtended extends Task {
  public LocalDateTime dateAdded;

  public TaskExtended(String description, boolean completed, LocalDateTime dateAdded) {
    super(description, completed);
    this.dateAdded = dateAdded;
  }

  public TaskExtended(String description, LocalDateTime dateAdded) {
    this(description, false, dateAdded);
  }
}
