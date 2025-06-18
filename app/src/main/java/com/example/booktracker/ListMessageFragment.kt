package com.example.learning2

import MessageAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booktracker.Message
import com.example.booktracker.R
import java.util.Date

class ListMessageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.detailed_list_item_fragment_activities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.fragment_activities_recycler_view)

        val testMessages = listOf(
            Message(
                id = 1,
                bookId = 1,
                userId = 1,
                content = "Привет, как дела?",
                createdAt = Date()
            ),
            Message(
                id = 2,
                bookId = 1,
                userId = 1,
                content = "Сегодня отличная погода!",
                createdAt = Date()
            ),
            Message(
                id = 3,
                bookId = 1,
                userId = 1,
                content = "Не забудь про встречу в 18:00.",
                createdAt = Date()
            )
        )

        val adapter = MessageAdapter(testMessages)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
}