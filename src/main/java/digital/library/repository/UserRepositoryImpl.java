package digital.library.repository;

import digital.library.entity.User;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static digital.library.generated.public_.Tables.BORROWED;
import static digital.library.generated.public_.Tables.LIBRARY_USER;


@Repository
public class UserRepositoryImpl implements UserRepository {
    private final DSLContext dslContext;

    public UserRepositoryImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<User> findAllWhoBorrowedBooks() {
        Result<Record> records = dslContext.selectDistinct(LIBRARY_USER.fields())
                .from(LIBRARY_USER)
                .join(BORROWED).on(LIBRARY_USER.ID.eq(BORROWED.BORROWER_ID))
                .fetch();

        return toUser(records);
    }

    public List<User> findAllNonTerminatedWhoHasNoBorrowedBooksNow() {
        // TODO
        return null;
    }

    public List<User> findAllWhoBorrowedBooksOnDate(LocalDate date) {
        Result<Record> records = dslContext.select(LIBRARY_USER.fields())
                .from(LIBRARY_USER)
                .join(BORROWED).on(LIBRARY_USER.ID.eq(BORROWED.BORROWER_ID))
                .where(BORROWED.BORROWED_FROM.eq(date))
                .fetch();

        return toUser(records);
    }

    private List<User> toUser(Result<Record> records) {
        return records.map(record ->
                new User(
                        record.getValue(LIBRARY_USER.ID),
                        record.getValue(LIBRARY_USER.NAME),
                        record.getValue(LIBRARY_USER.FIRST_NAME),
                        record.getValue(LIBRARY_USER.MEMBER_SINCE),
                        record.getValue(LIBRARY_USER.MEMBER_TILL),
                        record.getValue(LIBRARY_USER.GENDER)
                )
        );
    }
}
