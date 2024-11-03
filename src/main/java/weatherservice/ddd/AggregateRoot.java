
package weatherservice.ddd;

public interface AggregateRoot<I extends DomainId, V extends ValueWS> {
    I getId();

    V getValueWS();
}
