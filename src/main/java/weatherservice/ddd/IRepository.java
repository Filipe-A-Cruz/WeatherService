
package weatherservice.ddd;

public interface IRepository<I extends DomainId, V extends ValueWS, T extends AggregateRoot<I, V>> {
    boolean save(T entity);
}
