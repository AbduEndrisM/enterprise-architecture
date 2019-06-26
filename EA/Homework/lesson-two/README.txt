1. @Data: https://projectlombok.org/features/Data
@Data is a convenient shortcut annotation that bundles the features of
@ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together


2. hibernate.current_session_context_class

https://www.journaldev.com/2903/org-hibernate-hibernateexception-no-currentsessioncontext-configured

From the method body, it became clear that the value of this property should be:

jta for getting JTASessionContext
managed for ManagedSessionContext
thread for ThreadLocalSessionContext


<property name="hibernate.current_session_context_class">thread</property>

or

<property name="hibernate.current_session_context_class">
org.hibernate.context.internal.ThreadLocalSessionContext
</property>

3. persistence.xml vs hibernate.cfg.xml
https://stackoverflow.com/questions/3807503/what-is-the-purpose-of-two-config-files-for-hibernate


4.

org.hibernate.jpa.HibernatePersistenceProvider
