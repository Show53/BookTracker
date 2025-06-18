import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booktracker.Book
import com.example.booktracker.CombinedBookAndReadingProgress
import com.example.booktracker.R
import com.example.booktracker.ReadingProgress
import com.example.learning2.DetailedBookFragment
import java.util.Date


class ListActivityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_activity_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val sampleData = listOf(
            CombinedBookAndReadingProgress(
                book = Book(
                    id = 0,
                    coverUri = "file:///C:/Users/zorin/OneDrive/Рабочий%20стол/book_covers/book_cover_0.jpg",
                    description = "Роман «Война и мир»...",
                    rating = 5.01,
                    writeDate = "1873",
                    title = "Война и мир",
                    author = "Лев Толстой",
                    genre = "Русская классика",
                    pageCount = 5000,
                    isbn = "978-5-00180-336-2",
                    status = Status.Current
                ),
                readingProgress = ReadingProgress(
                    progressId = 0,
                    bookId = 0,
                    percentRead = 0.1,
                    finishDate = Date(),
                    lastUpdate = Date(),
                    pagesRead = 1200,
                    startDate = Date()
                )
            ),
            CombinedBookAndReadingProgress(
                book = Book(
                    id = 1,
                    coverUri = "file:///C:/Users/zorin/OneDrive/Рабочий%20стол/book_covers/book_cover_1.jpg",
                    description = "Гоголь ощущал себя...",
                    rating = 5.01,
                    writeDate = "1842",
                    title = "Мертвые души",
                    author = "Николай Гоголь",
                    genre = "Русская классика",
                    pageCount = 585,
                    isbn = "978-5-907363-26-7",
                    status = Status.Current
                ),
                readingProgress = ReadingProgress(
                    progressId = 1,
                    bookId = 1,
                    percentRead = 0.1,
                    finishDate = Date(),
                    lastUpdate = Date(),
                    pagesRead = 0,
                    startDate = Date()
                )
            )
        )

//        val adapter = CurrentBooksActivityAdapter(sampleData) { combinedItem ->
            // Обработка клика по карточке
            // Открываем DetailFragment с передачей данных
//            val fragment = DetailedBookFragment.newInstance(combinedItem)
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.nav_fragment, fragment)
//                .addToBackStack(null)
//                .commit()
//        }
//        recyclerView.adapter = adapter
    }
}