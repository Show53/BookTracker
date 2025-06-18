import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booktracker.CombinedBookAndReadingProgress
import com.example.booktracker.R
import java.text.SimpleDateFormat
import java.util.Locale

class CurrentBooksActivityAdapter(
    private val activityList: List<CombinedBookAndReadingProgress>,
    private val onItemClick: (CombinedBookAndReadingProgress) -> Unit
) : RecyclerView.Adapter<CurrentBooksActivityAdapter.ActivityViewHolder>() {

    class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookName: TextView = itemView.findViewById(R.id.list_item_book_name)
        val bookAuthor: TextView = itemView.findViewById(R.id.list_item_book_author)
        val bookGenre: TextView = itemView.findViewById(R.id.list_item_book_genre)
        val readingDatetimeView: TextView = itemView.findViewById(R.id.list_item_datetime_data)
        val readItPagesView: TextView = itemView.findViewById(R.id.list_item_progress_read_it_data)
        val totalPagesView: TextView = itemView.findViewById(R.id.list_item_progress_total_data)
        val bookImageView: ImageView = itemView.findViewById(R.id.list_item_book_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_fragment_activities, parent, false)
        return ActivityViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val combinedItem = activityList[position]

        holder.bookName.text = combinedItem.book.title
        holder.bookAuthor.text = combinedItem.book.author
        holder.bookGenre.text = combinedItem.book.genre

        val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale("ru"))
        holder.readingDatetimeView.text = dateFormat.format(combinedItem.readingProgress.startDate)

        holder.readItPagesView.text = String.format(Locale.getDefault(), "%d", combinedItem.readingProgress.pagesRead)
        holder.totalPagesView.text = String.format(Locale.getDefault(), "%d", combinedItem.book.pageCount)

        val uriString = combinedItem.book.coverUri
        if (uriString.isNotEmpty()) {
            Glide.with(holder.itemView.context)
                .load(uriString)
                .placeholder(R.drawable.placeholder_book_cover)
                .error(R.drawable.error_book_cover)
                .into(holder.bookImageView)
        } else {
            holder.bookImageView.setImageResource(R.drawable.error_book_cover)
        }

        // 👇 Обработка клика

    }

    override fun getItemCount(): Int = activityList.size
}