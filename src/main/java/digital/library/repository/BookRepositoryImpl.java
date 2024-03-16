package digital.library.repository;

import digital.library.entity.Book;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static digital.library.generated.public_.Tables.*;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final DSLContext dslContext;

    public BookRepositoryImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<Book> findAllAvailableBooks() {
        Result<Record> records = dslContext.select(BOOK.fields())
                .from(BOOK)
                .leftJoin(BORROWED).on(BOOK.ID.eq(BORROWED.BOOK_ID))
                .where(BORROWED.BORROWED_TO.isNull().or(BORROWED.BORROWED_TO.lt(LocalDate.now())))
                .fetch();

        return toBook(records);
    }

    public List<Book> findAllBorrowedByUserOnDateRange(Integer userId, LocalDate from, LocalDate to) {
        // TODO
        return null;
    }

    private List<Book> toBook(Result<Record> records) {
        return records.map(record ->
                new Book(
                        record.getValue(BOOK.ID),
                        record.getValue(BOOK.TITLE),
                        record.getValue(BOOK.AUTHOR),
                        record.getValue(BOOK.GENRE),
                        record.getValue(BOOK.PUBLISHER)
                )
        );
    }
}
