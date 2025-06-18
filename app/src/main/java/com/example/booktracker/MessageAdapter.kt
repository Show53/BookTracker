import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.booktracker.Message
import com.example.booktracker.R
import java.text.SimpleDateFormat
import java.util.*

class MessageAdapter(
    private val activityList: List<Message>
) : RecyclerView.Adapter<MessageAdapter.ActivityViewHolder>() {

    class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView.findViewById(R.id.message_text_data)
        val createdAt: TextView = itemView.findViewById(R.id.message_datetime_data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_message, parent, false)
        return ActivityViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val message = activityList[position]
        holder.content.text = message.content

        val formatter = SimpleDateFormat("dd MMMM yyyy HH:mm", Locale("ru"))
        holder.createdAt.text = formatter.format(message.createdAt)
    }

    override fun getItemCount(): Int = activityList.size
}