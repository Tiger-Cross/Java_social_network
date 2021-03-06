package socialnetwork.domain.BaseDomains;

import java.util.Optional;
import socialnetwork.domain.Backlog;
import socialnetwork.domain.SetImplementations.Sequential.SequentialSet;
import socialnetwork.domain.Task;

public class BaseBacklog extends SequentialSet implements Backlog {

  @Override
  public boolean add(Task task) {
    return super.add(task);
  }

  @Override
  public Optional<Task> getNextTaskToProcess() {
    if (size() != 0) {
      Task nextTask = (Task) getFirst().item(); // had to Downcast here
      if (remove(nextTask)) {
        return Optional.of(nextTask);
      }
    }
    return Optional.empty();
  }

  @Override
  public int numberOfTasksInTheBacklog() {
    return super.size();
  }
}
