package com.example.learning2

import MessageAdapter
import Status
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booktracker.Book
import com.example.booktracker.Message
import com.example.booktracker.R
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

class DetailedBookFragment : Fragment() {

    private lateinit var book: Book
    private val messages = mutableListOf<Message>()
    private lateinit var adapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        book = Book(
            id = 1,
            coverUri = "",
            title = "Преступление и наказание",
            author = "Фёдор Достоевский",
            genre = "Русская классика",
            rating = 4.5,
            writeDate = "1866",
            pageCount = 600,
            isbn = "978-5-17-118366-3",
            status = Status.Current,
            description = ""
        )


        messages.addAll(
            listOf(
                Message(id = 1, content = "Очень сложный, но мощный роман!", createdAt = Date(), bookId = 1, userId = 1),
                Message(id = 2, content = "А мне не понравилось — слишком депрессивно.", createdAt = Date(), bookId = 1, userId = 1),
                Message(id = 3, content = "Главная мысль глубокая, хочется перечитать.", createdAt = Date(), bookId = 1, userId = 1)
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.detailed_list_item_fragment_activities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.list_item_book_name).text = book.title
        view.findViewById<TextView>(R.id.list_item_book_author).text = book.author
        view.findViewById<TextView>(R.id.list_item_book_genre_data).text = book.genre
        view.findViewById<TextView>(R.id.list_item_book_rating_data).text = book.rating.toString()
        view.findViewById<TextView>(R.id.list_item_book_write_date_data).text = book.writeDate
        view.findViewById<TextView>(R.id.list_item_book_count_of_pages_data).text = book.pageCount.toString()
        view.findViewById<TextView>(R.id.list_item_book_isbn_data).text = book.isbn

        val bookCover = view.findViewById<ImageView>(R.id.list_item_book_image)
        if (book.coverUri.isNotBlank()) {
            Glide.with(requireContext())
                .load(book.coverUri)
                .placeholder(R.drawable.placeholder_book_cover)
                .into(bookCover)
        } else {
            bookCover.setImageResource(R.drawable.placeholder_book_cover)
        }


        val recyclerView = view.findViewById<RecyclerView>(R.id.fragment_activities_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = MessageAdapter(messages)
        recyclerView.adapter = adapter

        // Обработка ввода сообщения (можно добавить кнопку позже)
        val messageInput = view.findViewById<TextInputEditText>(
            R.id.detailed_list_item_fragment_activities_message_text_input_edit
        )

        messageInput.doOnTextChanged { text, _, _, _ ->
            if (!text.isNullOrBlank() && text.endsWith("\n")) {
                val cleanText = text.trim().toString()
                if (cleanText.isNotEmpty()) {
                    val newMessage = Message(
                        id = messages.size + 1,
                        content = cleanText,
                        createdAt = Date(),
                        bookId = 1,
                        userId = 1
                    )
                    messages.add(0, newMessage)
                    adapter.notifyItemInserted(0)
                    recyclerView.scrollToPosition(0)
                }
                messageInput.setText("")
            }
        }
    }
}
