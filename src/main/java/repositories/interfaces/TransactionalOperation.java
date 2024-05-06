
package repositories.interfaces;

import org.hibernate.Session;

public interface TransactionalOperation<T> {
    boolean execute(Session session, T entity);
}
