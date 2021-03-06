package socialnetwork.domain.LockFreeDomains;

import java.util.List;
import socialnetwork.domain.Board;
import socialnetwork.domain.Message;
import socialnetwork.domain.SetImplementations.LockFree.LockFreeSet;

public class LockFreeBoard extends LockFreeSet implements Board {

  @Override
  public boolean addMessage(Message message) {
    return super.add(message);
  }

  @Override
  public boolean deleteMessage(Message message) {
    return super.remove(message);
  }

  @Override
  public int size() {
    return super.size();
  }

  @Override
  public List<Message> getBoardSnapshot() {
    return toArrayList();
  }

}
