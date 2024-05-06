package repositories.interfaces.utils;

import org.hibernate.Session;
import org.hibernate.Transaction;
import repositories.interfaces.TransactionalOperation;

public class TransactionUtil {
    public static <T> boolean performTransactionalOperation(TransactionalOperation<T> operation, T entity, Session session) {
        Transaction transaction = session.beginTransaction();
        try {
            boolean result = operation.execute(session, entity);
            transaction.commit();
            session.close();
            return result;
        } catch (Exception ex) {
            System.out.println("Error while processing transactional operation, reason: " + ex.getMessage());
            transaction.rollback();
            return false;
        }
    }
}